import java.util.*;

/**
 * Lab03 allows the user to input Cartesian points into the 
 * terminal to add them to a bounding box. After adding points the
 * user can map new points, print the box bounds or add more to the
 * box. When the user is finished they can enter "done" to exit.
 */
public class Lab03 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        Box box = null;
        String cmd = sc.next();
        while(!cmd.equals("done")) {
            if(cmd.equals("add")) {
                Point p = Point.read(sc);
                if(box == null) {
                    box = new Box(p);
                } else {
                    box.growBy(p);
                }
            } else if(cmd.equals("box")) {
                if(box == null) {
                    System.out.println("No box created, have a wonderful day!");
                } else {
                    System.out.println(box);
                }
            } else if(cmd.equals("map")) {
                Point p = Point.read(sc);
                p = box.mapIntoUnitSquare(p);
                if(p == null) {
                    System.out.println("error");
                } else {
                    System.out.println(p);
                }
            } else {
                System.out.println("Error! Unknown command \"" + cmd + "\"!");
            }
            cmd = sc.next();
        }
    }
}