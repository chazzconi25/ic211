import java.util.*;

/**
 * Represents a Die game peice with black and white sides.
 * Die can change color when shaken and have a chance of 
 * black or white detrmined by their number of black/white sides.
 * @author Francesconi, Charles
 */
public class Die extends Piece {

    // fields
    // number of white sides on this Die
    private int numWhite;
    // number of black sides on this Die
    private int numBlack;

    /**
     * Die constructor takes a Random to set color on shake() calls
     * and two ints representing the number of black and white sides
     * to this Die
     * @param r game Random object for color randomization
     * @param numWhite number of white sides on this Die
     * @param numBlack number of black sides on this Die
     */
    public Die(Random r, int numWhite, int numBlack) {
        super(r);
        this.numWhite = numWhite;
        this.numBlack = numBlack;
    }

    /**
     * Changes this Die's color to black or white based on the number
     * of black/white sides on this Die
     */
    public void shake() {
        int k = r.nextInt(numBlack + numWhite);
        black = k < numBlack;
    }
}
