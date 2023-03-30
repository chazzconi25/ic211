import javax.swing.*;

public class Gui {
    public static void main(String [] args) {
        for(int i = 1; i <= 5; i++) {
            JFrame f = new JFrame();
            f.setTitle("hell part: " + i);
            f.setSize(200*i, 100*i);
            f.setLocation(200*i,200*i);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
    }
}