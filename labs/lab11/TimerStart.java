import javax.swing.*;
import java.awt.event.*;

public class TimerStart implements ActionListener {
  private JLabel label;
  private TimerThread c;
  public TimerStart(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    if(c == null || !c.isAlive()) {
        TimerThread nthread = new TimerThread(label);
        c = nthread;
        c.start();
    }
  }
}