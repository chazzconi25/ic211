public class InvalidCharException extends Exception {
    private char invalid;
    public InvalidCharException(String msg, char invalid) {
        super(msg);
        this.invalid = invalid;
    }

    public char getChar(){
        return invalid;
    }
}