/**
 * interface Hasher to base other hash+ encryption algorthms on
 * @author Frcesconi, Charles
 */
public interface Hasher {

    /**
     * Returns the name of this hash
     * @return the name of this hash
     */
    public String getHashName();

    /**
     * Initializes the hash function and Encryptor
     * @param key Used to initalize the encryptor E attached to this Hasher
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public void   init(char[] key) throws InvalidCharException;

    /**
     * Produces a hash based on the Encryptor initalized with a key
     * @return hashed value for Encryptor base on key
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public String hash() throws InvalidCharException;
}
