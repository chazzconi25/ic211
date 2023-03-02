public class Truck extends Vehicle {
    public Truck(String type, String model, int mpg) {
        super(type, model, mpg);
    }

    public String noise() {
        return "bumbumbum";
    }
}