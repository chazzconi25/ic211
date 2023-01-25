public class Foo {
    private double x = 0;
    private String s;

    public String getString() {
        return this.s;
    }

    public Foo(String s) {
        this.s = s;
        x++;
    }
    public static String disp() {
      return "[" + s + "," + x + "]";
    }
  }