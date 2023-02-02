public class Enigma {
    final String[] DEFAULT_ROTORS = new String[] {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };
    final String NORMAL = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    Rotor outer;
    Rotor mid;
    Rotor inner;

    Enigma(int id1, int id2, int id3, String starts) {
        inner = new Rotor(DEFAULT_ROTORS[id1-1], starts.charAt(0));
        mid = new Rotor(DEFAULT_ROTORS[id2-1], starts.charAt(1));
        outer = new Rotor(DEFAULT_ROTORS[id3-1], starts.charAt(2));
    }

    public String encrypt(String message) {

        return ;
    }

    public String encryptChar(String a) {
        String one = inner.letterAtPos(NORMAL.indexOf(a));
        String two = inner.letterAtPos(NORMAL.indexOf(one));
        String three = inner.letterAtPos(NORMAL.indexOf(two));
        return three;
    }

    public static void main() {
        Enigma test = new Enigma(1,2,3,"###");
        System.out.println(test.encrypt("AAA"));
    }
}
