import javax.swing.*;
import java.awt.event.*;
/**
 * Starts a timer when the user clicks on a start button and counts down given 
 * a field contaning the number to count down from
 * @author Charlie Francskconi
 */
public class TimerStart implements ActionListener {
  private JLabel label;
  private JTextField tf;
  private TimerThread c;

  /**
   * constructor for new TimerStart
   * @param label lable to update
   * @param tf field to get time to count down from
   */
  public TimerStart(JLabel label, JTextField tf) {
    this.label = label;
    this.tf = tf;
  }

  /**
   * When the timer is clicked verify if it is already running in a thread.
   * @param e action event fot if this button is clicked
   */
  public void actionPerformed(ActionEvent e) {
    int count = 0;
    try {
      if(c == null || !c.isAlive()) {
        count =  Integer.parseInt(tf.getText());
        if(count < 0) {
          throw new NegTimerException("ERROR");
        }
        TimerThread nthread = new TimerThread(label, count);
        c = nthread;
        c.start();
      }
    } catch (NegTimerException f){
      label.setText("ERROR");
    } catch (NumberFormatException f) {
      label.setText("ERROR");
    }
  }
}