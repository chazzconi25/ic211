import java.util.*;
/**
 * VaultArrayList is a data structure for storing and accesing multiple 
 * VaultArray objects. The primary benefits are the ability to querey users
 * quickly and get an ArrayList of all the Data entries for a single user.
 * Typically used to store all of the information (users and data) in one vault.
 * @author Francesconi, Charles 
 */
public class VaultArrayList {

    /**
     * Private Node class to store indvidual VaultItems
     */
    private class Node {
        private VaultItem data;
        private Node next;

        /**
         * Constructor for new Node
         * @param data VaultItem contained this Node
         * @param next Next node in the list of nodes
         */
        public Node(VaultItem data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;

    /**
     * Adds a given VaultItem to the ArrayList
     * @param newEntry new VaultItem to add to the list of things in the vault
     */
    public void add(VaultItem newEntry) {
        if(head == null) {
            head = new Node(newEntry, null);
            tail = head;
        }
        tail.next = new Node(newEntry, null);
        tail = tail.next;
    }

    /**
     * Given the name of a user return the User object associated
     * @param uname name of the user quered
     * @return User queried or null if the user is not in this VaultArrayList
     */
    public User getUser(String uname) {
        Node temp = head;
        while(temp != null) {
            if(temp.data instanceof User && temp.data.getUname(uname)) {
                return (User)temp.data;
            }
            temp = temp.next;
        }
        return null;
    }
    
    /**
     * Querey all of the Data objects by username
     * @param uname users name to query data for
     * @return ArrayList of Data objects connected to this user returns an empty
     * ArrayList if they have no data
     */
    public ArrayList<Data> userData(String uname) {
        ArrayList<Data> usrData = new ArrayList<Data>();
        Node temp = head;
        while(temp != null) {
            if(temp.data instanceof Data && temp.data.getUname(uname)) {
                usrData.add((Data)temp.data);
            }
            temp = temp.next;
        }
        return usrData;
    }
}