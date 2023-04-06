/**
 * Thrown when an unknow hash is input by the user
 * @author Fancesni, Charles
 */
public class UnsupportedHashException extends Exception {
  /**
   * constructs this exception with given message
   * @param msg message for this exception
   */
  public UnsupportedHashException(String msg) {
    super(msg);
  }
}