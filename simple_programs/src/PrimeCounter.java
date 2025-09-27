import stdlib.StdOut;

public class PrimeCounter {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;

        // Check & count all numbers from [2, i] that are prime
        for(int i = 2; i <= n; i++){
            int j = 2;

            // Same logic as PrimalityTest.java, find the smallest factor of i (if any)
            while(j <= i/j){
                if(i % j == 0){
                    break;
                }
                j++;
            }

            // Check whether a factor was found
            if(j > i/j){
                count += 1;
            }
        }
        StdOut.println(count);
    }
}