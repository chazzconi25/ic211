import javax.swing.*;
import java.awt.*;
public class Aquarium {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Francesconi, Charles m251806");
        DrawArea a = new DrawArea();
        f.add(a);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
      }
}