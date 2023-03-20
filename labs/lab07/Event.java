import java.util.*;
/**
 * Event class represents a repeating monthly or daily payment/income
 * @author Francesconi
 */
public class Event {
    //fields
    private int displacement;
    private MyDate startDate;
    private String name;
    private boolean isMonth;

    /**
     * Event constructor that represents a repeating event that is a montly or
     * daily payment/expense
     * @param displacement number of days or months between event occurences
     * @param startDate start date of this event
     * @param name the name of the payment/expense
     * @param isMonth is this a montly or daily event
     */
    public Event(int displacement, String startDate, String name,
                 boolean isMonth) {
        this.displacement = displacement;
        this.startDate = convertDate(startDate);
        this.name = name;
        this.isMonth = isMonth;
    }

    /**
     * Reads in a new event given a scanner
     * @param line a line of text that has information about an event
     * @param isMonth is this a montly or daily event
     * @return new Event with information
     */
    public static Event read(Scanner line, boolean isMonth) {
        line.next();
        int displacement = line.nextInt();
        line.next();
        line.next();
        String startDate = line.next();
        line.next();
        String name = buildName(line);
        return new Event(displacement, startDate, name, isMonth);
    }

    /**
     * helper method for scanning in the event name from a line
     * @param sc scanner containing a line of text for an Event
     * @return the name of the event
     */
    public static String buildName(Scanner sc) {
        String name = "";
        while(sc.hasNext()) {
            name += sc.next();
            if(sc.hasNext()) {
                name += " ";
            }
        }
        return name;
    }

    /**
     * Returns the name of the event
     * @return name the name of the event
     */
    public String toString() {
        return name;
    }

    /**
     * helper method that converts a string date into a MyDate
     * @param date string date in format mm/dd/yyyy
     * @return returns the date given in a MyDate
     */
    public static MyDate convertDate(String date) {
        String dateSplit [] = date.split("/");
        return new MyDate(Integer.parseInt(dateSplit[2]),
                        Integer.parseInt(dateSplit[0]),
                        Integer.parseInt(dateSplit[1]));
    }

    /**
     * Checks to see if this event occurs on a given date
     * @param testDate date to see if this events occurs on
     * @return true if this event occurs on testDate
     */
    public boolean happening(MyDate testDate) {
        MyDate temp = startDate.clone();
        if(isMonth) {
            while(temp.daysUntil(testDate) > 0) {
                temp.incMonth(displacement);
            }
            return temp.daysUntil(testDate) == 0;
        } else {
            while(temp.daysUntil(testDate) > 0) {
                temp.incDay(displacement);
            }
            return temp.daysUntil(testDate) == 0; 
        }
    }
}
