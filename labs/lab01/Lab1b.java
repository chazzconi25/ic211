import java.util.*;
public class Lab1b {
  public static int factorial(int k) {
    if(k == 0) {
        return 1;
    }
    return k*factorial(k-1);
  }

  public static int numerator(int n, int k) {
      if(k == 1) {
          return n;
      }
      return (n-k+1) * numerator(n,k-1);
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = in.nextLine();
    System.out.print("Please input an integer ");
    int n = in.nextInt();
    System.out.print("Please input a second integer ");
    int k = in.nextInt();
    System.out.println("The two ints were " + n + " and " + k);
    int numerator = numerator(n,k);
    int denominator = factorial(k);
    System.out.println("numerator = " + numerator);
    System.out.println("denominator = " + denominator);
    System.out.println("odds = 1 in " + numerator/denominator + " = " + (double)1/(numerator/denominator));
    System.out.println("Goodbye " + name + ".");
  }
}