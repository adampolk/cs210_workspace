import dsa.WeightedQuickUnionPathCompressionUF;
import stdlib.In;
import stdlib.StdOut;

public class Percolation {
    private int n; // size of the percolation system
    private boolean[][] grid; // representation of the system (true = open site, false = blocked site)
    private int openSites; // number of sites opened
    private WeightedQuickUnionPathCompressionUF uf1; // for testing percolation
    private WeightedQuickUnionPathCompressionUF uf2; // for preventing backwash
    private int source; // source site (id = 0)
    private int sink; // sink site (id = n * n + 1)

    // Constructs an n x n percolation system, with all sites blocked.
    public Percolation(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("Illegal n");
        }
        this.n = n;
        this.grid = new boolean[n][n];
        this.openSites = 0;
        uf1 = new WeightedQuickUnionPathCompressionUF(n * n + 2);
        uf2 = new WeightedQuickUnionPathCompressionUF(n * n + 1); // no sink to solve backwash problem
        this.source = 0;
        this.sink = n * n + 1;
    }

    // Opens site (i, j) if it is not already open.
    public void open(int i, int j) {
        // Handle edge cases
        if(i < 0 || i > n - 1 || j < 0 || j > n - 1){
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        if(!grid[i][j]){
            grid[i][j] = true;
            openSites++;
            int encoded_site = encode(i, j);

            if(i == 0){ // If site is in the first row, then connect the site with the source
                uf1.union(encoded_site, source);
                uf2.union(encoded_site, source);
            }else if(i == n - 1){ // If the site is in the last row, then connect the site with the sink
                // Only connect the first union find object. The second should not be connect to sink to solve backwash problem.
                uf1.union(encoded_site, sink);
            }

            // Check if neighboring sites are open, and connect if true
            if(i > 0 && grid[i - 1][j]) { // Northern neighbor
                uf1.union(encoded_site, encode(i - 1, j));
                uf2.union(encoded_site, encode(i - 1, j));
            }

            if(i < n - 1 && grid[i + 1][j]) { // Southern neighbor
                uf1.union(encoded_site, encode(i + 1, j));
                uf2.union(encoded_site, encode(i + 1, j));

            }

            if(j < n - 1 && grid[i][j + 1]){ // Eastern neighbor
                uf1.union(encoded_site, encode(i, j + 1));
                uf2.union(encoded_site, encode(i, j + 1));
            }

            if(j > 0 && grid[i][j - 1]){ // Western neighbor
                uf1.union(encoded_site, encode(i, j - 1));
                uf2.union(encoded_site, encode(i, j - 1));
            }
        }
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        // Handle edge cases
        if(i < 0 || i > n - 1 || j < 0 || j > n - 1){
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        return grid[i][j];
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        // Handle edge cases
        if(i < 0 || i > n - 1 || j < 0 || j > n - 1){
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        
        // Return whether the given site is connected to the source and is open
        return (grid[i][j] == true) && uf2.connected(encode(i, j), source);
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        return uf1.connected(source, sink);
    }

    // Returns an integer ID (1...n) for site (i, j).
    private int encode(int i, int j) {
        // Current row * number of sites per row (n) + current column index + 1 (starting at 1 instead of 0)
        return (i * n) + j + 1;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.printf("%d x %d system:\n", n, n);
        StdOut.printf("  Open sites = %d\n", perc.numberOfOpenSites());
        StdOut.printf("  Percolates = %b\n", perc.percolates());
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.printf("  isFull(%d, %d) = %b\n", i, j, perc.isFull(i, j));
        }
    }
}
