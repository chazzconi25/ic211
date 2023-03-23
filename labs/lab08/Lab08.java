import java.io.*;
import java.util.*;
/**
 * This program allows the user to add strings to a queue and display them.
 * The queue can be cleared up to a certain word in the queue. Quit the program
 * with the command 'quit'.
 * @author Francsoni
 */
public class Lab08 {

  /**
   * Allows the user to use queue functionality, adding strings, displaying
   * strings, and clearing to a string. Can submit a list of strings and
   * commands from a file or stdin. All errors are handeld and viewable
   * with tag -v for verbose mode.
   * @param args -v for verbose mode and a file name if not using stdin
   * @throws Throwable throws errors if commands are processed improperly
   */
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
        System.out.println("File \'" + fname +
                    "\' could not be opened; switching input to standard in.");
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
