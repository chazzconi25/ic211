import java.util.*;

public class hw02 {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] A = new String[n]; 
        for(int i = 0; i < n; i++) {
            A[i] = in.next();
        }
        int max = maxLength(A);
        for(int j = 0; j < max; j++) {
            for(int i = 0; i < n; i++) {
                if(j <= A[i].length()-1) {
                    System.out.print(A[i].charAt(j) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static int maxLength(String[] A) {
        int max = A[0].length();
        for(int i = 1; i < A.length; i++) {
            if(A[i].length() > max) {
                max = A[i].length();
            }
        }
        return max;
    }
}
