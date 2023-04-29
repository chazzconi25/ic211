import java.awt.*;
import java.util.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public abstract class Sprite {
    private BufferedImage texture;
    protected int health, x, y, goalx, goaly;
    protected double speed;
    protected Random r = new Random();
    protected DrawArea a;
    public Sprite(DrawArea a, String img, int health, int x, int y) {
        try {
            texture = ImageIO.read(new File(img));
        } catch (Exception e) {}
        this.health = health;
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public void paint(Graphics2D g) {
        g.rotate(15* (Math.PI / 180), x + (texture.getWidth()/2), y + (texture.getHeight()/2));
        g.drawImage(texture, x, y, null);
    }

    public abstract void step();
    public abstract void setGoal();

}
