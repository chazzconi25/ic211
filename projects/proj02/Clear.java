public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  public void   init(char[] key) throws InvalidCharException {
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new InvalidCharException("error " + key[i] + " not allowed in key",key[i]);
      }
    }
  }
  public String encrypt(String plain) throws InvalidCharException {
    char[] encrypted = plain.toCharArray();
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
          throw new InvalidCharException("error " + encrypted[i] + " not allowed in plaintext",encrypted[i]);
      }
    }
    return plain;
  }
  public String decrypt(String cipher){ return cipher; }
}