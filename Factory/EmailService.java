
package Factory;
public class EmailService implements Notification{
    @Override
    public void send(){
        System.out.println("sms sent");
    }
}