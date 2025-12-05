
package Factory;
public class SmsService implements Notification {
    @Override
    public void send(){
        System.out.println("email sent");
    }
}