/**
 * Queue interface for Node objects. Allows the user to add Events
 * to Queue and remove in the order they were added or check if the
 * Queue is empty. Can also get the length of the Queue or generate
 * new Queues with all of the Events in this Queue that contain or 
 * don't contain keywords or occured on a certain date.
 * @author Charlie Francesconi
 */
public class Queue {   
    /** 
     * Node for storing Events as data
     */
    private class Node {
        // Fields
        public Event data;
        public Node next;

        /**
         * Constructor for a Node
         * @param d Event stored in this node
         * @param n next Node in queue
         */
        public Node(Event d, Node n) {
          data = d;
          next = n;
        }
    } 

    // Fields
    Node head;
    Node tail;

    /**
    * adds Event t to the back of this queue
    * @param t Event to be added to back of queue
    */
    public void enqueue(Event t) {
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
     * returns true if this queue is empty
     * @return true if queue is empty
     */
    public boolean empty() {
        return head == null;
    }

    /**
     * prints all of the Events in this Queue on individual lines
     */
    public void printAll() {
        Node temp = head;
        while(temp != tail) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(tail.data);
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




