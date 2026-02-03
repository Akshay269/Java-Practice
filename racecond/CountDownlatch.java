
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownlatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Main Thread: Starting data aggregation...");

        // Task 1: Fetch User Profile
        executor.submit(() -> {
            simulateNetworkDelay(1500);
            System.out.println("Service 1: User Profile fetched.");
            latch.countDown(); // Decrement counter
        });

        // Task 2: Fetch Recent Orders
        executor.submit(() -> {
            simulateNetworkDelay(1000);
            System.out.println("Service 2: Recent Orders fetched.");
            latch.countDown(); // Decrement counter
        });

        // Task 3: Fetch Loyalty Points
        executor.submit(() -> {
            simulateNetworkDelay(2000);
            System.out.println("Service 3: Loyalty Points fetched.");
            latch.countDown(); // Decrement counter
        });

        // Main thread waits here until the count is 0
        // Best practice: Use a timeout so you don't wait forever if a service fails!
        boolean finished = false;
        try {
            finished = latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Main Thread: Interrupted while waiting!");
        }

        if (finished) {
            System.out.println("Main Thread: All data ready. Building Dashboard!");
        } else {
            System.out.println("Main Thread: Timeout reached! Some services failed.");
        }

        executor.shutdown();

    }

    private static void simulateNetworkDelay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}
