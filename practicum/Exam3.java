import java.io.*;
import java.util.*;
public class Exam3 {
    public static void main(String [] args) throws FileNotFoundException {
        File input = new File(args[0]);
        int seed = Integer.parseInt(args[1]);
        Random r = new Random(seed);
        Scanner in = new Scanner(input);
        Queue mids = new Queue();
        while(in.hasNext()) {
            mids.enqueue(Midshipman.read(in));
        }
        mids.printAll();
        System.out.println("Now the matchups!!!");
        Midshipman winner = null;

        while(!mids.empty()) {
            Midshipman x = mids.dequeue(); 
            Midshipman y = mids.dequeue();
            if(y != null) {
                System.out.println(x + " VS " + y);
                if(x.willBeat(y, r)) {
                    System.out.println("Winner: " + x);
                    mids.enqueue(x);
                } else  {
                    System.out.println("Winner: " + y);
                    mids.enqueue(y);
                }
            } else {
                winner = x;                
            }
        }
        System.out.println("The Brigade champion is: " + winner);

    }
}
