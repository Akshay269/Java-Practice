package Factory;

public class Main {
    static void main(String[] args) {
      NotificationFactory factory = new NotificationFactory();
        NotificationService service = new NotificationService(factory);

        // Test SMS
        service.sendAlert("SMS");

        // Test Email
        service.sendAlert("EMAIL");
        
        // Test Exception (Validation)
        // service.sendAlert("FAX"); // Th
    }
}