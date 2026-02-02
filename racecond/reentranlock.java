
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;



public class reentranlock {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void accessResource() {
        try {
            if (lock.tryLock(4, TimeUnit.SECONDS)) {
                System.out.println("Lock acquired by " + Thread.currentThread().getName());
                Thread.sleep(3000);
                lock.unlock();
                System.out.println("Lock released by " + Thread.currentThread().getName());
            } else {
                System.out.println("Failed to acquire lock within 2 seconds");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> accessResource(), "Thread-1");
        Thread t2 = new Thread(() -> accessResource(), "Thread-2");

        t1.start();
        t2.start();
    }
}
