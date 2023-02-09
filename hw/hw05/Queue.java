/**
 * Queue interface for Node objects. Allows the user to add Strings
 * to Queue and remove in the order they were added or check if the
 * Queue is empty.
 */
public class Queue {
    private class Node {
        public String data;
        public Node next;
        public Node(String d, Node n) {
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
    public void enqueue(String s) {
        Node temp = new Node(s, null);
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
    public String dequeue() {
        if(head == null) {
            return null;
        }
        String ret = head.data;
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
}




