

//create a task that return a value back

//for creating a tas that retur a value implement callabl instead of runnable

import java.util.List;
import java.util.concurrent.*;

class CallableTask implements Callable<String>{

    private String stack;

    public CallableTask(String name){
        this.stack=name;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return String.format("Be the top 1 percentage of %s developers",stack);
    }
}
public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        Future<String> msg=executorService.submit(new CallableTask("SpringBoot"));

        //when we use callable we do submit and for runnable use execute

        //get doent not return val but it returns a promise
        //when we call get it waits for task to complete
        System.out.println(msg.get());
        executorService.shutdown();

        System.out.println();
        executorService=Executors.newFixedThreadPool(5);
        List<CallableTask> taskList=List.of(new CallableTask("SpringBoot"),
                new CallableTask("React"),
                new CallableTask("Nextjs"),new CallableTask("GraphQl"));

        //it returns a list of future when we use invokeall
        List<Future<String>> listOfFuturePromises=executorService.invokeAll(taskList);
        for(Future<String> task:listOfFuturePromises){
            System.out.println(task.get());
        }

        String fastestTask=executorService.invokeAny(taskList);
        System.out.println(fastestTask);
        //invoke any is used to return the fastest to complete of all

        //bothe ofthe cases uses 5 threads to execute the task, if we decrease thread count then task gets little longer
        executorService.shutdown();
    }
}
