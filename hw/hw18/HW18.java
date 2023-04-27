
import java.util.*;
import java.io.*;

public class HW18 {
  public static void main(String[] args) {
    Reader r = new InputStreamReader(System.in);
    if(args.length > 0) {
        try {
            r = new InputStreamReader(new FileInputStream(args[0]));
        } catch (Exception e) {}
    }
    
    Mystery myster = new Mystery();
    LineNumberReader reader = new LineNumberReader(r);
    try {
        String line = reader.readLine();
        while(line != null) {
            Scanner sc = new Scanner(line);
            myster.compute(sc); // can be called multiple times to continue computation
            line = reader.readLine();
        }
        System.out.println(myster.result()); // only called once after all compute() calls are finished
    } catch (Exception e) {
        System.out.println("Error on line " + reader.getLineNumber() + ": " + e.getMessage());
    }
  }
}