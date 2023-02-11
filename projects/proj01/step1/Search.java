import java.util.*;

import java.io.*;
public class Search {
    public static Tweet[] readFile(String path) throws FileNotFoundException {
        Tweet [] tweets = new Tweet[33];
        File data = new File(path);
        Scanner in;
        in = new Scanner(data);
        for(int i = 0; i < 33; i++) {
            tweets[i] = Tweet.read(in);
        }
        return tweets;
    }
    public static void main(String [] args) throws FileNotFoundException {
        if(args.length != 1) {
            System.out.println("usage: java Search <tweets-file>");
        } else  {
            Tweet [] tweets = readFile(args[0]);
            System.out.println("Array size: " + tweets.length);
            for(int i = 0; i < tweets.length; i++) {
                System.out.println(tweets[i]);
            }
        }
    }
}
