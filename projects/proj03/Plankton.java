import java.util.*;

public class Plankton extends Sprite {
    private Random r = new Random();
    private int maxHeight;
    public Plankton(String img, int tankWidth, int tankHeight) {
        super(img, 100, 0, 0);
        x = r.nextInt(tankWidth); 
        maxHeight = r.nextInt(tankHeight); 
    }
    
    public void step() {
        if(y < maxHeight) {
            y++;
        }
    }
    
}
