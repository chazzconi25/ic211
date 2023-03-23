import java.util.Iterator;
import java.util.Scanner;

import org.w3c.dom.ElementTraversal;

public class ArrList<T> implements Iterable<T> {
    
    private  Object[] elements;
    private int size = 0;

    public ArrList() {
        elements = (T[])new Object[10];
    }

    public void add(T d) {
        if(size > elements.length-1) {
            Object[] newElements = (T[])new Object[elements.length*2];
            for(int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = d;
        System.out.println(elements[size]);
        System.out.println(size);
        size++;
        System.out.println(size);
    }

    //TODO
    //public T get(int index) {

    //}

    //TODO
    //public Iterator<T> iterator() {

    //}

    public T remove(int index) throws Throwable {
        if(index < 0 || index > size-1) {
            throw new Throwable("IndexOutOfBoundsException");
        }
        for(int i = 0; i < elements.length-1; i++) {
            
        }
        return (T)elements[index];
    }

    public Iterator<T> iterator() {
        return new ArrListIter();
    }

    private class ArrListIter<T> implements Iterator<T>{
        private int curr = 0;
        @Override
        public boolean hasNext() {
            return curr < size;
        }
        
        @Override
        public T next() {
            curr++;
            System.out.println(curr);
            return (T)elements[curr--];
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrList<String> myList = new ArrList<String>();
        String next = sc.next();
        while(!next.equals("quit")) {
            myList.add(next);
            next = sc.next();
        }
        Iterator<String> itr = myList.iterator();
        System.out.println(itr.next());
        //while(itr.hasNext()) {
            
        //}
    }

}