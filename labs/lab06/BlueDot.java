import java.util.Random;

public class BlueDot extends MovingDot {
    private Random r = new Random();

    public BlueDot(int r, int c) {
        super(r, c);
    }

    /*public void step(){
        steps++;
        if(steps%10 == 0) {
            int next = r.nextInt(3);
            if(next == 0) {
                straight();
            } else if (next == 1) {
                left();
            } else {
                right();
            }
        }
    }*/
}
