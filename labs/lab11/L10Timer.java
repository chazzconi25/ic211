import javax.swing.*;
import java.awt.*;
/**
 * Runs three timers that count down from a given time.
 * @author Charlie Fransconi
 */
public class L10Timer {
  /**
   * Creates a GUI with three timers that count down from a given time
   * @param args not used
   */
  public static void main(String[] args) {
    JLabel label1 = new JLabel(" DONE ");
    label1.setForeground(Color.RED);
    label1.setPreferredSize(new Dimension(60,15));
    JTextField tf1 = new JTextField("10", 10);
    JButton b1 = new JButton("countdown");
    b1.addActionListener(new TimerStart(label1 , tf1));

    JLabel label2 = new JLabel(" DONE ");
    label2.setForeground(Color.RED);
    label2.setPreferredSize(new Dimension(60,15));
    JTextField tf2 = new JTextField("10", 10);
    JButton b2 = new JButton("countdown");
    b2.addActionListener(new TimerStart(label2 , tf2));

    JLabel label3 = new JLabel(" DONE ");
    label3.setForeground(Color.RED);
    label3.setPreferredSize(new Dimension(60,15));
    JTextField tf3 = new JTextField("10", 10);
    JButton b3 = new JButton("countdown");
    b3.addActionListener(new TimerStart(label3 , tf3));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane1 = new JPanel();
    pane1.add(label1, BorderLayout.WEST);
    pane1.add(tf1, BorderLayout.CENTER);
    pane1.add(b1, BorderLayout.EAST);
    JPanel pane2 = new JPanel();
    pane2.add(label2, BorderLayout.WEST);
    pane2.add(tf2, BorderLayout.CENTER);
    pane2.add(b2, BorderLayout.EAST);
    JPanel pane3 = new JPanel();
    pane3.add(label3, BorderLayout.WEST);
    pane3.add(tf3, BorderLayout.CENTER);
    pane3.add(b3, BorderLayout.EAST);

    f.add(pane1, BorderLayout.NORTH);
    f.add(pane2, BorderLayout.CENTER);
    f.add(pane3, BorderLayout.SOUTH);
    f.pack();
    f.setVisible(true);
  }
}
