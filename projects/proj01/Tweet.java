import java.util.*;

/**
 * Represents a tweet's text and its metadata. 
 * @author Charlie Francesconi
 */
public class Tweet {
    
    // Fields
    private String text;
    private String user;
    private Date date;

    /**
     * Constructor for a Tweet object
     * @param newtext the message content of a Tweet
     * @param newuser the user who posted the Tweet
     * @param newdate the date a tweet was posted in format
     * yyyy-mm-dd
     */
    public Tweet(String newtext, String newuser, String newdate) {
        user = newuser;
        text = newtext;
        date = new Date(newdate);

    }

    /**
     * Allows a Tweet Object to be printed in string form
     * @return String representation of a Tweet
     */
    public String toString() {
        return text + "\t[" + user + "]\t" + date; 
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

    /**
     * Checks to see if this Tweet contains the given String in its
     * message regardless of case
     * @param keyword String to search for in this Tweet's message
     * @return True if the keyword is in this Tweet's message
     */
    public boolean containsKeyword(String keyword) {
        return text.toLowerCase().contains(keyword);
    }

    /**
     * Checks if a this Tweet was posted on a given date
     * @param comp Date object representing a date to check against
     * this Tweet's Date
     * @return True if this Tweet was posted on Date comp
     */
    public boolean onDate(Date comp) {
        return date.equals(comp);
    }
}