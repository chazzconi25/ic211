import java.util.*;
import java.io.*;

public class Search {
    public static void main(String [] args) throws FileNotFoundException {
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
                        newQ = newQ.filterForNotKeyword(cmd.substring(1));
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
