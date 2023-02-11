/**
 * RandomWordLit allows the user to create and seed an object that will return
 * random words. Each word generated from this RandomWord will have the same 
 * first letter.
 * @author Charlie Francesconi 
 */
public class RandomWordLit extends RandomWord {
    //fields
    char letter;

    /**
     * Constructs a RandomWordLit object using a specified seed to predict
     * random word generation.
     * @param seed number representing seed for predictable random generation
     */
    public RandomWordLit(long seed) {
        super(seed);
        letter = ' ';
    }

    /**
     * Returns a random word from this RandomWordLit. Every word generated from
     * this RandomWordLit will have the same first letter. The first word 
     * generated will have a random first letter that is used for every later
     * word.
     * @return String word - random word with the same letter as the every word
     * generated from this RandomWordLit.
     */
    public String next() {
        String word = super.next();
        if(letter == ' ') {
            letter = word.charAt(0);
        } else {
            while(word.charAt(0) != letter) {
                word = super.next();
            }
        }
        return word;
    }
}
