package Factory;

public class NotificationFactory {
    
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        if (type.equalsIgnoreCase("SMS")) {
            return new SmsService();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailService();
        }
        // Handle unknown types safely
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}