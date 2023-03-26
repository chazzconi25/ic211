public class Queue {
    private int head = 0, tail = 0;
    private String [] queue = new String [1024];
    public void enqueue(String s) {
        queue[tail] = s;
        tail++;
    }
  
    public String dequeue() {
      String ret = queue[head];
      head++;
      return ret;
    }
  
    public boolean empty() {
      return head == tail;
    }
  
    public Iter iterator() {
      return new Iter(head);
    }
  
    protected class Iter {
      private int curr;
      public Iter(int start) {
        curr = start;
      }
  
      public boolean hasNext() {
        return curr != tail;
      }
  
      public String next() {
        String s = queue[curr];
        curr++;
        return s;
      }
    }    
}