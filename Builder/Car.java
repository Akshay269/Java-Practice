
public class Car {

    private String color;
    private String engine;
    private int wheels;

    private Car(CarBuilder builder) {
        this.color = builder.color;
        this.engine = builder.engine;
        this.wheels = builder.wheels;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public static class CarBuilder {

        private String engine;
        private String color = "blue";
        private int wheels = 4;

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(Integer wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder();
        Car car1 = builder.setColor("Red").setEngine("engine").build();
    }

}
