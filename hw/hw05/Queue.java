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
    */
    public void enqueue(String s) {
        Node temp = new Node(s, head);
        head = temp;
        if(tail == null) {
            tail = head;
        }
    }

    /**
     * removes and returns string from the front of the queue
     */
    public String dequeue() {
        Node temp = head;
        String last = "";
        if(temp == null) {
            return last;
        } else if (temp == tail) {
            last = temp.data;
            head = null;
            tail = null;
            return last;
        }
        while(temp.next != tail) {
            temp = temp.next;
        }
        last = temp.next.data;
        tail = temp;
        temp.next = null;
        return last;
    }

    /**
     * returns true if the queue is empty
     */
    public boolean empty() {
        return head == null;
    }


}




