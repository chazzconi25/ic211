import javax.swing.*;

public class TimerThread extends Thread {
    private JLabel label;
    private int count;
    public TimerThread (JLabel label, int count) {
        this.label = label;
        this.count = count;
    }

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