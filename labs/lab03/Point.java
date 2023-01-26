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

    public double len(Point p){
        return this.x - p.x;
    }

    public double height(Point p){
        return this.y - p.y;
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}