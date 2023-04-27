import javax.swing.*;
/**
 * Creates a thread for running a timer while GUI is running
 * @author Charlie Franceocni
 */
public class TimerThread extends Thread {
    private JLabel label;
    private int count;

    /**
     * Creates a new TimerThread that runs a clock that counts down from the 
     * given int
     * @param label label for this thread to update
     * @param count number to count down from
     */
    public TimerThread (JLabel label, int count) {
        this.label = label;
        this.count = count;
    }

    /**
     * Changes the text of the timer as the thread runs
     */
    public void run() {
        for(int i = count; i > 0; i--) {
            try {
                label.setText(""+ i);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        label.setText("DONE");
    }
}