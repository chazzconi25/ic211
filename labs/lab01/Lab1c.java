/*
 * Charlie Francesconi 251806
 * IC211 Knoll
 * 
 * Lab1c is a guessing game run through the main method where
 * the user guesses a random int between 0 and 10 until they are
 * correct.
 */

//import for Scanner and Random object
import java.util.*;

public class Lab1c {
    /*
     * Generates a random number betwen 0 and 10 and prompts the user 
     * for a guess. If the user is wrong they are reprompted until
     * the get the random number right. Prints the number of guesses
     * used.
     */
    public static void main(String [] args) {
        // Scanner to take in user input from console
        Scanner in = new Scanner(System.in);

        // seed a new Random object and generate an int between 0 and 10
        Random rand = new Random(System.currentTimeMillis());
        int answer = rand.nextInt(11);

        // prompt the user for an inital guess and establish a couter for
        // number of guesses
        System.out.print("Guess a number between 0 and 10: ");
        int x = in.nextInt();
        int count = 1;

        // while the users guess is incorrect keep them guessing
        while (x != answer) {
            System.out.print("<Insert Snarky Message> Guess again: ");
            x = in.nextInt();
            
            // increment counter for each guess
            count++;
        }

        // print users number of guesses when user gets number correct
        System.out.println("Right after " + count + " guesses!");
    }
}