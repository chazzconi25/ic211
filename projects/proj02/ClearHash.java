/**
 * This class implments hasher to allow clear hashing
 * @author Fncsoiances, Charles
 */
public class ClearHash implements Hasher {
    private Encryptor E = new Clear();
    private String key;

    /**
     * Returns the name of this hash
     * @return the name of this hash
     */
    public String getHashName() {return "clear";}

    /**
     * Initializes the hash function and Encryptor
     * @param key Used to initalize the encryptor E attached to this Hasher
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public void init(char[] key) throws InvalidCharException {
        this.key = new String(key);
        E.init(key);
    }

    /**
     * Produces a hash based on the Encryptor initalized with a key
     * @return hashed value for Encryptor base on key
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public String hash() throws InvalidCharException {
        String encrypted =  E.encrypt(key);
        char[] hash = new char[16];
        for(int i = 0; i < 16; i++) {
            if(i < encrypted.length()) {
                hash[i] = encrypted.charAt(i);
            } else {
                hash[i] = 'x';
            }
        }
        return new String(hash);
    }
}
