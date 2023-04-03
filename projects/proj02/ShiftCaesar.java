public class ShiftCaesar implements Hasher {
    private Encryptor E = new Caesar();
    public String getHashName() {return "shift+caesar";}
    public void init(char[] key) throws InvalidCharException {
        E.init(key);
    }

    public String hash() throws InvalidCharException {
        String x = "GO_NAVY_2018^mid";
        for(int i = 0; i < 16; i++) {
            char c = x.charAt(i);
            int k = c % 16;
            x = shift(k, x);
            x = E.encrypt(x);
        }
        return x;
    }

    private static String shift(int turns, String x) {
        int len = x.length();
        turns = turns%len;
        x = x.substring(turns) + x.substring(0, turns);
        return x;
    }

    public static void main(String [] args) {
        String test = "abcdefghijk";
        shift(1, test);
        System.out.println(test);
    }
}
