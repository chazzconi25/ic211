import java.util.*;
/**
 * Each Piece in the game is represented by an an object defined from
 * an extension of this class. Shaking a peice will modify its color
 * according to the specifications of the specific piece. ALL PIECES
 * ARE BLACK BY DEFAULT UNLESS OTHERWISE NOTED IN A SPECIFIC PEICES
 * CONSTRUCTOR!
 * @author Francesconi, Charles
 */
public abstract class Piece {

  // Fields
  // Random object for random color switches
  protected Random r;
  // Color of this Piece true means Piece is black
  protected boolean black = false;

  /**
   * Constructor for a game Piece
   * @param r random object used in game
   */
  public Piece(Random r) {
    this.r = r;
  }

  /**
   * Returns the current color of this piece in string form
   * @return Single character string if peice is black or white
   */
  public String toString() {
    if(black) {
      return "B";
    } else {
      return "W";
    }
  }

  /**
   * Modifies this peice's color according to its specific rules
   */
  public abstract void shake();
}
