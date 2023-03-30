import java.util.*;
import java.io.*;
/**
 * This program implements a generic ArrayList with an array
 * @author Charlie Francesconi
 */
public class ArrList<T> implements Iterable<T> {
    //fields
    private Object[] elements = new Object[10];
    private int size = 0;

    /**
     * Appends the specified element to the end of the list.
     * @param d element to be appended to the list
     */
    public void add(T d) {
        if(size > elements.length-1) {
            Object[] newElements = new Object[elements.length*2];
            for(int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = d;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index the index of the element to return.
     * @return the element at the specified position in this list.
     */
    public T get(int index) {
        return (T)elements[index];
    }

    /**
     * Returns an iterator over the elements in this list in proper
     * sequence.
     * @return an iterator over the elements in this list in proper sequence.
     */
    public Iterator<T> iterator() {
        return new ArrListIter();
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to be removed.
     * @return the element that was removed from the list.
     * @throws IndexOutOfBoundsException when the index given is 
     * greater than the size or less than 0
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        T ret = (T)elements[index];
        size--;
        for(int i = index; i < size; i++) {
            elements[i] = elements[i+1];
        }
        return ret;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     * @param d element to be removed, if present
     * @return true if the list contained the specified element.
     */
    boolean remove(T d) {
        for(int i = 0; i < size-1; i++) {
            if(elements[i].equals(d)) {
                size--;
                for(int j = i; j < size; j++) {
                    elements[j] = elements[j+1];
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }

    protected class ArrListIter implements Iterator<T>{
        private int curr = 0;
        @Override
        public boolean hasNext() {
            return curr < size;
        }
        
        @Override
        public T next() {
            curr++;
            return (T)elements[curr-1];
        }
    }

    public static void main(String[] args){
        ArrList<String> al = new ArrList<String>();
    
        Scanner sc = new Scanner(System.in);
        if(args.length > 0){
          try{
            sc = new Scanner(new File(args[0]));
          }catch(Exception e){}
        }
    
        while(sc.hasNext())
          al.add(sc.next());
    
        System.out.println("Size: " + al.size());
        
        System.out.println("Last: " + al.get(al.size() - 1));
        System.out.println("First: " + al.get(0));
        System.out.println("Remove a bit: " + al.remove(al.size()-9));
        System.out.println("Last: " + al.get(al.size() - 1));
    
        int count = 0;
        for(String s: al)
          count++;
      
        System.out.println("Size check : " + ((count == al.size()) ? "Pass" : "Fail"));
    
      }

}