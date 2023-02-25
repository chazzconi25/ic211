import java.util.Random;

public class GreenDot extends MovingDot {
    private Random r = new Random();

    public GreenDot(int r, int c) {
        super(r, c);
    }

    public void step(){
        steps++;
        if(steps%4 == 0) {
            int next = r.nextInt(2);
            if(next == 1) {
                left();
            } else {
                right();
            }
        }
        super.diagonal();
    }
    
    public String toString() {
        return super.toString() + " b";
    }

}
