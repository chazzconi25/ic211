import java.util.*;

public class HW09 {
  public static void main(String[] args) {
    boolean verbose = args.length > 0 && args[0].equals("-v");
    Scanner sc      = new Scanner(System.in);

    if (verbose) {
      System.out.print("Enter x, k, m: ");
    }
    try {
        int x = sc.nextInt();
        int k = sc.nextInt();
        if(k < 0) {
            throw new Exception();
        }
        int m = sc.nextInt();
        int r = MyMath.modexp(x, k, m);
        if (verbose) {
            System.out.print(x + "^" + k + " % " + m + " = ");
        }
    System.out.println(r);
    } catch(Exception e) {
        if (verbose) {
            System.out.println("Error in HW09! invalid input.");
        }
    }
  }
}