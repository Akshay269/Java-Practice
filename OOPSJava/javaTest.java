package OOPSJava;

interface Messenger {

    void sendMessage(String recipient, String message);
}

class EmailMessenger implements Messenger {

    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending email to " + recipient + "message is " + message + "throguh email");
    }

}

class SMSMessenger implements Messenger {

    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending sms to " + recipient + "message is " + message + "throguh sms");
    }

}

class NotificationService {

    private final Messenger messenger;

    public NotificationService(Messenger messenger) {
        this.messenger = messenger;
    }

    public void notifyUser(String user, String message) {
        messenger.sendMessage(user, message);
    }

}

class javaTest {

    public static void main(String[] args) {
        Messenger Emailmessenger = new EmailMessenger();

        NotificationService emNotificationService = new NotificationService(Emailmessenger);

        emNotificationService.notifyUser("Akhay", "Hello");


        Messenger smsSender = new SMSMessenger();
        NotificationService smsNotification = new NotificationService(smsSender);
        smsNotification.notifyUser("Bob", "Your account is active.");
    }

}
