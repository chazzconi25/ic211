import javax.swing.*;

public class CChangeThread extends Thread {
    private JLabel label;

    public CChangeThread (JLabel label) {
        this.label = label;
    }

    public void run() {
        CChange.changeColor(label);
    }
}
