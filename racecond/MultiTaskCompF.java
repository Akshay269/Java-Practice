
import java.util.concurrent.CompletableFuture;

public class MultiTaskCompF {

    public static void main(String[] args) {

        CompletableFuture<String> Flights = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000);
            System.out.println("Flights data fetched");
            return "Flights data";
        });

        CompletableFuture<String> Hotels = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1500);
            System.out.println("Hotels data fetched");
            return "Hotels data";
        });

        CompletableFuture<String> Cars = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1200);
            System.out.println("Cars data fetched");
            return "Cars data";
        });

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(Flights, Hotels, Cars);

        allTasks.thenRun(() -> {
            try {
                String flightsData = Flights.get();
                String hotelsData = Hotels.get();
                String carsData = Cars.get();

                String combinedData = flightsData + " | " + hotelsData + " | " + carsData;
                System.out.println("Combined Result: " + combinedData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        simulateDelay(3000); // Wait for all async tasks to complete

    }

    private static void simulateDelay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
