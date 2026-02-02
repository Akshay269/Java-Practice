import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class concurrentHashmap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String,Integer> inventory = new ConcurrentHashMap<>();
        inventory.put("Java books", 100);

        ExecutorService ex= Executors.newFixedThreadPool(10);

        for(int i=0;i<1000;i++){
            ex.submit(()->{
                //compute method is atomic - perfect for concurrent updates
                inventory.compute("Java books",(key,val)->val+1);
            });
        }
        ex.shutdown();
        Thread.sleep(2000);

        System.out.println("Final inventory count: " + inventory.get("Java books"));
    }
}
