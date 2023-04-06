/**
 * Represents a basic vault item, can be a user or data, holds the name and hash
 * that pertain to the specific user or data regardless of type.
 * @author Frncscni, Charles
 */
public class VaultItem {
    private String name;
    protected String hash;

    /**
     * constructs a vautitem
     * @param name name of user connectd to this item
     * @param hash hash of data or pawssowrd in this item
     */
    public VaultItem(String name, String hash) {
        this.name = name;
        this.hash = hash;
    }

    /**
     * Checks if this item has a given username
     * @param testName username to check
     * @return true if the username checked matches
     * the one on file for this item.
     */
    public Boolean getUname(String testName) {
        return testName.equals(name);
    }
}
