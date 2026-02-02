package Strategy;

interface Strategy {

    public void pay();
}

class Cash implements Strategy {

    @Override
    public void pay() {
        System.out.println("Paid via cash");
    }
}

class Card implements Strategy {

    @Override
    public void pay() {
        System.out.println("Paid via card");
    }
}

class UPI implements Strategy {

    @Override
    public void pay() {
        System.out.println("Paid via upi");
    }
}

class PaymentStrategy {

    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pay() {
        strategy.pay();
    }
}

public class strategyExample {

    public static void main(String[] args) {

        PaymentStrategy ps = new PaymentStrategy();
        Cash c = new Cash();
        ps.setStrategy(c);
        ps.pay();

        Card crd = new Card();
        ps.setStrategy(crd);
        ps.pay();

        UPI upi = new UPI();
        ps.setStrategy(upi);
        ps.pay();
    }
}
