import javax.swing.*;
import java.awt.event.*;
public class Timer implements ActionListener {
    private JLabel label;
    public Timer(JLabel label) {
        this.label = label;
    }
    
    public void actionPerformed(ActionEvent e) {
        label.setText();
    }
}
