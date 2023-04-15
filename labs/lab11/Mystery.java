import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener {
  private JLabel label;
  private CChangeThread c;
  public Mystery(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    if(c == null || !c.isAlive()) {
        CChangeThread nthread = new CChangeThread(label);
        c = nthread;
        c.start();
    }
  }
}