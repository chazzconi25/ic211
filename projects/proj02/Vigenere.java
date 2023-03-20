public class Vigenere implements Encryptor {
  private char [] key;
  public String getAlgName() { return "vigenere"; }

  public void init(char[] key) throws Throwable {
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new Throwable("error " + key[i] + " not allowed in key");
      }
    }
    this.key = key;
  }

  public String encrypt(String vigenere ) throws Throwable {
    char[] encrypted = vigenere.toCharArray();
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
        throw new Throwable("error " + key[i] + " not allowed in plaintext");
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