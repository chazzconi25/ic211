import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBn extends JButton implements ActionListener, WindowListener {
  private int count = 0;
  public CBn(String label) {
    super(label);
    this.addActionListener(this);
  }

  public void windowClosing(WindowEvent e) {
    System.out.println("Button clicked " +  count + " times.");
  }

  public void actionPerformed(ActionEvent e) {
    count++;
  }

  @Override
  public void windowActivated(WindowEvent arg0) {
  }

  @Override
  public void windowClosed(WindowEvent arg0) {
  }


  @Override
  public void windowDeactivated(WindowEvent arg0) {
  }

  @Override
  public void windowDeiconified(WindowEvent arg0) {
  }

  @Override
  public void windowIconified(WindowEvent arg0) {
  }

  @Override
  public void windowOpened(WindowEvent arg0) {
  }
}