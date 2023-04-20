import javax.swing.*;
import java.awt.event.*;

public class TimerStart implements ActionListener {
  private JLabel label;
  private JTextField tf;
  private TimerThread c;
  public TimerStart(JLabel label, JTextField tf) {
    this.label = label;
    this.tf = tf;
  }

  public void actionPerformed(ActionEvent e) {
    int count = 0;
    
      try {
        if(c == null || !c.isAlive()) {
          count =  Integer.parseInt(tf.getText());
          TimerThread nthread = new TimerThread(label, count);
          c = nthread;
          c.start();
        }
      } catch (NumberFormatException f) {
        label.setText("ERROR");
      }
  }
}