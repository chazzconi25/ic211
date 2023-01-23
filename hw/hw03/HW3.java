import java.util.*;

public class HW3 {
    public static Mid createMid(Scanner in) {
        Mid x = new Mid();
        System.out.print("Alpha? ");
        x.alpha = in.next();
        System.out.print("First name? ");
        x.firstName = in.next();
        System.out.print("Last name? ");
        x.lastName = in.next();
        System.out.print("Company? ");
        x.company = in.nextInt();
        return x;
    }
    public static void printMid(Mid x) {
        System.out.println(x.alpha + " " + x.lastName + " " + x.firstName + " " + x.company);
    }

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many mids? ");
        Mid [] mids = new Mid [in.nextInt()];
        for(int i = 0; i < mids.length; i++) {
            mids[i] = createMid(in);
        }
        System.out.print("What company would you like to print out? ");
        int search = in.nextInt();
        for(int i = 0; i < mids.length; i++) {
            if(mids[i].company == search) {
                printMid(mids[i]);
            }
        }
    }
}