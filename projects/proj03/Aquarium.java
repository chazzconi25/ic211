import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Aquarium {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel options = new JPanel();
        JLabel label = new JLabel("as");
        JButton b = new JButton("null, null");
        f.setTitle("Francesconi, Charles m251806");
        ArrayList<Sprite> sprites = new  ArrayList<Sprite>();
        DrawArea a = new DrawArea(sprites);
        f.add(options, BorderLayout.NORTH);
        options.add(label, BorderLayout.WEST);
        options.add(b, BorderLayout.EAST);
        f.add(a);
        Thread thread = new Thread(a);
        thread.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
      }
}