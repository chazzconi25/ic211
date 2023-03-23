import java.io.*;
import java.util.*;

public class Lab08 {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    String fname = "";
    boolean verbose = false;
    boolean usingStdin = true;
    if(args.length != 0){
      verbose = args[0].equals("-v");
      if(verbose) {
        usingStdin = args.length - 1 == 0;
      } else {
        usingStdin = args.length == 0;
      }
      if(args.length > 1) {
        fname = args[1];
      } else {
        fname = args[0];
      }
      try {
        if(!usingStdin) {
          sc = new Scanner(new FileReader(fname));
        }
      } catch(IOException e) {
        System.out.println("File \'" + fname + "\' could not be opened; switching input to standard in.");
        usingStdin = true;
      }
    }
    
    ModQueue Q  = new ModQueue();

    do {
      if(usingStdin) {
        System.out.print("> ");
      }
      String cmd = "";
      String next = "";
      try {
        cmd = sc.next();
      } catch (NoSuchElementException e) {
        break;
      }
      if(cmd.equals("quit") ) {
        break;
      } else if(cmd.equals("clearto") ) {
        try {
          next = sc.next();
          Q.dequeue(next);
        } catch (NoSuchElementException e) {
          System.out.println("Unexpected end of input.");
        } catch (QueueException e) {
          if(verbose) {
            System.out.println("String \'" + next + "\' not found!");
          }
        }
      } else if( cmd.equals("add") )   {
        try {
          Q.enqueue(sc.next());
        } catch (Exception e) {
          System.out.println("Unexpected end of input.");
        }
      } else if(cmd.equals("dump") )   {
        try {
          System.out.println(Q.dump());
        } catch (Exception e) {}
      } else {
        if(verbose) {
          System.out.println("Unknown command \'" + cmd + "\'.");
        }
      }
    } while( true );
  }
}
