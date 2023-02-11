import java.util.*;
public class Tweet {
    private String text;
    private String user;
    private Date date;

    public Tweet(String newtext, String newuser, String newdate) {
        user = newuser;
        text = newtext;
        date = new Date(newdate);

    }

    public String toString() {
        return text + "  [" + user + "]  " + date; 
    }

    public static Tweet read(Scanner in) {
        String [] tweetText = in.nextLine().split("\t");
        return new Tweet(tweetText[0], tweetText[1], tweetText[2]);
    }

    public boolean containsKeyword(String keyword) {
        return text.toLowerCase().contains(keyword);
    }

    public boolean onDate(Date comp) {
        return date.equals(comp);
    }
}