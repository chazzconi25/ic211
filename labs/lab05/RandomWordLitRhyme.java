/**
 * RandomWordLitRhyme allows the user to create and seed an object that will
 * return random words. Each word generated from this RandomWord will have
 * the same first letter and last two letters.
 * @author Charlie Francesconi 
 */
public class RandomWordLitRhyme extends RandomWordLit {
    
    // fields 
    private String lastTwo;

    /**
     * Constructs a RandomWordLitRhyme object using a specified seed to predict
     * random word generation.
     * @param seed number representing seed for predictable random generation
     */
    public RandomWordLitRhyme(long seed) {
        super(seed);
        lastTwo = "";
    }

    /**
     * Returns a random word from this RandomWordLitRhyme. Every word
     * generated from this RandomWordLitRhyme will have the same first letter
     * and last two letters. The first word generated will have a random first
     * letter and last two letters that is used for every later word.
     * @return String word - random word with the same first letter and last
     * two letterts as the every word generated from this RandomWordLitRhyme.
     */
    public String next() {
        String word = super.next();
        if(lastTwo.equals("")) {
            lastTwo = word.substring(word.length()-2);
        } else {
            while(!word.substring(word.length()-2).equals(lastTwo)) {
                word = super.next();
            }
        }
        return word;
    }
}
