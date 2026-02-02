package racecond;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " started by " + threadName);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " completed by " + threadName);
            });
        }


        executor.shutdown();
        try{
          if(!executor.awaitTermination(60,TimeUnit.SECONDS)){
            executor.shutdown();
          }
        }catch(InterruptedException e){
            executor.shutdown();
        }

        System.out.println("All tasks done");

    }
}
