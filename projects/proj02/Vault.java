import java.io.*;
import java.util.*;

/**
 * Vault program for allowing users to access hashed data using a password.
 * New users can be added and data is checked for vaildidty when it is dehashed.
 * @author Franesoni, Charles
 */
public class Vault {
    /**
     * Runs the body of the vault program. The user can add flags to add users
     * to a vault file or simply run the program with a vault file to input
     * a user and password to access data.
     * @param args filname of vault and flags for editing
     */
    public static void main(String [] args) {
        // List to store Vault file as Objects
        VaultArrayList I;
        
        // List for supported hashers
        ArrayList<Hasher> H = new ArrayList<Hasher>();
        H.add(new ClearHash());
        H.add(new Shift(new Caesar()));
        H.add(new Shift(new Vigenere()));

        // List for supported encryptors
        ArrayList<Encryptor> E = new ArrayList<Encryptor>();
        E.add(new Clear());
        E.add(new Caesar());
        E.add(new Vigenere());

        // Check to ensure user is running program correctly / IO isses
        if(args.length == 0) {
            System.out.println("usage: java Vault [-au] <filename>");
            return;
        } else {
            // Accessfile and return users
            String filename = args[args.length-1];
            try {
                Scanner sc = null;
                try {
                    sc = new Scanner(new File(filename));
                } catch (Exception e) {
                    System.out.println("Error! File \'" + filename
                                        + "\' could not be opened.");
                    return;
                }
                // Convert exsisting file to objects in a VaultArrayList
                I = readVault(sc, H, E);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error! File \'" + filename
                                    + "\' improperly formatted.");
                return;
            }
        }

        // Check if the user is adding new users to the vault or accessing data
        // only
        if(args.length == 1) {
            access(I);
        } else {
            write(H, I, args[args.length-1]);
        }
    }

    /**
     * Reads in an entire vault file and returns all of the data in Objects
     * within an ArrayList for easy access.
     * @param sc scanner to vault
     * @param H supported hashers
     * @param E supported encryptors
     * @return vaultitems in an arraylist
     */
    public static VaultArrayList readVault(Scanner sc, ArrayList<Hasher> H,
                                            ArrayList<Encryptor> E) {
        // VaultArrayList to store all of the Data and Users in this file
        VaultArrayList I = new VaultArrayList();

        // Loop through all entries and create Users or Data to add to ArrayList
        while(sc.hasNext()) {
            boolean user = sc.next().equals("user");
            String name = sc.next();
            String encalg = sc.next();
            String hash = sc.next();
            Hasher hashType;
            Encryptor encryptType;
            int i = -1;
            
            // Check if the current line is data or user and generate according
            // if the hashType is unsuppoted for user file set it to UnknownHash 
            if(user) {
                try {
                    while(!H.get(++i).getHashName().equals(encalg));
                    hashType = H.get(i);
                } catch(Exception e){
                    hashType = new UnknownHash(encalg);
                }
                I.add(new User(name, hash, hashType));
            } else {
                try {
                    while(!E.get(++i).getAlgName().equals(encalg));
                    encryptType = E.get(i);
                } catch(Exception e){
                    encryptType = null;
                }
                I.add(new Data(name, hash, encryptType));
            }
        }
        return I;
    }

    /**
     * Allows the user to write new users to a given vault file 
     * @param H list of supported hasers
     * @param I current vault items in file
     * @param filename name of vault file
     */
    public static void write(ArrayList<Hasher> H, VaultArrayList I,
                            String filename) {
        // Opens an existing file, and appends to the end of it.
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(filename
                                                    , true)));
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }

        // Propt the user for a name and pass
        System.out.print("username: ");
        String uName = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
        System.out.print("Hash algorithm: ");
        String encalg = System.console().readLine();
        int i = -1;
        String hash = "";

        // Check to ensure that user formatted data that is valid
        try {
            while(!H.get(++i).getHashName().equals(encalg));
            H.get(i).init(password);
            hash = H.get(i).hash();
        } catch (InvalidCharException e) {
            System.out.println("Error! Invalid symbol \'" + e.getChar()
                                + "\' in password.");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error! Hash algorithm \'" + encalg
                                + "\' not supported.");
            return;
        }
        i = -1;
        if(I.getUser(uName) != null) {
            System.out.println("Error! Username \'"+ uName
                                +"\' already in use.");
            return;
        }
        // Add user if all hash is valid and user does not already exsist
        pw.println("user " + uName + " " + encalg + " " + hash);
        if (pw != null) pw.close();
    }

    /**
     * Allows the user to acccess and interact with data after logging in.
     * Takes a VaultItems list that represents an entire vault file that
     * has been reformatted as easy to use objects.
     * @param I VaultItems in a list
     */
    public static void access(VaultArrayList I) {
        // prompt for a username and pass
        boolean access = false;
        System.out.print("username: ");
        String uName = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
        
        // Check to see if this is a correct user password combination
        // if the Users hash is unsupported notify and exit otherwise 
        // deny acces if incorrect user pass combination
        try {
            User currUser = I.getUser(uName);
            access = currUser.correctPass(password);
        } catch (UnsupportedHashException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Access denied!");
            return;
        }
        if(!access) {
            System.out.println("Access denied!");
            return;
        } else {
            System.out.println("Access granted!");
        }

        // When access is granted prompt for commands
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String cmd = sc.next();
        
        // Make an array of all the users data from the exisiting List of 
        // VaultItems
        ArrayList<Data> Data = I.userData(uName);

        // Process commands until command quit is given
        while(!cmd.equals("quit")) {
            if(cmd.equals("labels")) {
                for (Data data : Data) {
                    try {
                        System.out.println(data.lable(password));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }  else if(cmd.equals("get"))   {
                cmd = sc.next();
                for (Data data : Data) {
                    try {
                        if(data.lable(password).equals(cmd)) {
                            System.out.println(data.data(password));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("Unknown command \'" + cmd + "\'.");
            }
            System.out.print("> ");
            cmd = sc.next();
        }
    }
}
