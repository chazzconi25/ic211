/**
 * Represents a user and their hashed password stored in a vault file
 * @author Frcesconi, Charles
 */
public class User extends VaultItem {
    private Hasher H;
    /**
     * Construct a user
     * @param name users name
     * @param hash users hashed password
     * @param H hasher user uses
     */
    public User(String name, String hash, Hasher H) {
        super(name, hash);
        this.H = H;
    }

    /**
     * Checks if a given password is right for this users
     * @param password password to check
     * @return true if password mataches
     * @throws Exception unsupported hash if user has a fake hash
     * or passowrd has invalid chars
     */
    public boolean correctPass(char [] password) throws Exception {
        if(H instanceof UnknownHash) {
            throw new UnsupportedHashException("Error! Hash algorithm \'"
                                                + H.getHashName() 
                                                + "\' not supported.");
        }
        H.init(password);
        String test = H.hash();
        return test.equals(hash);
    }

}

