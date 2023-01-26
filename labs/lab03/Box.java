public class Box {
    private Point max;
    private Point min;
    // constructor for Box that consists of a single point
    public Box(Point p) {
        max = p.max(p);
        min = p.min(p);
    }

    // constructor for the Box containing two initial points
    public Box(Point a, Point b) {
        max = a.max(b);
        min = a.min(b);
    }

    // growBy(p) expands the bounding box (if needed) to include point p
    public void growBy(Point p) {
        max = p.max(max);
        min = p.min(min);
    }

    // given point p in the bounding box, returns associated point in the
    // unit square (see notes); returns null if p is not inside the bounding box.
    public Point mapIntoUnitSquare(Point p) {
        if(p.getX() > max.getX() || p.getY() > max.getY()
            || p.getX() < min.getX() || p.getY() < min.getY()) {
                return null;
        }
        double width = max.getX() - min.getX();
        double height = max.getY() - min.getY();
        double newX =(p.getX() - min.getX())/width;
        double newY =(p.getY() - min.getY())/height;
        return new Point(newX, newY);
    }

    // returns string representation like: 2.0 < x < 9.0, 3.0 < y < 7.0
    public String toString() {
        return min.getX() + " < x < " + max.getX() + ", " + min.getY() +
                 " < y < " + max.getY();
    }
}