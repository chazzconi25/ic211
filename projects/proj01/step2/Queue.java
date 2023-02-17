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
}




