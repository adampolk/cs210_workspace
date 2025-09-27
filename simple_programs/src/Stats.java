import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats {
    // Entry Point.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        // Get 3 random doubles between a (inclusive) and b (exclusive)
        // Need to cast to double here because if input = 0, 1 then only integer from [0, 1) is 0, meaning output will just be 0.0 0.0 0.0
        double x1 = StdRandom.uniform((double) a, (double) b);
        double x2 = StdRandom.uniform((double) a, (double) b);
        double x3 = StdRandom.uniform((double) a, (double) b);

        // Calculate the mean of the three doubles
        double m = (x1 + x2 + x3) / 3; 

        // Calculate the variance of the three doubles
        double var = ((x1-m)*(x1-m) + (x2-m)*(x2-m) + (x3-m)*(x3-m)) / 3;

        // Calculate the standard deviation of the three doubles
        double std = Math.sqrt(var);
        StdOut.println(m + " " + var + " " + std);
    }
}
