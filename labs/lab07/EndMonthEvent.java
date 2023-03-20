import java.util.Scanner;
/**
 * EndMonthEvent is a more specific Event for monthly payments/expenses
 * that will end after a period of months.
 * @author Farncsconi
 */
public class EndMonthEvent extends Event {
    // field
    private MyDate endDate;

    /**
     * constructor for an EndMonthEvent for monthly payments/expenses
     * that will end after a period of months.
     * @param displacement number of days or months between event occurences
     * @param startDate start date of this event
     * @param name the name of the payment/expense
     * @param isMonth is this a montly or daily event
     * @param end number of months till this event ends
     */
    public EndMonthEvent(int displacement, String startDate, String name,
                         boolean isMonth, int end) {
        super(displacement, startDate, name, isMonth);
        endDate = convertDate(startDate).clone();
        endDate.incMonth(end);
    }

    /**
     * Checks to see if this event occurs on a given date and is not expired
     * @param testDate date to see if this events occurs on
     * @return true if this event occurs on testDate and the event has not
     * expired (that is, gone past its end date)
     */
    public boolean happening(MyDate testDate) {
        return super.happening(testDate) && ended(testDate);
    }

    /**
     * helper method to see if this Event has expired
     * @param testDate date to see if this events end is past
     * @return true if this event is not expired
     */
    private boolean ended(MyDate testDate) {
        return testDate.daysUntil(endDate) > 0;
    }

    /**
     * Reads in a new EndMonthEvent given a scanner
     * @param line a line of text that has information about an event
     * @return new EndMonthEvent with information
     */
    public static EndMonthEvent read(Scanner line) {
        line.next();
        int displacement = line.nextInt();
        line.next();
        line.next();
        int end = line.nextInt();
        line.next();
        String startDate = line.next();
        line.next();
        String name = buildName(line);
        return new EndMonthEvent(displacement, startDate, name, true, end);
    }
}
