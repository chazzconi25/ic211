import java.util.*;

/**
 * Runs a game where three different peices of different types
 * are shaken and then their current colors are printed for 10
 * rounds
 * @author Francesconi, Charles
 */
public class Game {
  public static void main(String[] args) {
    // Set seed to 0 by default or user given number in args
    int seed = 0;
    if( args.length == 1 )
      seed = Integer.parseInt(args[0]);

    // Create a Random object for game with given seed
    Random r = new Random(seed);

    // Create an ArrayList with one of each peice to this game
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Ball(r));
    pieces.add(new Chip(r));
    pieces.add(new Die(r, 4, 2));

    // For 10 rounds shake each peice and print its current color
    for( int j = 0; j < 10; j++ ) {
      for (Piece piece : pieces) {
        piece.shake();
        System.out.print(piece);
      }
      System.out.println();
    }
  }
}
