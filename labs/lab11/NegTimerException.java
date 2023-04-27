/**
 * Exception for if a negative number is put into a timer
 * @author Charlie Francesconi
 */
public class NegTimerException extends Exception {
    /**
     * constructs a new exception of this type
     * @param msg message for this error
     */
    public NegTimerException(String msg) {
        super(msg);
    }
}
