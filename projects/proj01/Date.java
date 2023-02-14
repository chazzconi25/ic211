/**
 * Represents a Date in time with a year month and day
 * @author Charlie Francesconi
 */
public class Date {

    //Fields
    private int year;
    private int month;
    private int day;

    /**
     * Constructor for a date object
     * @param date String represening a date in format yyyy-mm-dd
     */
    public Date(String date) {
        String [] dateVals = date.split("-");
        this.year = Integer.parseInt(dateVals[0]);
        this.month = Integer.parseInt(dateVals[1]);
        this.day = Integer.parseInt(dateVals[2]);
    }

    /**
     * Checks if this Date is on the same day as another
     * @param comp Date to compare this Date to
     * @return True if comp is on the same day as this Date
     */
    public boolean equals(Date comp) {
        return year == comp.year && month == comp.month &&
                day == comp.day;
    }

    /**
     * Returns this Date in a String format
     * @return prits this Date in format mm/dd/yyyy
     */
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
