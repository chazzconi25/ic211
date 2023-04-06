import java.util.*;
/**
 * Class for testing all of the implmented encryptors with user input
 * @author Franconiconi, Charles
 */
public class TestEncryptors {
  /**
    * Tests all implemented encryptors in a defined ArrayList. User can fill
    * field entries to adjust tests
    * @param args unused
    * @throws InvalidCharException If passwords outside ASCII bounds are given
    */
  public static void main(String[] args) throws InvalidCharException {
    // Create ArrayList of all supported encryptors
    ArrayList<Encryptor> E = new ArrayList<Encryptor>();
    E.add(new Clear());
    E.add(new Caesar());
    E.add(new Vigenere());

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String encalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    System.out.print("message  : ");
    String plaintext = System.console().readLine();

    // Find index of encryptor (throw exception if not found)
    int i = -1;
    try {
      while( !E.get(++i).getAlgName().equals(encalg) ) ;
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Unknown algorithm '" + encalg +"'.");
    }

    // Encrypt, decrypt print sumamry of results
    E.get(i).init(password);
    String ciphertext = E.get(i).encrypt(plaintext);
    String hopefully = E.get(i).decrypt(ciphertext);
    System.out.println("plain : " + plaintext);
    System.out.println("cipher: " + ciphertext);
    System.out.println("decryp: " + hopefully);
  }
}