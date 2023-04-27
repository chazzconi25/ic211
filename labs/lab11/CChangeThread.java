import javax.swing.*;
/**
 * This class creates a thread for CChange so the color can change when the
 * button is clicked
 * @author Charlie Fsncaoni
 */
public class CChangeThread extends Thread {
    private JLabel label;

    /**
     * constructor for the thread
     * @param label label this thread is attached to
     */
    public CChangeThread (JLabel label) {
        this.label = label;
    }

    /**
     * runs this thread and uses the CChange method changeColor
     */
    public void run() {
        CChange.changeColor(label);
    }
}
