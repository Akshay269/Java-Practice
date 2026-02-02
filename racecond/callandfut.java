package racecond;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callandfut {
    public static void main(String[] args) {
        

        ExecutorService ex = Executors.newSingleThreadExecutor();

        Callable<String> task = ()->{
            Thread.sleep(2000);
            return "Data fetched from the database";
        };

        System.out.println("Submitting task");


        Future<String> futureResult=ex.submit(task);

        System.out.println("main thread is free to do other work");

        String result= futureResult.get();

        System.out.println("Result from the task: "+result);

        ex.shutdown();


    }
}
