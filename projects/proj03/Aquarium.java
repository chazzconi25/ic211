import javax.swing.*;
import java.awt.*;
public class Aquarium {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel options = new JPanel();
        JLabel label = new JLabel("as");
        JButton b = new JButton("null, null");
        f.setTitle("Francesconi, Charles m251806");
        DrawArea a = new DrawArea();
        f.add(options, BorderLayout.NORTH);
        options.add(label, BorderLayout.WEST);
        options.add(b, BorderLayout.EAST);
        f.add(a);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
      }
}