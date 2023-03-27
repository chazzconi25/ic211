public class BPair<T> {
    T x, y;
    public BPair(T o1, T o2) {
      x = o1;
      y = o2;
    }
    public T first() { return x; }
    public T second() { return y; }
}