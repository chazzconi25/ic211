import java.util.Random;
import java.util.Scanner;
/**
 * ProbDayEvent is a more specific Event for daily payments/expenses
 * that will have a random chance of occuring.
 * @author Fasnoconi
 */
public class ProbDayEvent extends Event {
    //fields
    private double prob;
    private Random rand;

    /**
     * constructor for a new ProbDayEvent for daily payments/expenses
     * that will have a random chance of occuring.
     * @param displacement number of days or months between event occurences
     * @param startDate start date of this event
     * @param name the name of the payment/expense
     * @param isMonth is this a montly or daily event
     * @param prob probability this event will happen
     * @param rand random object to determine if this event occurs
     */
    public ProbDayEvent(int displacement, String startDate, String name,
                        boolean isMonth, double prob, Random rand) {
        super(displacement, startDate, name, isMonth);
        this.prob = prob;
        this.rand = rand; 
    }

    /**
     * Checks to see if this event occurs on a given date and randomly occurs
     * according to the events probability
     * @param testDate date to see if this events occurs on
     * @return true if this event occurs on testDate and randomly occurs
     * according to the events probability
     */
    public boolean happening(MyDate testDate) {
        return super.happening(testDate) && rand.nextDouble() <= prob;
    }

    /**
     * Reads in a new ProbDayEvent given a scanner
     * @param line a line of text that has information about an event
     * @param rand random object to determin if this event happens
     * @return new ProbDayEvent with information
     */
    public static ProbDayEvent read(Scanner line, Random rand) {
        line.next();
        int displacement = line.nextInt();
        line.next();
        line.next();
        String startDate = line.next();
        line.next();
        double prob = line.nextDouble();
        line.next();
        String name = buildName(line);
        return new ProbDayEvent(displacement, startDate, name, false,
                                prob, rand);
    }
}
