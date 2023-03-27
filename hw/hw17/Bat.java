public class Bat implements Fooable {
    int val;
    public Bat(int k) { val = k; }
    public String foo() { return "Bat" + val; }
    public int bar() { return val*val; }
  }