import java.util.Random;

public class RedDot extends MovingDot {
    private Random r = new Random();

    public RedDot(int r, int c) {
        super(r, c);
    }

    public void step() {
        int next = r.nextInt(2);
        if (next == 0) {
            left();
        } else {
            right();
        }
        super.step();
    }

    public String toString() {
        return super.toString() + " r";
    }
}
