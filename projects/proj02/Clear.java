public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  public void   init(char[] key) throws Throwable {
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new Throwable("error " + key[i] + " not allowed in key");
      }
    }
  }
  public String encrypt(String plain) throws Throwable{
    char[] encrypted = plain.toCharArray();
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
        throw new Throwable("error " + encrypted[i] + " not allowed in plaintext");
      }
    }
    return plain;
  }
  public String decrypt(String cipher){ return cipher; }
}