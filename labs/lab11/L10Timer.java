import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L10Timer {
  public static void main(String[] args) {
    JLabel label = new JLabel(" DONE ");
    label.setForeground(Color.RED);

    JTextField b1 = new JTextField("10");

    JButton b2 = new JButton("countdown");

    b2.addActionListener(new TimerStart(label));
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(label, BorderLayout.WEST);
    f.add(b1, BorderLayout.CENTER);
    f.add(b2, BorderLayout.EAST);
    f.pack();
    f.setVisible(true);
  }
}
