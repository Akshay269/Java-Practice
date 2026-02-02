package racecond;

import java.util.concurrent.atomic.AtomicInteger;

public class race {
    // private static int counter=0;

    // private static synchronized void increament(){
    //     counter++;
    // }
 private static AtomicInteger counter=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
       
        Runnable task = ()->{
            for(int i=0;i<10000;i++){
                counter.incrementAndGet();
            }
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final "+counter);
        
    }
}
