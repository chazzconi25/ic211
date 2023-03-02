import java.util.Random;
/**
 * This class allows the user to create BlueDot's on their plotter.
 * Every 10th step a BlueDot will randomly choose to move left or
 * right or straight and continue in that direction
 * @author Charlie Francesconi
 */
public class BlueDot extends MovingDot {
    // Random object for this BlueDot's choice in movement
    private Random r = new Random();

    /**
     * Constructor for a BlueDot
     * @param r row for this BlueDot to initally spawn on
     * @param c column for this BlueDot to initally spawn on
     */
    public BlueDot(int r, int c) {
        super(r, c);
    }

    /**
     * Updates this BlueDot's position on the plot by randomly
     * chosing left, right, or straight at every 10th step.
     */
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

    /**
     * Prints this BlueDot's positon and color as a single character
     * @return string contaning the row, col, and color of the dot
     */
    public String toString() {
        return super.toString() + " b";
    }
}
