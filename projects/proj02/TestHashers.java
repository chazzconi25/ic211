import java.util.*;
/**
 * Calss that tests all of the implemented hashers with user input
 * @author Frcesconi, Charles
 */
public class TestHashers {
  /**
    * Tests all implemented hashers in a defined ArrayList. User can fill
    * field entries to adjust tests in prompts
    * @param args unused
    * @throws InvalidCharException If passwords outside ASCII bounds are given
    */
  public static void main(String[] args) throws InvalidCharException {
    // Create ArrayList of all supported hashers
    ArrayList<Hasher> H = new ArrayList<Hasher>();
    H.add(new ClearHash());
    H.add(new Shift(new Caesar()));
    H.add(new Shift(new Vigenere()));

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String encalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();

    // Find index of hasher (throw exception if not found)
    int i = -1;
    try {
      while(!H.get(++i).getHashName().equals(encalg)) ;
    } catch(IndexOutOfBoundsException e) {
      throw new NoSuchElementException("Unknown hash '" + encalg +"'.");
    }

    // Encrypt, decrypt print sumamry of results
    H.get(i).init(password);
    String hash = H.get(i).hash();
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed : " + hash);
  }
}