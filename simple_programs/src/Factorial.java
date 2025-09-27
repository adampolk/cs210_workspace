import stdlib.StdOut;

public class Factorial {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long result = 1;

        // Get the product of all numbers from 1 to n inclusive
        for(int i = 1; i<=n; i++){
            result *= i;
        }
        StdOut.println(result);
    }
}
