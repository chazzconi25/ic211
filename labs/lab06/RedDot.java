import java.util.Random;
/**
 * This class allows the user to create RedDot's on their plotter.
 * Every step a RedDot will randomly choose to move left or right or
 * straight and continue in that direction
 * @author Charlie Francesconi
 */
public class RedDot extends MovingDot {
    // Random object for this RedDot's choice in movement
    private Random r = new Random();

    /**
     * Constructor for a RedDot
     * @param r row for this RedDot to initally spawn on
     * @param c column for this RedDot to initally spawn on
     */
    public RedDot(int r, int c) {
        super(r, c);
    }

    /**
     * Updates this RedDot's position on the plot by randomly
     * chosing left, right, or straight at every step.
     */
    public void step() {
        int next = r.nextInt(2);
        if (next == 0) {
            left();
        } else {
            right();
        }
        super.step();
    }

    /**
     * Prints this RedDot's positon and color as a single character
     * @return string contaning the row, col, and color of the dot
     */
    public String toString() {
        return super.toString() + " r";
    }
}
