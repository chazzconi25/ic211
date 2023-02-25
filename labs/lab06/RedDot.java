import java.util.Random;

public class RedDot extends MovingDot {
    private Random r = new Random();

    public RedDot(int r, int c) {
        super(r, c);
    }

    public void step(){
        int next = r.nextInt(3);
        if(next == 0) {
            super.step();
        } else if (next == 1) {
            dir = 
        } else {
            right();
        }
    }
}
