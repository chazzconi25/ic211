/**
 * Rotor class represents one rotor on an ingma machine. The rotor
 * can be searched for a specific letter and its position or find
 * a letter given a position. The rotor can also be rotated clockwise.
 * @author Charlie Francesconi
 */
public class Rotor {

    // Fields
    String state;

    /**
     * Constuctor for a rotor that represents a rotor on an Enigma
     * machiene. The state String is all of the characters on the
     * rotor and the char top represents the letter on the rotor that
     * is on top when the rotor is initalized
     * @param state the current rotation of the rotor
     * @param top the inital starting letter of the rotor
     */
    public Rotor(String state, char top) {
        this.state = state;
        int turns = state.indexOf(top);
        this.rotateClockwise(state.length() - turns);
    }

    /**
     * Adjusts the state string in this Rotor to represent turn(s)
     * clockwise
     * @param turns the amount of times the rotor should be roated
     * clockwise
     */
    public void rotateClockwise(int turns) {
        int len = state.length();
        turns = turns%len;
        this.state = state.substring(len - turns) 
                    + state.substring(0, len - turns);
    }

    /**
     * Returns the index of a letter on the Rotor's state
     * @param find character to find on the Rotor
     * @return the index of find in this Rotor's state
     */
    public int rotorPos(char find) {
        return state.indexOf(find);
    }


    /**
     * Returns the letter at a specificed index of the Rotor's state
     * @param index index on the rotor to search for a letter
     * @return letter at the given index
     */
    public char letterAtPos(int index) {
        return state.charAt(index);
    }

    /**
     * Used to debug Rotor.java - tests rotating a Rotor multiple
     * times
     * @param args command line arguments. Unused here.
     */
    public static void main(String [] args) {
        Rotor test = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", '#');
        System.out.println(test.state);
        test.rotateClockwise(1);
        System.out.println(test.state);
        test.rotateClockwise(26);
        System.out.println(test.state);
        test.rotateClockwise(26);
        System.out.println(test.state);
        test.rotateClockwise(26);
        System.out.println(test.state);

        
    }
}
