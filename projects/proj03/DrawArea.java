import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class DrawArea extends JComponent {
    // constructor
    public DrawArea () {
        super();
        setPreferredSize(new Dimension(400, 400));
    }

    // methods
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // cast
        Graphics2D g2 = (Graphics2D) g;

        // to make the drawing look better
        // include the following code
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);

        // draw an ellipse
        g2.setColor(new Color(255,51,255, 255));
        g2.draw(new Ellipse2D.Double(25, 68, 100, 200));
        
        // drawing an image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("shark1.png"));
        } catch (Exception e) {}
        g2.drawImage(img, 80, 120, null);
        

        // TODO: play with these :)
        // playing with transform: rotating image
        AffineTransform tf = new AffineTransform();
        tf.rotate(Math.toRadians(90), img.getWidth()/2, img.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        img = op.filter(img, null);
        g2.drawImage(img, 20, 20, null);
 
       
        // shrinking image
        tf.scale(.5, .5);
        op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        img = op.filter(img, null); 
        g2.drawImage(img, 0, 10, null);

    }
}
