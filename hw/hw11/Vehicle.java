public class Vehicle {
    private String type;  // truck, car, motorcycle, plane
    private String model;
    private int mpg;
    protected int numWheels;
    protected boolean canfly;
  
    public Vehicle(String type, String model, int mpg) {
      this.type = type;
      this.model = model;
      this.mpg = mpg;
      this.numWheels = 4;
      canfly = false;
    }
  
    public String noise() {
      return "hmmmm";
    }

    public String toString() {
      return model + " " + noise() + " does" + (canfly ? "" : " not") + " fly with " + numWheels + " wheels.";
    }
  }