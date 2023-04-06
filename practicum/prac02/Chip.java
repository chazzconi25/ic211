import java.util.*;

/**
 * Represents a chip game peice. Chip can change color when shaken
 * and have a 50/50 chance of being black or white.
 * @author Francesconi, Charles
 */
public class Chip extends Piece {

    /**
     * Chip constructor takes a Random to set color on shake() calls
     * @param r game Random object for color randomization
     */
    public Chip(Random r) {
        super(r);
    }

    /**
     * Changes this Chip's color to black or white with 50/50 chance
     */
    public void shake() {
        black = r.nextBoolean();
    }
}
