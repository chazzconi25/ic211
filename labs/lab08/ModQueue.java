public class ModQueue extends Queue {
    public void dequeue(String s) {
        String check;
        do {
            check = super.dequeue();
        } while(!check.equals(s));
    }

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
