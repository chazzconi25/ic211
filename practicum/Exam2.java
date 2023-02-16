import java.io.*;
import java.util.*;
public class Exam2 {
    public static void main(String [] args) throws FileNotFoundException {
        File input = new File(args[0]);
        Scanner in = new Scanner(input);
        Queue mids = new Queue();
        while(in.hasNext()) {
            mids.enqueue(Midshipman.read(in));
        }
        mids.printAll();
        System.out.println("Now the matchups!!!");
        Midshipman winner;
        while(!mids.empty()) {
            Midshipman x = mids.dequeue(); 
            Midshipman y = mids.dequeue();
            if(y != null) {
                System.out.println(x + " VS " + y);
                if(x.willBeat(y, r)) {
                    System.out.println("Winner: " + x);
                } else  {
                    System.out.println("Winner: " + y);
                }
            } else {
                winner = x;
            }
        }
        System.out.print("The Brigade champion is: " + winner);

    }
}
