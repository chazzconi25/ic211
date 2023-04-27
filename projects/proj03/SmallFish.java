public class SmallFish extends Sprite {
    public SmallFish(DrawArea a, String img) {
        super(a, img, 100, 0, 0);
        x = r.nextInt(a.getWidth());
        y = r.nextInt(a.getHeight());
        goalx = r.nextInt(a.getWidth());
        goaly = r.nextInt(a.getHeight());
        speed = 20;
    }

    public void step() {
        if (Math.sqrt(Math.pow(goaly - y, 2) + Math.pow(goalx - x, 2)) < speed){
            x = goalx;
            y = goaly;
            setGoal();
          } else {
            double a = Math.atan2(goaly - y, goalx - x);
            x += speed * Math.cos(a);
            y += speed * Math.sin(a);
        }
    }

    public void setGoal() {
        goalx = r.nextInt(a.getWidth());
        goaly = r.nextInt(a.getHeight());
    }
    
}
