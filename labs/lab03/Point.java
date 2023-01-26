import java.util.*;
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point read(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point(x,y);
    }

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

    public String toString() {
        return this.x + " " + this.y;
    }

    public String print(Point max) {
        return this.x + " < x < " + max.x + ", " + this.y + " < y < " + max.y;
    }
}