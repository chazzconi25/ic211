import java.util.Base64.Decoder;

import javax.swing.plaf.synth.SynthStyle;

public class MovingDot extends Dot {
    protected int steps = 0;
    private int dir = 0; // N = 0; E = 1, S = 2, W = 3

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

    public void diagonal() {
        if(dir == 0) {
            incRow();
            decCol();
        } else if(dir == 1) {
            incRow();
            incCol();
        } else if(dir == 2) {
            decRow();
            incCol();
        } else {
            decRow();
            decCol();
        }
    }

    public void left() {
        if(dir == 0) {
            //decCol();
            dir = 3;
        } else if(dir == 1) {
            //incRow();
            dir = 0;
        } else if(dir == 2) {
            //incCol();
            dir = 1;
        } else {
            //decRow();
            dir = 2;
        }
    }

    public void right() {
        if(dir == 0) {
            //incCol();
            dir = 1;
        } else if(dir == 1) {
            //decRow();
            dir = 2;
        } else if(dir == 2) {
            //decCol();
            dir = 3;
        } else {
            //incRow();
            dir = 0;
        }
    }

    public String toString() {
        return super.toString();
    }
}
