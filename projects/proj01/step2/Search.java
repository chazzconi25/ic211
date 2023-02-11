import java.util.*;

import java.io.*;
public class Search {
    public static Queue readFile(String path) throws FileNotFoundException {
        Queue tweets = new Queue();
        File data = new File(path);
        Scanner in;
        in = new Scanner(data);
        while(in.hasNextLine()) {
            tweets.enqueue(Tweet.read(in));
        }
        return tweets;
    }
    public static void main(String [] args) throws FileNotFoundException {
        if(args.length != 1) {
            System.out.println("usage: java Search <tweets-file>");
        } else  {
            Queue tweets = readFile(args[0]);
            System.out.println("Queue size: " + tweets.length());
            tweets.printAll();
        }
    }
}
