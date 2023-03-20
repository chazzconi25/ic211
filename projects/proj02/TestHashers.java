import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws Throwable {
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
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed: " + ciphertext);
  }
}