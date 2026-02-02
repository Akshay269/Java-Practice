
package racecond;
import java.util.concurrent.CompletableFuture;

public class completableFut {
    public static void main(String[] args) {
        
       CompletableFuture.supplyAsync(()->{
              // Simulate a long-running task
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              return "Data fetched from the database";
       })
       .thenApply(data -> data + " | Processed")
       .thenAccept(finalData -> System.out.println("Final Result: " + finalData));

       System.out.println("Main thread is free to do other work...");

       try {
        Thread.sleep(2000); // Wait for async tasks to complete
       } catch (InterruptedException e) {
        e.printStackTrace();
       }
      

    }
}
