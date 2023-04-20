import java.awt.*;
import javax.swing.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class DrawArea extends JComponent {
    // constructor
    public DrawArea () {
        super();
        setPreferredSize(new Dimension(0, 0));
    }

    // methods
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // to make the drawing look better
        // include the following code
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        
        // drawing an image
        BufferedImage background = null;
        try {
            background = ImageIO.read(new File("background.png"));
        } catch (Exception e) {}
        this.setPreferredSize(new Dimension(background.getWidth(), background.getHeight()));
        g2.drawImage(background, 0, 0, null);

    }
}
