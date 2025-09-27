import stdlib.StdOut;

public class Fibonacci {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // A is -1 so we can start the sequence from zero (1 + -1 = 0, 1 + 0 = 1, etc)
        long a = -1;
        long b = 1;
        
        // Starting from 0 going to input n, add a to b & set a to the previous value of b.
        for(int i = 0; i <= n; i++){
            b = b + a;
            a = b - a;
        }
        
        StdOut.println(b);
        
    }
}
