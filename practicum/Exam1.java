public class Exam1 {
    public static void main(String[] args) {
        Midshipman [] mids = new Midshipman[args.length/4];
        for(int i = 0; i < args.length; i+=4) {
            mids[i/4] = new Midshipman(Double.parseDouble(args[i]),
                Double.parseDouble(args[i+1]),
                Double.parseDouble(args[i+2]),
                Double.parseDouble(args[i+3]));
        }
        Midshipman best = mids[0];
        for(int i = 1; i < mids.length; i++) {
            if(!best.willBeat(mids[i])) {
                best = mids[i];
            }
        }
        System.out.println("Best Boxer: " + best);
    }
}
