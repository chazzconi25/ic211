/**
 * Exception for if there are corrupt data entries in Vault
 * @author Francei, Charles
 */
public class CorruptDataException extends Exception {
    /**
     * constructor for this exception
     * @param msg message when corrupt data is found
     */
    public CorruptDataException(String msg) {
        super(msg);
    }
}