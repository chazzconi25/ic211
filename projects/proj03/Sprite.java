import java.awt.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public abstract class Sprite {
    private BufferedImage texture;
    protected int health;
    protected int x, y;
    public Sprite(String img, int health, int x, int y) {
        try {
            texture = ImageIO.read(new File(img));
        } catch (Exception e) {}
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g) {
        g.drawImage(texture, x, y, null);
    }

    public abstract void step(int tankWidth, int tankHeight);

}
