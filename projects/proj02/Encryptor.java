/**
 * Encrptor interface to base all encryptors on
 * @author Frannceni, Charles
 */
public interface Encryptor {
  /**
   * Returns this algorithm name
   * @return algorithm name
   */
  public String getAlgName();

  /**
   * Initlaizes this encryptor given a key
   * @param key the message to initalize this encryptor with
   * @throws InvalidCharException Exception if an invalid char is passed
   * to the key
   */
  public void  init(char[] key) throws InvalidCharException;

  /**
   * Encrypts the given message
   * @param plain the message to be encrypted
   * @return encrypted message
   * @throws InvalidCharException Exception if an invalid char is 
   * passed in the string
   */
  public String encrypt(String plain) throws InvalidCharException;

  /**
   * Decrypts the given message
   * @param cipher the message to be decrypted
   * @return decrypted message
   */
  public String decrypt(String cipher);
}