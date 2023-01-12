import java.util.*;
public class Lab1c {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());
        int answer = rand.nextInt(11);
        System.out.print("Guess a number between 0 and 10: ");
        int x = in.nextInt();
        int count = 1;
        while (x != answer) {
            System.out.print("<Insert Snarky Message> Guess again: ");
            x = in.nextInt();
            count++;
        }
        System.out.println("Right after " + count + " guesses!");
    }
}