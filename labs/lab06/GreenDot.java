import java.util.Random;
/**
 * This class allows the user to create GreenDot's on their plotter.
 * Every four steps a GreenDot will randomly choose to move left
 * or right or straight in a diagonal direction and continue in that
 * direction until it chooses again
 * @author Charlie Francesconi
 */
public class GreenDot extends MovingDot {
    // Random object for this GreenDot's choice in movement
    private Random r = new Random();

    /**
     * Constructor for a GreenDot
     * @param r row for this GreenDot to initally spawn on
     * @param c column for this GreenDot to initally spawn on
     */
    public GreenDot(int r, int c) {
        super(r, c);
    }

    /**
     * Updates this GreenDot's position on the plot by randomly
     * choosing to move left or right or straight in a diagonal
     * dirction every four steps
     */
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
    
    /**
     * Prints this GreenDot's positon and color as a single character
     * @return string contaning the row, col, and color of the dot
     */
    public String toString() {
        return super.toString() + " g";
    }

}
