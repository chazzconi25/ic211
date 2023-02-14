import java.io.*;
import java.util.*;
/**
 * Queue interface for Node objects. Allows the user to add Tweets
 * to Queue and remove in the order they were added or check if the
 * Queue is empty. Can also get the length of the Queue or generate
 * new Queues with all of the Tweets in this Queue that contain or 
 * don't contain keywords or occured on a certain date.
 * @author Charlie Francesconi
 */
public class Queue {   
    /** 
     * Node for storing Tweets as data
     */
    private class Node {
        // Fields
        public Tweet data;
        public Node next;

        /**
         * Constructor for a Node
         * @param d Tweet stored in this node
         * @param n next Node in queue
         */
        public Node(Tweet d, Node n) {
          data = d;
          next = n;
        }
    } 

    // Fields
    Node head;
    Node tail;

    /**
     * Generates a Queue filled with Nodes that have Tweet objects
     * based on a data from a given file
     * @param path File tweet data is stored in
     * @return Queue containing all tweets in a datafile stored as
     * Tweet objects in Nodes.
     * @throws FileNotFoundException
     */
    public static Queue readFile(String path) throws 
            FileNotFoundException {
        Queue tweets = new Queue();
        File data = new File(path);
        Scanner in;
        in = new Scanner(data);
        while(in.hasNextLine()) {
            tweets.enqueue(Tweet.read(in));
        }
        return tweets;
    }

    /**
    * adds Tweet t to the back of this queue
    * @args t Tweet to be added to back of queue
    */
    public void enqueue(Tweet t) {
        Node temp = new Node(t, null);
        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    /**
     * removes and returns Tweet from the front of this queue
     * @return the Tweet in the front of the queue
     */
    public Tweet dequeue() {
        if(head == null) {
            return null;
        }
        Tweet ret = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return ret;
    }

    /**
     * returns true if this queue is empty
     * @return true if queue is empty
     */
    public boolean empty() {
        return head == null;
    }

    /**
     * prints all of the tweets in this Queue on individual lines
     */
    public void printAll() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * gives the length of this Queue
     * @return number of nodes in this Queue
     */
    public int length() {
        int len = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    /**
     * Creates a new Queue with all of the Tweets in this Queue
     * that have a message containing a given keyword
     * @param keyword String to search for in all Tweets in this
     * Queue
     * @return new Queue with all Tweets that contain String keyword
     * in this Queue
     */
    public Queue filterForKeyword(String keyword) {
        Queue newQ = new Queue();
        Node temp = head;
        while(temp != null) {
            if(temp.data.containsKeyword(keyword)) {
                newQ.enqueue(temp.data);
            }
            temp = temp.next;
        }
        return newQ;
    }

    /**
     * Creates a new Queue with none of the Tweets in this Queue
     * that have a message containing a given keyword
     * @param keyword String to search for in all Tweets in this
     * Queue to avoid
     * @return new Queue with none Tweets that contain String keyword
     * in this Queue
     */
    public Queue filterForNotKeyword(String keyword) {
        Queue newQ = new Queue();
        Node temp = head;
        while(temp != null) {
            if(!temp.data.containsKeyword(keyword)) {
                newQ.enqueue(temp.data);
            }
            temp = temp.next;
        }
        return newQ;
    }

    /**
     * Creates a new queue with all of the Tweets in this Queue
     * that were posted on a certain date
     * @param date date to search for Tweets posted on
     * @return new Queue with all of the tweets that were posted
     * on Date date in this Queue
     */
    public Queue filterForDate(String date) {
        Date dateComp = new Date(date);
        Queue newQ = new Queue();
        Node temp = head;
        while(temp != null) {
            if(temp.data.onDate(dateComp)) {
                newQ.enqueue(temp.data);
            }
            temp = temp.next;
        }
        return newQ;
    }
}




