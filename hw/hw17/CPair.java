public class CPair {
    Fooable x, y;
    public CPair(Fooable o1, Fooable o2) {
      x = o1;
      y = o2;
    }
    public Fooable first() { return x; }
    public Fooable second() { return y; }
}