public class Plankton extends Sprite {
    public Plankton(DrawArea a, String img) {
        super(a, img, 100, 0, 0);
        x =  r.nextInt(a.getWidth());
        goaly = r.nextInt(a.getHeight());   
    }
    
    public void step() {
        if(y < goaly) {
            y++;
        }
    }
    public void setGoal() {}
    
}
