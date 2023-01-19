/*
 * Charlie Francesconi 251806
 * IC211 Knoll
 * 
 * Lab1a prints numbers 0 through 10 and their squares on 11 seperate lines.
 */

public class Lab1a {
  /*
   * main Prints integers 0 through 9 and their squared values on seprate lines
   */
  public static void main(String[] args) {
    // initalize empty array and k iterator value
    int[] x = new int[10];
    int k = 0;

    // loop from k to 10 and add k*k to each k index of the array
    while( k < 10 ) {
      x[k] = k*k;
      k++;
    }
    
    // print values 0 through 10 and the squared values stored in x
    for( int j = 0; j < 10; j++ ) {
      System.out.println(j + " squared is " + x[j]);
    }
  }
}