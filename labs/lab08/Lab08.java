import java.io.*;
import java.util.*;

public class Lab08 {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    String fname = "";
    boolean verbose = false;
    if(args.length >= 1){
      verbose = args[0].equals("-v");
      if(verbose && args.length > 1) {
        fname = args[1];
      } else {
        fname = args[0];
      }
      try {
        sc = new Scanner(new FileReader(fname));
      } catch(IOException e) {
        System.out.println("File \'" + fname + "\' could not be opened; switching input to standard in.");
      }
    }
    
    ModQueue Q  = new ModQueue();

    do {
      if(verbose && args.length == 1 || args.length == 0) {
        System.out.print("> ");
      }
      String cmd = sc.next();

      if( cmd.equals("quit") ) {
        break;
      } else if( cmd.equals("clearto") ) {
        String next = sc.next();
        try {
          Q.dequeue(next);
        } catch (Exception e) {
          if(verbose) {
            System.out.println("String " + next + " not found!");
          }
        }
        
      } else if( cmd.equals("add") )   {
        Q.enqueue(sc.next());
      } else if( cmd.equals("dump") )   {
        System.out.println(Q.dump());
      }
    } while( true );
  }
}
