/**
 * This class implments encryptor to allow caesar cyper encryption
 * @author Francsoi, Charles
 */
public class Caesar implements Encryptor {
  private char sc;

  /**
   * Returns this algorithm name
   * @return algorithm name
   */
  public String getAlgName() {
    return "caesar";
  }

  /**
   * Initlaizes this encryptor given a key
   * @param key the message to initalize this encryptor with
   * @throws InvalidCharException Exception if an invalid char is passed
   * to the key
   */
  public void init(char[] key) throws InvalidCharException {
    int shift = 0;
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new InvalidCharException("error " + key[i] 
                                        + " not allowed in key",key[i]);
      }
      shift += key[i] - 42;
    }
    sc = (char)(42 +((18 + shift) % 81));
  }

  /**
   * Encrypts the given message
   * @param caesar the message to be encrypted
   * @return encrypted message
   * @throws InvalidCharException Exception if an invalid char is 
   * passed in the string
   */
  public String encrypt(String caesar) throws InvalidCharException {
    char[] encrypted = caesar.toCharArray();
    int k = sc - 42;
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
        throw new InvalidCharException("error " + encrypted[i]
                                        + " not allowed in plaintext"
                                        , encrypted[i]);
      }
      int p = encrypted[i] - 42;
      int c = (p + k) % 81;
      encrypted[i] = (char)(42 + c);
    }
    return new String(encrypted);
  }

  /**
   * Decrypts the given message
   * @param cipher the message to be decrypted
   * @return decrypted message
   */
  public String decrypt(String cipher) {
    char[] decrypted = cipher.toCharArray();
    int k = sc - 42;
    for(int i = 0; i < decrypted.length; i++) {
      int c = decrypted[i] - 42;
      int p = (c + (81 - k)) % 81;
      decrypted[i] = (char)(42 + p);
    }
    return new String(decrypted);
  }
}