import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Aquarium {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel options = new JPanel();
        JButton b1 = new JButton("Feed 1");
        JButton b2 = new JButton("Feed 5");
        JButton b3 = new JButton("AutoFeed");
        f.setTitle("Francesconi, Charles m251806");
        ArrayList<Sprite> sprites = new  ArrayList<Sprite>();
        DrawArea a = new DrawArea(sprites);
        f.add(options, BorderLayout.NORTH);
        options.add(b1, BorderLayout.EAST);
        options.add(b2, BorderLayout.CENTER);
        options.add(b3, BorderLayout.WEST);
        f.add(a);
        Thread thread = new Thread(a);
        a.addPlankton(sprites);
        a.addSmallFish(sprites);
        thread.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
      }
}