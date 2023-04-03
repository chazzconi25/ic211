public class User {
    private String name;
    private String hashName;
    private Hasher hashType;
    private String hash;

    public User(String name, String hashName, Hasher hashType, String hash) {
        this.name = name;
        this.hashType = hashType;
        this.hash = hash;
        this.hashName = hashName;
    }

    public boolean correctPass(char [] password) throws Exception {
        String test = "";
        if(hashType == null) {
            throw new UnsupportedHashException("Error! Hash algorithm \'" + hashName + "\' not supported.");
        }
        hashType.init(password);
        test = hashType.hash();
        return test.equals(hash);
    }

    public String getUname() {
        return name;
    }

    public String getHashName() {
        return hashName;
    }

}
