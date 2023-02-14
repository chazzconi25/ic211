import java.util.*;
import java.io.*;
/**
 * This program allows the user to query a given tweet data
 * file for tweets based on if the tweet contains or does not contain
 * a certain word. To query a word the user just needs to enter the
 * String. To query tweets without a word a - can be added to the
 * front of the String. The user can also search for tweets based on
 * date by adding a + to the string representing the date string.
 * Each time a query is made a subset of tweets matching the current
 * querys is availble to be printed using !dump. If the user wants
 * to reset all querys they can input !reset. To exit use !quit.
 * @author Charlie Francesconi
 */
public class Search {
    public static void main(String [] args) throws 
        FileNotFoundException {
        Scanner in = new Scanner(System.in);
        if(args.length != 1) {
            System.out.println("usage: java Search <tweets-file>");
        } else  {
            String cmd = "";
            Queue tweets = Queue.readFile(args[0]);
            Queue newQ = tweets;
            while(!cmd.equals("!quit")) {
                System.out.println("Queue size: " + newQ.length());
                System.out.print("? ");
                cmd = in.next();
                if(cmd.equals("!dump")) {
                    newQ.printAll();
                } else if(cmd.equals("!reset")) {
                    newQ = tweets;
                } else {
                    if(cmd.charAt(0) == '-') {
                        newQ = newQ.filterForNotKeyword(
                            cmd.substring(1));
                    } else if(cmd.charAt(0) == '+') {
                        newQ = newQ.filterForDate(cmd.substring(1));
                    } else  {
                        newQ = newQ.filterForKeyword(cmd);
                    }
                }
            }
            System.out.println("Goodbye!");
        }
    }
}
