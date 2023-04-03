public interface Hasher {
    public String getHashName();
    public void   init(char[] key) throws InvalidCharException;
    public String hash() throws InvalidCharException;
}
