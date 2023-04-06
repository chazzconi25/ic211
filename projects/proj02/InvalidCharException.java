/**
 * Exception for if a string contains a value outside given ASCII bounds
 * @author Fancesconi, Charles
 */
public class InvalidCharException extends Exception {
    private char invalid;
    /**
     * Constructor for this exception
     * @param msg message when char is out of range
     * @param invalid invalid char found
     */
    public InvalidCharException(String msg, char invalid) {
        super(msg);
        this.invalid = invalid;
    }

    /**
     * Returns the invalid char found
     * @return The invalid char found
     */
    public char getChar(){
        return invalid;
    }
}