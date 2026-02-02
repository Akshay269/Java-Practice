
import java.util.concurrent.Semaphore;

public class semaphore {

    private static final Semaphore bouncer = new Semaphore(3);

    public static void useResource() {
        try {
            bouncer.acquire(); //grab permit
            System.out.println("Resource accessed by " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Resource released by " + Thread.currentThread().getName());
            bouncer.release(); //release permit
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(semaphore::useResource, "Thread-" + (i + 1)).start();
        }
    }
}
