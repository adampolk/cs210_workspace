import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats {
    // Entry Point.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        // double range = b - a;
        // double x1 = Math.random() * range + a;
        // double x2 = Math.random() * range + a;
        // double x3 = Math.random() * range + a;
        double x1 = StdRandom.uniform(a, b);
        double x2 = StdRandom.uniform(a, b);
        double x3 = StdRandom.uniform(a, b);
        double m = (x1 + x2 + x3) / 3;
        double var = (Math.pow(x1 - m, 2) + (Math.pow(x2 - m, 2) + (Math.pow(x3-m, 2))) / 3);
        double std = Math.sqrt(var);
        StdOut.println(m + " " + var + " " + std);
    }
}
