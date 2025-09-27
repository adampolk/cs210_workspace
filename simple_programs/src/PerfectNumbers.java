import stdlib.StdOut;

public class PerfectNumbers {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // From 2 to n inclusive
        for(int i = 2; i <= n; i++){
            // The total sum of all factors of i
            int total = 0;

            // From 1 to i/2
            for(int j = 1; j <= i/2; j++){
                // Check if j is a factor of i & increase the total by j
                if(i % j == 0){
                    total += j;
                }
            }

            // If the sum of all factors is equal to i, then it is a perfect number
            if(total == i){
                StdOut.println(i);
            }
        }
    }
}
