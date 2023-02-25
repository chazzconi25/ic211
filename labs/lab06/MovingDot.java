public class MovingDot extends Dot {
    protected int steps = 0;
    protected int dir = 0; // N = 0; E = 1, S = 2, W = 3 

    // a constructor that takes row and column position as integers
    public MovingDot(int r, int c){
        super(r, c);
    }

    // a step method that moves the Dot in the direction that it is facing 
    // for the first step, choose an arbitrary direction
    public void step(){
        if(dir == 0) {
            incRow();
        } else if(dir == 1) {
            incCol();
        } else if(dir == 2) {
            decRow();
        } else {
            decCol();
        }
    }
}
