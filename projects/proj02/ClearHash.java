public class ClearHash implements Hasher {
    private Encryptor E = new Clear();
    private String key;
    public String getHashName() {return "clear";}
    public void init(char[] key) throws InvalidCharException {
        this.key = new String(key);
        E.init(key);
    }

    public String hash() throws InvalidCharException {
        String encrypted =  E.encrypt(key);
        char[] hash = new char[16];
        for(int i = 0; i < 16; i++) {
            if(i < encrypted.length()) {
                hash[i] = encrypted.charAt(i);
            } else {
                hash[i] = 'x';
            }
        }
        return new String(hash);
    }
}
