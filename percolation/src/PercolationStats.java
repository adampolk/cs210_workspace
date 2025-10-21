import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    private int m; // number of percolation experiments
    private double[] x; // fraction of sites opened for each trial until percolation

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        if(n <= 0 || m <= 0){
            throw new IllegalArgumentException("Illegal n or m");
        }
        this.m = m;
        this.x = new double[m];
        for(int i = 0; i < m; i++){
            Percolation p = new Percolation(n);
            while(!p.percolates()){
                // Potentially update this to not include sink or source?
                int x = StdRandom.uniform(0, n);
                int y = StdRandom.uniform(0, n);
                p.open(x, y);
            }
            
            this.x[i] = ((double) p.numberOfOpenSites()) / (n*n);
        }
    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        return StdStats.mean(x);
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        return StdStats.stddev(x);
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        return this.mean() - (1.96 * (this.stddev()) / Math.sqrt(m));
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        return this.mean() + (1.96 * (this.stddev()) / Math.sqrt(m));
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, m);
        StdOut.printf("Percolation threshold for a %d x %d system:\n", n, n);
        StdOut.printf("  Mean                = %.3f\n", stats.mean());
        StdOut.printf("  Standard deviation  = %.3f\n", stats.stddev());
        StdOut.printf("  Confidence interval = [%.3f, %.3f]\n", stats.confidenceLow(), stats.confidenceHigh());
    }
}
