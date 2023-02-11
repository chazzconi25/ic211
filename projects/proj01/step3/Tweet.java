import java.util.*;
public class Tweet {
    private String newtext;
    private String newuser;
    private int year;
    private int month;
    private int day;

    public Tweet(String newtext, String newuser, String newdate) {
        this.newuser = newuser;
        this.newtext = newtext;
        String [] dateVals = newdate.split("-");
        this.year = Integer.parseInt(dateVals[0]);
        this.month = Integer.parseInt(dateVals[1]);
        this.day = Integer.parseInt(dateVals[2]);
    }

    public String toString() {
        return newtext + "  [" + newuser + "]  " +  month + "/"
                + day + "/" + year; 
    }

    public static Tweet read(Scanner in) {
        String [] tweetText = in.nextLine().split("\t");
        return new Tweet(tweetText[0], tweetText[1], tweetText[2]);
    }

    public boolean containsKeyword(String keyword) {
        return newtext.toLowerCase().contains(keyword);
    }
}