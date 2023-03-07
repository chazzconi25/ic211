import java.util.*;

public class Event {
    private int displacement;
    private MyDate startDate;
    private String name;

    public Event(int displacement, String startDate, String name) {
        this.displacement = displacement;
        String date [] = startDate.split("/");
        this.startDate = makeDate(Integer.parseInt(date[2]),
                        Integer.parseInt(date[0]), Integer.parseInt(date[1]));
        this.name = name;
    }

    public boolean happening(Date today) {
        return true;
    }

    public String toString() {
        return name;
    }
}
