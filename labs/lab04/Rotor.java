public class Rotor {
    String state;

    public Rotor(String state, char top) {
        this.state = state;
        int turns = state.indexOf(top);
        this.rotateClockwise(state.length() - turns);
    }

    public void rotateClockwise(int turns) {
        int len = state.length();
        turns = turns%len;
        this.state = state.substring(len - turns) + state.substring(0, len - turns);
    }

    public int rotorPos(char find) {
        return state.indexOf(find);
    }

    public char letterAtPos(int index) {
        return state.charAt(index);
    }

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
