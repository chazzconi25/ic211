public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) {
        String [] dateVals = date.split("-");
        this.year = Integer.parseInt(dateVals[0]);
        this.month = Integer.parseInt(dateVals[1]);
        this.day = Integer.parseInt(dateVals[2]);
    }

    public boolean equals(Date comp) {
        return year == comp.year && month == comp.month &&
                day == comp.day;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
