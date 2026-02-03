
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


//thread safe cache
public class PriceCache {

    private final Map<String, Double> prices = new HashMap<>();

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void updatePrice(String item, Double price) {
        rwLock.writeLock().lock(); //Block everyone

        try {
            System.out.println("Updating price of " + item + " to " + price);
            Thread.sleep(500);
            prices.put(item, price);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void getPrice(String item) {
        rwLock.readLock().lock();

        try {
            System.out.println("reader " + Thread.currentThread().getName() + " reading price of " + item + " = " + prices.get(item));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

        PriceCache cache = new PriceCache();

        cache.updatePrice("Laptop", 1222.00);

        // 3 Reader Threads
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    cache.getPrice("Laptop");

                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Reader-" + i).start();
        }

        //Writer Thread
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cache.updatePrice("Laptop", 1150.00 + Math.random() * 1000);
            }
        }, "Writer-").start();
    }

}
