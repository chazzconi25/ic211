import java.util.*;

public class Event {
    private Date startDate;
    private String name;
    private int displacement;
    public Event(int displacement, Date startDate, String name) {
        this.displacement = displacement;
        this.startDate = startDate;
        this.name = name;
    }

    public Event[] eventsFromfile(Scanner sc){
        sc.next();
        int disp = sc.nextInt();

        return 
    }

    public boolean happening(Date today) {
        return true;
    }

    public String toString() {
        return name;
    }
}
