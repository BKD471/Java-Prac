import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 implements  Runnable{


    @Override
    public void run() {
        System.out.println("Task1 starting.....");
        for(int i=0;i<10;i++) {
            if(i==5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Running from task1");
        }
        System.out.println("Task1 ended....................");
    }
}

class Task2 implements  Runnable{
    @Override
    public void run() {
        System.out.println("Task2 starting.....");
        for(int i=0;i<10;i++) {
            if(i==6) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Running from task2");
        }
        System.out.println("Task2 ended...................");
    }
}

class Task3 implements  Runnable{
    @Override
    public void run() {
        System.out.println("Task3 starting.....");
        for(int i=0;i<10;i++) System.out.println("Running from task3");
        System.out.println("Task3 ended...................................");
    }
}


public class Executor {
    public static void main(String[] args) {
        //It executes one thread at a time
        ExecutorService executorService= Executors.newSingleThreadExecutor();
//        executorService.execute(new Task1());
//        executorService.execute(new Task2());
        //two threads will be executed sequentially

        System.out.println("===========================================================");
        //executes two threads at a time
        ExecutorService executorService1= Executors.newFixedThreadPool(2);
        executorService1.execute(new Task2());
        executorService1.execute(new Task3());


        executorService1.shutdown();
        executorService.shutdown();
    }
}

/*
* Notes:
* we use executor framework because in traditional way of creating threads
* we used to use threads per task which was not suitable for large applications with large threads counts
*for bigger app, it leads to added complexity to manage all of them
*resource consumption is also high so use Exe framework
*
* it has task queue for all tasks and thread pool
* thread from pool used to pick a task from queue and execute it and then return to pool
* unlike in ordinary setup ,thread does not get dead after completing the task
*
*
* The main difference between SingleThreadExecutor and a single Thread is that
*  the Executor Service creates a ThreadPoolExecutor under the hood which
* provides improved performance and when executing large number of asynchronous tasks
*
* */