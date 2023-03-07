import java.io.*;
import java.util.*;

public class Lab07 {
    public static void main(String [] args) {
        if(args.length <= 1) {
            System.out.println("usage: java Lab07 <infilename> <numDays>");
            System.exit(1);
        }
        String filename = args[0];
        
        // create a random object for use
        Random rand;
        if( args.length == 3 ) {
            rand = new Random(Long.parseLong(args[2]));
        } else {
            rand = new Random(System.currentTimeMillis());
        }

        int lines = 0;
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            lines = FileLineCounter.countLines(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Event[] allEvents = new Event[lines];
        Scanner sc = new Scanner(new FileReader(filename));
        for(int i = 0; i < lines; i++) {
            String [] line = sc.nextLine().split(" ");
            if(line[2].equals("months")) {
                if(line[3].equals("for")) {
                    allEvents[i] = new EndMonthEvent(Integer.parseInt(line), line[6], )
                } else {

                }
            } else {
                if(line[5].equals("prob")) {

                } else {

                }
            }

        }
        int numDays = Integer.parseInt(args[1]);
        // set "today" to 1/1/2017
        MyDate today = new MyDate(2017,1,1);
         allEvents = Event.eventsFromfile(sc);
        for( int i=0; i < numDays; i++ ) {
            // ask each event whether they have something going on "today"
            Queue todaysBills =  new Queue();
            for(int j = 0; j < allEvents.length; j++) {
                if(allEvents[j].happening(today)) {
                    todaysBills.enqueue(allEvents[j]);
                }
            }
            // if any do, print them out
            if(!todaysBills.empty()) {
                System.out.print(today + ": ");
                todaysBills.printAll();
            }
            // increment "today"
            today.incDay(1);
        }
    }
}