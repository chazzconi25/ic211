import java.util.*;
/**
 * Point represents a point in a cartesian coordinate system
 * @author Charlie Francesconi
 */
public class Point {
    private double x;
    private double y;

    /**
     * Point constructor takes in an x and y value and assigns them
     * to the point to represent its position
     * @param x position on the x axis
     * @param y position on the y axis
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a new Point given a scanner object that searches for
     * an appropriate x and y value to add to the new Point
     * @param sc Used for taking in new Point x and y values
     * @return Point object with the x and y values found by
     * Scanner sc
     */
    public static Point read(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point(x,y);
    }

    /**
     * Compares this Point instance to point b and returns a new
     * Point that contains the highest x and y values of both points
     * @param b Point to compare with this Point
     * @return Point with highest x and y value of both points
     */
    public Point max(Point b) {
        double x,y;
        if(this.x > b.x) {
            x = this.x;
        } else {
            x = b.x;
        }
        if (this.y > b.y) {
            y = this.y; 
        } else {
            y = b.y;
        }
        return new Point(x,y); 
    }

    /**
     * Compares this Point instance to point b and returns a new
     * Point that contains the lowest x and y values of both points
     * @param b Point to compare with this Point
     * @return Point with lowest x and y value of both points
     */
    public Point min(Point b) {
        double x,y;
        if(this.x < b.x) {
            x = this.x;
        } else {
            x = b.x;
        }
        if (this.y < b.y) {
            y = this.y; 
        } else {
            y = b.y;
        }
        return new Point(x,y); 
    }

    /**
     * Tests to see if this Point is within a box given a minimum and
     * maximum point that represent bounds for a geometric shape. If
     * the point is in the box returns a Point in the unit square;
     * otherwise, return null
     * @param min minimum x and y of a geometric shape
     * @param max maximum x and y of a gemoetric shape
     * @return this Point mapped to the unit square of the min and max
     */
    public Point map(Point min, Point max){
        if(this.x > max.x || this.y > max.y || this.x < min.x
            || this.y < min.y) {
            return null;
        }
        double width = max.x - min.x;
        double height = max.y - min.y;
        double newX =(this.x - min.x)/width;
        double newY =(this.y - min.y)/height;
        return new Point(newX, newY);
    }

    /**
     * Returns String representation of this Point
     * @return String representation of this Point
     */
    public String toString() {
        return this.x + " " + this.y;
    }

    /**
     * Prints the minimum and maximum points to a bounding box. This
     * Point should be the minimum corner to the bounding box
     * 
     * Realistically this method should be attached to box but then
     * I wouldn't be able to access x and y because they're forced to
     * be private and I can't use getter methods. Also this method
     * would make more sense if it could be static but that's just my
     * opinion.
     * @param max represents the maximum corner to a bounding box
     * @return String representing the bounds of a bounding box
     */
    public String print(Point max) {
        return this.x + " < x < " + max.x + ", " + this.y + " < y < " + max.y;
    }
}