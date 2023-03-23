/**
 * Class ModQueue extends Queue with overloaded versions of enqueue and dequeu
 * which alllows the user to not add multiple of a single string or dequeue up
 * to a given string. An extra method, dump() puts all of the queue into a comma
 * separated string
 * @author Fraqncoini
 */
public class ModQueue extends Queue {
    /**
     * deques strings from this queue up to string s
     * @param s String to stop deuqeueing up to
     */
    public void dequeue(String s) {
        String check;
        do {
            check = super.dequeue();
        } while(!check.equals(s));
    }

    /**
     * allows the user to enuque new strings. Does not add duplicate strings
     * @param s String to be added
     */
    public void enqueue(String s) {
        if(!super.empty()) {
            String [] inputs = super.toArray();
            for(int i = 0; i < inputs.length; i++) {
                if(inputs[i].equals(s)) {
                    return;
                }
            }
        }
        super.enqueue(s);
    }

    /**
     * makes this queue into a comma separated string for printing
     * @return comma separated list of the strings in this queue
     */
    public String dump() {
        String result = "";
        String [] inputs = super.toArray();
        for(int i = 0; i < inputs.length - 1; i++) {
            result += inputs[i] + ",";
        }
        result += inputs[inputs.length-1];
        return result;
    }
}
