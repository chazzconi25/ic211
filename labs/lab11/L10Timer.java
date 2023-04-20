import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class L10Timer {
  public static void main(String[] args) {
    JLabel label = new JLabel(" DONE ");
    label.setForeground(Color.RED);
    label.setPreferredSize(new Dimension(60,15));
    //label.setBorder(new EmptyBorder(0, 0, 0, 50));

    JTextField tf = new JTextField("10", 10);

    JButton b2 = new JButton("countdown");

    b2.addActionListener(new TimerStart(label , tf));
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(label, BorderLayout.WEST);
    f.add(tf, BorderLayout.CENTER);
    f.add(b2, BorderLayout.EAST);
    f.pack();
    f.setVisible(true);
  }
}
