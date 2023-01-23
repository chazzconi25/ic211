/*
 * This program takes in a number of mids from the user and
 * their information. The user is then prompted for a company
 * and the program prints all of the mids in that company.
 */
import java.util.*;

public class HW3 {
    /*
    * Mid object constructor
    * @param Scanner in takes in user infromation on Mids
    * @return Mid object with assigned fields
    */
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

    /*
     * prints out information for a given mid
     * @param Mid x is the mid object to be prited
     */
    public static void printMid(Mid x) {
        System.out.println(x.alpha + " " + x.lastName + " " + x.firstName + 
        " " + x.company);
    }
    
    /*
     * takes in a number of Mids and allows the user
     * to enter inforamtion for each mid and query them by
     * number.
     * @param args not implemented
     */
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