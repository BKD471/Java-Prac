public class ThreadNaming {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Thread.currentThread().setName("Dhur");
                for (int i = 0; i < 5; i++) {

                    //Its indication to TS, that this thread is willing to pause and leave cpu
                    //for other threads to excute,TS might or night not agree
                    if(i==3) Thread.currentThread().yield();
                    System.out.println("I am " + Thread.currentThread().getName());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Thread.currentThread().setName("Bal");
                for (int i = 0; i < 7; i++) System.out.println("I am " + Thread.currentThread().getName());
            }
        });

        t1.setName("Dhur");
        t2.setName("Bal");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        //priority bolke kuch nahi hta,sab moh maya hay, Thread Scheduler(TS) pe hi depend karta hay dost
        //chahe kuch bhi karlo TS ke mood ke upar sab chlata h
        t1.start();
        t2.start();

        try{
            //Main thread is suspended/waiting until t2 ends/goes to dead state
            //I want main thread to wait until t2 completes its execution
            t2.join();
            t1.join(1);
            //main will wait for 1 ms, if t1 does not die by that time
            //it will execute  , 0-->wait forever

            //Thin of this like a relay race, one can only start if
            //its partners finsihes
        }catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println("I am main");
    }
}
