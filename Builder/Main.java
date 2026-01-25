public class Main{
    public static void main(String[] args) {
        Car.CarBuilder builder=new Car.CarBuilder();
        Car car1=builder.setColor("Red").setEngine("engine").build();

        

    }
}