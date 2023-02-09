public class Enigma {
    final String[] DEFAULT_ROTORS = new String[] {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    Rotor outer;
    Rotor mid;
    Rotor inner;

    Enigma(int id1, int id2, int id3, String starts) {
        inner = new Rotor(DEFAULT_ROTORS[id1-1], starts.charAt(0));
        mid = new Rotor(DEFAULT_ROTORS[id2-1], starts.charAt(1));
        outer = new Rotor(DEFAULT_ROTORS[id3-1], starts.charAt(2));
    }


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
    private char encryptChar(char a) {
        char one = outer.letterAtPos(inner.rotorPos(a));
        char two = outer.letterAtPos(mid.rotorPos(one));
        return two;
    }
    private char decryptChar(char a) {
        char one = mid.letterAtPos(outer.rotorPos(a));
        char two = inner.letterAtPos(outer.rotorPos(one));
        return two;
    }

    public String decrypt(String message) {
        String decrypted = "";
        for(int i = 0; i < message.length(); i++) {
            decrypted += decryptChar(message.charAt(i));
            inner.rotateClockwise(26);
            if((i + 1) % 27 == 0) {
                mid.rotateClockwise(26);
            }
            if((i + 1) % (27*27) == 0) {
                outer.rotateClockwise(26);
            }
        }
        return decrypted;
    }

    public static void main(String [] args) {
        Enigma test = new Enigma(1,2,3,"###");
        System.out.println(test.encrypt("AAA"));
    }
}
