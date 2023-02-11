import java.io.*;
import java.util.*;
/**
 * Queue interface for Node objects. Allows the user to add Strings
 * to Queue and remove in the order they were added or check if the
 * Queue is empty.
 */
public class Queue {   
    private class Node {
        public Tweet data;
        public Node next;
        public Node(Tweet d, Node n) {
          data = d;
          next = n;
        }
    } 
    Node head;
    Node tail;

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

    /**
    * adds s to the back of the queue
    * @args String to be added to back of queue
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
     * removes and returns string from the front of the queue
     * @return the string in the front of the queue
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
     * returns true if the queue is empty
     * @return true if queue is empty
     */
    public boolean empty() {
        return head == null;
    }

    public void printAll() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int length() {
        int len = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

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




