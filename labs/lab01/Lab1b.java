/*
 * Charlie Francesconi 251806
 * IC211 Knoll
 * 
 * Lab1b takes two ints from the terminal and returns information on the
 * odds of a lottery if there were n numbers and k balls.
 */

//import for Scanner and Random object
import java.util.*;

public class Lab1b {
  /*
   * Returns the factorial of a given number
   * @param k the number of factorial needed
   * @return the number k!
   */
  public static int factorial(int k) {
    if(k == 0) {
      return 1;
    }
    return k*factorial(k-1);
  }

    /*
     * Returns a number that when divided by k! will produce the odds
     * of winning a lottery if there are n possible numbers and k picks
     * @param n possible numbers in a lottery
     * @param k 
     * @return number that can be divided by k! to get the odds of winning 
     *         a lottery with given params
     */
  public static int numerator(int n, int k) {
      if(k == 1) {
        return n;
      }
      return (n-(k-1)) * numerator(n,k-1);
  }


  /*
   * Prompts the user for their name and two integers. Prints the integers
   * to console and then prints the numerator and denominator of an equation
   * that can be used to calculate the odds of a lottery with n possible numbers
   * and k balls. Prints the odds as 1 in 'chances' and in decimal percentage form.
   */
  public static void main(String[] args) {
    // Scanner to take input from console
    Scanner in = new Scanner(System.in);

    // prompt user for name  and two integers
    System.out.print("Enter your name: ");
    String name = in.nextLine();
    System.out.print("Please input an integer ");
    int n = in.nextInt();
    System.out.print("Please input a second integer ");
    int k = in.nextInt();

    // print entered ints to console
    System.out.println("The two ints were " + n + " and " + k);

    // calculate numerator and denominator of odds equation
    int numerator = numerator(n,k);
    int denominator = factorial(k);

    // print all information on odds
    System.out.println("numerator = " + numerator);
    System.out.println("denominator = " + denominator);
    System.out.println("odds = 1 in " + numerator/denominator + " = " + (double)1/(numerator/denominator));
    System.out.println("Goodbye " + name + ".");
  }
}