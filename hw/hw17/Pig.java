public class Pig implements Fooable {
    String lab;
    public Pig(String s) { lab = s; }
    public String foo() { return "Pig" + lab; }
  }