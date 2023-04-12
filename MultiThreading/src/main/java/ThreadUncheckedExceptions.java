class ThreadUncaughtCheckedException {

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            public void run() {
                System.out.println("Now in thread "+Thread.currentThread().getName());
                System.out.println("Priority "+Thread.currentThread().getPriority());
                throw new RuntimeException();
            }
        });

        t.setName("Worker Thread");
        t.setPriority(Thread.MAX_PRIORITY);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("An exception ocuured at"+t.getName()+"of "+e.getMessage());
            }
        });
        t.start();

    }
}
