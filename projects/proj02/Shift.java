/**
 * This class implments Hasher to allow shift+ hashing
 * @author Fesconiani, Charles
 */
public class Shift implements Hasher {
    private Encryptor E;
    /**
     * Initializes shift with a given encryptor
     * @param E Encryptor for shft+ hashing
     */
    public Shift(Encryptor E) {
        this.E = E;
    }

    /**
     * Returns the name of this hash
     * @return the name of this hash
     */
    public String getHashName() {return "shift+" + E.getAlgName();}

    /**
     * Initializes the hash function and Encryptor
     * @param key Used to initalize the encryptor E attached to this Hasher
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public void init(char[] key) throws InvalidCharException {
        E.init(key);
    }

    /**
     * Produces a hash based on the Encryptor initalized with a key
     * @return hashed value for Encryptor base on key
     * @throws InvalidCharException Exception if an invalid char is passed
     * to the key
     */
    public String hash() throws InvalidCharException {
        String x = "GO_NAVY_2018^mid";
        for(int i = 0; i < 16; i++) {
            char c = x.charAt(i);
            int k = c % 16;
            x = shift(k, x);
            x = E.encrypt(x);
        }
        return x;
    }

    /**
     * Helper method for shifting strings left
     * @param turns number of characters to shift left
     * @param x string to be shifed
     * @return string x shifed turns times
     */
    private static String shift(int turns, String x) {
        int len = x.length();
        turns = turns%len;
        x = x.substring(turns) + x.substring(0, turns);
        return x;
    }
}
