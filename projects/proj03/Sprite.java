import java.awt.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public abstract class Sprite {
    private Graphics2D g2;
    private BufferedImage texture;
    private int health;

    public Sprite(String img) {
        try {
            texture = ImageIO.read(new File(img));
        } catch (Exception e) {}
        
    }

    public abstract void move();


}
