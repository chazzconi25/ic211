import java.io.*;
import java.util.*;

public class Lab07 {
    public static void main(String [] args) throws FileNotFoundException {
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
        
        //count lines in file
        int lines = 0;
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            lines = FileLineCounter.countLines(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // store all events in an array
        Event[] allEvents = new Event[lines];
        Scanner sc = new Scanner(new FileReader(filename));
        for(int i = 0; i < lines; i++) {
            String line = sc.nextLine();
            //check to see type of event when reading in
            if(line.indexOf("month") != -1) {
                if(line.indexOf("for") != -1) {
                    allEvents[i] = EndMonthEvent.read(new Scanner(line));
                } else {
                    allEvents[i] = Event.read(new Scanner(line), true);
                }
            } else {
                if(line.indexOf("prob") != -1) {
                    allEvents[i] = ProbDayEvent.read(new Scanner(line), rand);
                } else {
                    allEvents[i] = Event.read(new Scanner(line), false);
                }
            }
        }
        int numDays = Integer.parseInt(args[1]);
        // set "today" to 1/1/2017
        MyDate today = new MyDate(2017,1,1);
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