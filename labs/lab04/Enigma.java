/**
 * Enigma class represents a full enigma machiene. The user can select
 * from 5 default rotors and choose starting positons on 3 of them
 * to encrypt or decrypt messages.
 */
public class Enigma {

    // fields 
    final String[] DEFAULT_ROTORS = new String[] {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    Rotor outer;
    Rotor mid;
    Rotor inner;

    /**
     * Constructs a new Engima machiene given three default rotor
     * numbers and a string representing the starting positions of
     * those rotors
     * @param id1 the number of the first default rotor to be used as
     * the inner rotor on the enigma machiene
     * @param id2 the number of the first default rotor to be used as
     * the mid rotor on the enigma machiene
     * @param id3 the number of the first default rotor to be used as
     * the outer rotor on the enigma machiene
     * @param starts the starting characters of each rotor in the
     * order they were passed to the Enigma constructor
     */
    Enigma(int id1, int id2, int id3, String starts) {
        inner = new Rotor(DEFAULT_ROTORS[id1-1], starts.charAt(0));
        mid = new Rotor(DEFAULT_ROTORS[id2-1], starts.charAt(1));
        outer = new Rotor(DEFAULT_ROTORS[id3-1], starts.charAt(2));
    }

    /**
     * Encrypts a given message in enigma using the supplied rotors
     * and starting positions of those rotors
     * @param message message to be encrypted
     * @return encrypted message
     */
    public String encrypt(String message) {
        String encrypted = "";
        for(int i = 0; i < message.length(); i++) {
            encrypted += encryptChar(message.charAt(i));
            inner.rotateClockwise(1);
            if((i + 1) % 27 == 0) {
                mid.rotateClockwise(1);
            }
            if((i + 1) % (27*27) == 0) {
                outer.rotateClockwise(1);
            }

        }
        return encrypted;
    }

    /**
     * Decrypts a given message in enigma using the supplied rotors
     * and starting positions of those rotors
     * @param message message to be decrypted
     * @return decrypted message
     */
    public String decrypt(String message) {
        String decrypted = "";
        for(int i = 0; i < message.length(); i++) {
            decrypted += decryptChar(message.charAt(i));
            inner.rotateClockwise(1);
            if((i + 1) % 27 == 0) {
                mid.rotateClockwise(1);
            }
            if((i + 1) % (27*27) == 0) {
                outer.rotateClockwise(1);
            }
        }
        return decrypted;
    }

    /**
     * Encrypts a single letter using the rotors and starting
     * positions of this Enigma machinene.
     * @param a letter to be encrypted
     * @return encrypted letter
     */
    private char encryptChar(char a) {
        char one = outer.letterAtPos(inner.rotorPos(a));
        char two = outer.letterAtPos(mid.rotorPos(one));
        return two;
    }

    /**
     * Decrypts a single letter using the rotors and starting
     * positions of this Enigma machinene.
     * @param a letter to be decrypted
     * @return decrypted letter
     */
    private char decryptChar(char a) {
        char one = mid.letterAtPos(outer.rotorPos(a));
        char two = inner.letterAtPos(outer.rotorPos(one));
        return two;
    }
    
    /**
     * Tests the machene by encrypting a simple message
     * @param args command line arguments. Unused here.
     */
    public static void main(String [] args) {
        Enigma test = new Enigma(1,2,3,"###");
        System.out.println(test.encrypt("AAA"));
    }
}
