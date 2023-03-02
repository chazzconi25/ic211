public class Car extends Vehicle {
    public Car(String type, String model, int mpg) {
        super(type, model, mpg);
    }

    public String noise() {
        return "vrooom";
    }
}
