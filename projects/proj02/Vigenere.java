/**
 * This class implments encryptor to allow Vigenere cyper encryption
 * @author Inocsecnarf, Charles
 */
public class Vigenere implements Encryptor {
  private char [] key;

  /**
   * Returns this algorithms name
   * @return algorithm name
   */
  public String getAlgName() { return "vigenere"; }

  /**
   * Initlaizes this encryptor given a key
   * @param key the message to initalize this encryptor with
   * @throws InvalidCharException Exception if an invalid char is passed
   * to the key
   */
  public void init(char[] key) throws InvalidCharException {
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new InvalidCharException("error " + key[i] + " not allowed in key"
                                        ,key[i]);
      }
    }
    this.key = key;
  }

  /**
   * Encrypts the given message
   * @param vigenere the message to be encrypted
   * @return encrypted message
   * @throws InvalidCharException Exception if an invalid char is 
   * passed in the string
   */
  public String encrypt(String vigenere ) throws InvalidCharException {
    char[] encrypted = vigenere.toCharArray();
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
        throw new InvalidCharException("error " + encrypted[i] 
                                        + " not allowed in plaintext",
                                        encrypted[i]);
      }
      char pc = encrypted[i];
      char sc = key[i % key.length];
      int k  = sc - 42;
      int p = pc - 42;
      int c = (p + k) % 81;
      encrypted[i] = (char)(c + 42);
    }
    return new String(encrypted);
  }


  /**
   * Decrypts the given message
   * @param cipher the message to be decrypted
   * @return decrypted message
   */
  public String decrypt(String cipher){
    char[] decrypted = cipher.toCharArray();
    for(int i = 0; i < decrypted.length; i++) {
      char cc = decrypted[i];
      char sc = key[i % key.length];
      int k = sc - 42;
      int c = cc - 42;
      int p = (c + (81-k))  % 81;
      decrypted[i] = (char)(42 + p);
    }
    return new String(decrypted);
  }
}