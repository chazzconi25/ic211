import java.util.*;

/**
 * Represents a tweet's text and its metadata. 
 * @author Charlie Francesconi
 */
public class Tweet {

    // Fields
    private String newtext;
    private String newuser;
    private int year;
    private int month;
    private int day;

    /**
     * Constructor for a Tweet object
     * @param newtext the message content of a Tweet
     * @param newuser the user who posted the Tweet
     * @param newDate the date a tweet was posted in format
     * yyyy-mm-dd
     */
    public Tweet(String newtext, String newuser, String newdate) {
        this.newuser = newuser;
        this.newtext = newtext;
        String [] dateVals = newdate.split("-");
        this.year = Integer.parseInt(dateVals[0]);
        this.month = Integer.parseInt(dateVals[1]);
        this.day = Integer.parseInt(dateVals[2]);
    }

    /**
     * Allows a Tweet Object to be printed in string form
     * @return String representation of a Tweet
     */
    public String toString() {
        return newtext + "\t[" + newuser + "]\t" +  month + "/"
                + day + "/" + year; 
    }

    /**
     * Creates tweet objects from the given Scanner source from
     * the next line in the source
     * @param in Scanner object at the destination of Tweet data
     * @return Tweet Object constructed using data passed
     */
    public static Tweet read(Scanner in) {
        String [] tweetText = in.nextLine().split("\t");
        return new Tweet(tweetText[0], tweetText[1], tweetText[2]);
    }
}