import java.util.*;
public class Midshipman {
    private double speed;
    private double strength;
    private double intelligence;
    private double heart;
    private String alpha;
    private String first;
    private String last;

    public Midshipman(String alpha, String first, String last, double speed, double strength, double intelligence, double heart) {
        this.alpha = alpha;
        this.first = first;
        this.last = last;
        this.speed = speed;
        this.strength = strength;
        this.intelligence = intelligence;
        this.heart = heart;
    }

    // MADE PRIVATE BECAUSE NOT USED IN EXAM1 AND ONLY SERVES AS A HELPER
    // FUNCTION TO function willBeat() WHICH IS INSIDE THIS CLASS
    private double getAbility(Random r) {
        return (0.3*speed)+(0.2*strength)+(0.4*intelligence)+(0.1*heart) + 20*r.nextDouble();
    }

    public boolean willBeat(Midshipman x, Random r) {
        return this.getAbility(r) > x.getAbility(r);
    }

    public String toString() {
        return alpha + ": "+ last + ", " + first;
    }

    public static Midshipman read(Scanner in) {
        return new Midshipman(in.next(), in.next(), in.next(),
            in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
    }
}
