import stdlib.StdOut;

public class GCD {
    // Entry point.
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        // While q is not an even divisor
        while(p % q != 0){
            // Swap p with q and set q equal to the remainder of the previous value of p and itself
            int temp = p;
            p = q;
            q = temp % q;

            
        }
        StdOut.println(q);
    }
}
