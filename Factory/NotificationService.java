
package Factory;
public class NotificationService {
    
    private NotificationFactory factory;

    // We pass the factory to the constructor (Dependency Injection friendly)
    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void sendAlert(String type) {
        // Step 1: Ask Factory for the object
        Notification notification = factory.createNotification(type);
        
        // Step 2: Use the object
        notification.send();
    }
}