import java.util.*;

/**
 * Represents a ball game peice. Balls color are set when they are
 * initalized and do not change when shaken.
 * @author Francesconi, Charles
 */
public class Ball extends Piece {

    /**
     * Ball constructor takes a Random to set color on initalization
     * @param r game Random object for color randomization
     */
    public Ball(Random r) {
        super(r);
        black = r.nextBoolean();
    }


    /**
     * Balls do not change color so this method has no effect.
     */
    public void shake() {
        return;
    }
}
