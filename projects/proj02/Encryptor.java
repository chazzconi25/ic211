public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key) throws InvalidCharException;
  public String encrypt(String plain) throws InvalidCharException;
  public String decrypt(String cipher);
}