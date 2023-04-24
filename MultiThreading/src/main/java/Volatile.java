public class Volatile {
    private static volatile boolean run=true;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(run) System.out.println("Running.....");
            }
        }).start();

        Thread.sleep(1000);
        run=false;
    }

/*
volatile gyuarntee memory visibilty

 * main thread halts for sometimes
 *  custom thread starts sees run as true goes into infinite loop
 * main thread resumes make run as false
 * thus custom thread reads the latest value of run since its volatile
 * and terminates
* */
}
