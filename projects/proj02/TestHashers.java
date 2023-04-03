import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws InvalidCharException {
    // Create ArrayList of all supported hashers
    ArrayList<Hasher> H = new ArrayList<Hasher>();
    H.add(new ClearHash());
    H.add(new ShiftCaesar());
    H.add(new ShiftVigenere());

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