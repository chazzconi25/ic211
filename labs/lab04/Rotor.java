public class Rotor {
    private static char[] rotor = initRotor();

    private static char[] initRotor() {
        char [] rotor = new char[27];
        for(int i = 0; i <rotor.length -1; i++) {
            rotor[i] = (char)('A' + i);
        }
        rotor[26] = '#';
        return rotor;
    }

    public static void main(String [] args) {
        for(int i = 0; i < rotor.length; i++) {
            System.out.println(rotor[i]);
        }
    }
    
}
