/**
 * Object that can be found in the vault used to store hashed  in a map format
 * that is owned by one user. Using a password the data can be read.
 * @author Frsoncini, Charles
 */
public class Data extends VaultItem {
    private Encryptor E;

    /**
     * Constructor for a Data object that holds a users hashed data
     * @param name user that owns this data
     * @param hash how data is hashed
     * @param E alg for decrypting data
     */
    public Data(String name, String hash, Encryptor E) {
        super(name, hash);
        this.E = E;
    }

    /**
     * Retrives a key for a users data given their password
     * @param password users password
     * @return key for a users data
     * @throws Exception throws CorruptDataException if input
     * has invalid characters or there is no underscore to define a
     * label in decrypted data.
     */
    public String lable(char [] password) throws Exception {
        E.init(password);
        if(E.decrypt(hash).indexOf("_") == -1) {
            throw new CorruptDataException("Error! Corrupted entry \'" + hash
                                            + "\' in vault file.");
        }
        try {
            E.encrypt(hash);
        } catch (Exception e) {
            throw new CorruptDataException("Error! Corrupted entry \'" + hash
                                            + "\' in vault file.");
        }
        return E.decrypt(hash).substring(0, E.decrypt(hash).indexOf("_"));
    }

    /**
     * Returns the data without a label given a password
     * @param password users passowrd
     * @return data without a label
     * @throws Exception InvalidCharacterException if init Encryptor fails
     */
    public String data(char [] password) throws Exception {
        E.init(password);
        return E.decrypt(hash).substring(E.decrypt(hash).indexOf("_")+1);
    }
}
