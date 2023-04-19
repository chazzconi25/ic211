import java.awt.*;
import javax.swing.*;
public class Ex8 {
    public static void main(String [] args) {
        JFrame f = new JFrame();
        String s = "This is my button";
        JButton b = new MyButton(s);
        f.add(b);
        f.pack();
        f.setVisible(true);
    }
}