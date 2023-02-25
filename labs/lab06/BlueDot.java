import java.util.Random;

public class BlueDot extends MovingDot {
    private Random r = new Random();

    public BlueDot(int r, int c) {
        super(r, c);
    }

    public void step(){
        steps++;
        if(steps%10 == 0) {
            int next = r.nextInt(2);
            if(next == 1) {
                left();
            } else {
                right();
            }
        }
        super.step();
    }
    
    public String toString() {
        return super.toString() + " b";
    }
}
