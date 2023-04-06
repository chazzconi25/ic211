/*
 * Class for if a user inputs a hash that doesn't exist
 * @author Frananconi, Charles
 */
public class UnknownHash implements Hasher {
    private String name;

    /**
     * Constructs this hash with its unknown name
     * @param name given name for this hash
     */    
    public UnknownHash(String name) {
        this.name = name;
    }
    
    /**
     * Returns the name of this hash
     * @return the name of this hash
     */    
    public String getHashName() { return name;}


    /**
     * Initializes the hash function and Encryptor
     * @param key Used to initalize the encryptor E attached to this Hasher
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public void init(char[] key) throws InvalidCharException {return;}
    
    /**
     * Produces a hash based on the Encryptor initalized with a key
     * @return unused
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public String hash() throws InvalidCharException {return "";}
    
}
