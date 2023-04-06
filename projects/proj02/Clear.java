/**
 * This class implments encryptor to allow clear encryption
 * @author Fraesconi, Charles
 */
public class Clear implements Encryptor {
  
  /**
   * Returns this algorithm name
   * @return algorithm name
   */
  public String getAlgName() { return "clear"; }

  /**
   * Initlaizes this encryptor given a key
   * @param key the message to initalize this encryptor with
   * @throws InvalidCharException Exception if an invalid char is passed
   * to the key
   */
  public void   init(char[] key) throws InvalidCharException {
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new InvalidCharException("error " + key[i]
                                        + " not allowed in key",key[i]);
      }
    }
  }

  /**
   * Encrypts the given message
   * @param plain the message to be encrypted
   * @return encrypted message
   * @throws InvalidCharException Exception if an invalid char is 
   * passed in the string
   */
  public String encrypt(String plain) throws InvalidCharException {
    char[] encrypted = plain.toCharArray();
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
          throw new InvalidCharException("error " + encrypted[i]
                                          + " not allowed in plaintext"
                                          , encrypted[i]);
      }
    }
    return plain;
  }
  
  /**
   * Decrypts the given message
   * @param cipher the message to be decrypted
   * @return decrypted message
   */
  public String decrypt(String cipher){ return cipher; }
}