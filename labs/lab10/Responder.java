import java.awt.event.*;

public class Responder implements ActionListener {
  private UCFrame f;
  public Responder(UCFrame f) {
    this.f = f;
  }

  public void actionPerformed(ActionEvent e) {
    f.recalculate();
    f.resetFocus();
  }
}