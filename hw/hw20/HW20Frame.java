import javax.swing.*;
import java.awt.*;

public class HW20Frame extends JFrame {
  public HW20Frame() {
    CBn b = new CBn("click me");

    add(b, BorderLayout.NORTH);
    pack();
    this.addWindowListener(b);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}