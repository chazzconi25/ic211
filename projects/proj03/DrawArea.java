import java.awt.*;
import javax.swing.*;
import java.util.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class DrawArea extends JComponent implements Runnable{
    // constructor
    private BufferedImage background;
    private ArrayList<Sprite> sprites;
    private int width, height;

    public DrawArea (ArrayList<Sprite> sprites) {
        super();
        try {
            background = ImageIO.read(new File("background.png"));
        } catch (Exception e) {}
        width = background.getWidth();
        height = background.getHeight();
        setPreferredSize(new Dimension(width, height));
        this.sprites = sprites;
        // sprites.add(new Plankton("plankton.png", width, height));
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
        g2.drawImage(background, 0, 0, null);
        for(Sprite s: sprites){
            s.paint(g2);
        }
    }

    public void step() {
        for(Sprite i: sprites) {
            i.step();
        } 
    }

    @Override
    public void run() {
        while( true ) {
            try {
              Thread.sleep(20);
            } catch (Exception e) {}
            step();
      
            // repaint calls the paintComponent() method
            repaint();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
