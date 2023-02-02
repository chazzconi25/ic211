/**
 * Box represents a bounding box that contains a series of points
 * added by the user.
 * @author Charlie Francesconi
 */
public class Box {
    private Point max;
    private Point min;
    
    /**
     * Creates a new Box given one point
     * @param p single point to add to a new Box
     */
    public Box(Point p) {
        max = p.max(p);
        min = p.min(p);
    }
    
    /**
     * Constructor for the Box containing two initial points
     * @param a first point to add to Box
     * @param b second point to add to Box
     */
    public Box(Point a, Point b) {
        max = a.max(b);
        min = a.min(b);
    }
    
    /**
     * Expands this bounding box (if needed) to include point p
     * @param p point to be added to this box
     */
    public void growBy(Point p) {
        max = p.max(max);
        min = p.min(min);
    }

    /**
     * Given point p in the bounding box, returns associated point 
     * in the unit square; returns null if p is not inside the
     * bounding box.
     * @param p Point to be mapped to the unit square of this Box
     * @return Point p mapped into the unit square of the Box if p
     * was inside box; otherwise null
     */
    public Point mapIntoUnitSquare(Point p) {
        return p.map(min,max);
    }

    /**
     * returns string representation Ex: 2.0 < x < 9.0, 3.0 < y < 7.0
     * @return a String reprentation of this Box 
     */
    public String toString() {
        return min.print(max);
    }
}