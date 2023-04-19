import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton{
    public MyButton(String s) {
        super(s);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(75, 5, 140, 15);
        g.setColor(Color.BLACK);
        g.drawString("added button", 80, 18);
    }
}
