import java.util.Scanner;
import java.io.*;

public class HW11 {

  /**
   * Open a file and read its vehicles. Assume 10 in the file.
   */
  public static Vehicle[] readFile(String path) {
    Scanner sc = null;
    try {
      sc = new Scanner(new BufferedReader(new FileReader(path)));
    }
    catch(FileNotFoundException fe) {
      System.out.println("File " + path + " not found!");
      return null;
    }

    Vehicle[] vehicles = new Vehicle[10];
    int i = 0;
    String type;
    while( sc.hasNext() ){
      type = sc.next();
      if(type.equals("plane")) {
        vehicles[i++] = new Plane(type, sc.next(), sc.nextInt());
      } else if(type.equals("motorcycle")) {
        vehicles[i++] = new Motorcycle(type, sc.next(), sc.nextInt());
      } else if(type.equals("truck")) {
        vehicles[i++] = new Truck(type, sc.next(), sc.nextInt());
      } else if(type.equals("car")) {
        vehicles[i++] = new Car(type, sc.next(), sc.nextInt());
      } else {
        vehicles[i++] = new Vehicle(type, sc.next(), sc.nextInt());
      }
    }
    return vehicles;
  }

  /**
   * Main method, requires one arg (file path)
   */
  public static void main(String[] args) {
    if( args.length != 1 ) {
      System.out.println("HW11 <file>");
      System.exit(1);
    }

    Vehicle[] vs = readFile(args[0]);
    for( int i = 0; i < vs.length; i++ )
      System.out.println(vs[i]);
    }
}