import java.io.*;
import java.util.*;

public class Vault {
    public static void access(ArrayList<User> U) {
        boolean access = false;
        System.out.print("username: ");
        String uName = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
        int i = -1;
        try {
            while(!U.get(++i).getUname().equals(uName));
            access = U.get(i).correctPass(password);
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
        Scanner sc = new Scanner(System.in);
        String cmd = "";
        while(!cmd.equals("quit")) {
            System.out.print("> ");
            cmd = sc.next();
        }
    }

    public static ArrayList<User> readUsers(Scanner sc, ArrayList<Hasher> H) {
        ArrayList<User> U = new ArrayList<User>();
        while(sc.hasNext()) {
            sc.next();
            String name = sc.next();
            String encalg = sc.next();
            Hasher hashType;
            int i = -1;
            try {
                while(!H.get(++i).getHashName().equals(encalg));
                hashType = H.get(i);
            } catch(Exception e){
                hashType = null;
            }
            String hash = sc.next();
            U.add(new User(name, encalg, hashType, hash));
        }
        return U;
    }

    public static void write(ArrayList<Hasher> H, ArrayList<User> U, String filename) {
        // Opens an existing file, and appends to the end of it.
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }
        System.out.print("username: ");
        String uName = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
        System.out.print("Hash algorithm: ");
        String encalg = System.console().readLine();
        int i = -1;
        String hash = "";
        try {
            while(!H.get(++i).getHashName().equals(encalg));
            H.get(i).init(password);
            hash = H.get(i).hash();
        } catch (InvalidCharException e) {
            System.out.println("Error! Invalid symbol \'" + e.getChar() + "\' in password.");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error! Hash algorithm \'" + encalg + "\' not supported.");
            return;
        }
        i = -1;
        boolean duplicates = true;
        try {
            while(!U.get(++i).getUname().equals(uName));
        } catch(Exception e){
            duplicates = false;
        }
        if(duplicates) {
            System.out.println("Error! Username \'"+ uName +"\' already in use.");
            return;
        }
        pw.println("user " + uName + " " + encalg + " " + hash);
        if (pw != null) pw.close();
    }

    public static void main(String [] args) {
        ArrayList<User> U;
        ArrayList<Hasher> H = new ArrayList<Hasher>();
        H.add(new ClearHash());
        H.add(new ShiftCaesar());
        H.add(new ShiftVigenere());
        if(args.length == 0) {
            System.out.println("usage: java Vault [-au] <filename>");
            return;
        } else {
            // accessfile and return users
            String filename = args[args.length-1];
            try {
                Scanner sc = null;
                try {
                    sc = new Scanner(new File(filename));
                } catch (Exception e) {
                    System.out.println("Error! File \'" + filename + "\' could not be opened.");
                    return;
                }
                U = readUsers(sc, H);
            } catch (Exception e) {
                System.out.println("Error! File \'" + filename + "\' improperly formatted.");
                return;
            }
        }
        if(args.length == 1) {
            access(U);
        } else {
            write(H, U, args[args.length-1]);
        }
    }
}
