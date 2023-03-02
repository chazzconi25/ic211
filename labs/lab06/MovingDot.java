/**
 * General class for MovingDot to be extended by other, more specific
 * dots that have different moving instructions per step or multi
 * steps.
 * @author Charlie Francesconi
 */
public class MovingDot extends Dot {
    // Tracks how many steps this dot has taken.
    protected int steps = 0;
    // Tracks the current direction of this dot
    private int dir = 0; // N = 0; E = 1, S = 2, W = 3

    /**
     * Constructor for a MovingDot
     * @param r row for this MovingDot to initally spawn on
     * @param c column for this MovingDot to initally spawn on
     */
    public MovingDot(int r, int c){
        super(r, c);
    }

    /**
     * Updates the positon of this MovingDot in a straight direction
     */
    public void step(){
        if(dir == 0) {
            incRow();
        } else if(dir == 1) {
            incCol();
        } else if(dir == 2) {
            decRow();
        } else {
            decCol();
        }
    }

    /**
     * Updates the position of this MovingDot in a diagonal direction
     */
    public void diagonal() {
        if(dir == 0) {
            incRow();
            decCol();
        } else if(dir == 1) {
            incRow();
            incCol();
        } else if(dir == 2) {
            decRow();
            incCol();
        } else {
            decRow();
            decCol();
        }
    }

    /**
     * Updates the direction of a MovingDot to left of its current
     * direction
     */
    public void left() {
        if(dir == 0) {
            dir = 3;
        } else if(dir == 1) {
            dir = 0;
        } else if(dir == 2) {
            dir = 1;
        } else {
            dir = 2;
        }
    }

    /**
     * Updates the direction of a MovingDot to right of its current
     * direction
     */
    public void right() {
        if(dir == 0) {
            dir = 1;
        } else if(dir == 1) {
            dir = 2;
        } else if(dir == 2) {
            dir = 3;
        } else {
            dir = 0;
        }
    }

    /**
     * Prints this MovingDot's positon
     * @return string contaning the row, col, and color of the dot
     */
    public String toString() {
        return super.toString();
    }
}
