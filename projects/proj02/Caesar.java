public class Caesar implements Encryptor {
  private char sc;
  public String getAlgName() {
    return "caesar";
  }
  public void init(char[] key) throws InvalidCharException {
    int shift = 0;
    for(int i = 0; i < key.length; i++) {
      if(key[i] < 42 || key[i] > 122) {
        throw new InvalidCharException("error " + key[i] + " not allowed in key",key[i]);
      }
      shift += key[i] - 42;
    }
    sc = (char)(42 +((18 + shift) % 81));
  }
  public String encrypt(String caesar) throws InvalidCharException {
    char[] encrypted = caesar.toCharArray();
    int k = sc - 42;
    for(int i = 0; i < encrypted.length; i++) {
      if(encrypted[i] < 42 || encrypted[i] > 122) {
        throw new InvalidCharException("error " + encrypted[i] + " not allowed in plaintext",encrypted[i]);
      }
      int p = encrypted[i] - 42;
      int c = (p + k) % 81;
      encrypted[i] = (char)(42 + c);
    }
    return new String(encrypted);
  }
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