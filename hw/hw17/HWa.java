
import java.util.*;

public class HWa {
  public static class APair {
    Object x, y;
    public APair(Object o1, Object o2) {
      x = o1;
      y = o2;
    }
    public Object first() { return x; }
    public Object second() { return y; }
  }
  public static void main(String[] args) {
    APair a = new APair(new Bat(7), new Pig("Q"));
    BPair<Bat> b = new BPair<Bat>(new Bat(8), new Bat(9));
    CPair c = new CPair(new Bat(5), new Pig("Z"));;
    System.out.println(((Bat)a.first()).foo());
    System.out.println(b.first().foo());
    System.out.println(((Bat)c.first()).foo());
    System.out.println(((Bat)a.first()).bar());
    System.out.println(b.first().bar());
    System.out.println(((Bat)c.first()).bar());
  }
}