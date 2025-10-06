import stdlib.StdIn;
import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        // Read the two sequences
        String x = StdIn.readString();
        String y = StdIn.readString();

        // Store their lengths
        int m = GSA.length(x);
        int n = GSA.length(y); 

        // Create the matrix
        int[][] opt = new int[m + 1][n + 1];

        // Fill in the last column of the table
        // This means we're matching the remaining part of x with nothing
        // Each remaining letter costs 2 points (gap penalty)
        for (int i = 0; i <= m; i++) {
            opt[i][n] = 2 * (m - i);
        }

        // Fill in the last row of the table
        // This is doing the same but with y
        for (int j = 0; j <= n; j++) {
            opt[m][j] = 2 * (n - j);
        }

        // Fill the matrix from bottom right to top left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (GSA.charAt(x, i) == GSA.charAt(y, j)) {
                    // If characters match, no cost to align them
                    // Take the min of:
                    //   1. opt[i+1][j+1] (align both chars)
                    //   2. opt[i+1][j] + 2 (insert gap in y)
                    //   3. opt[i][j+1] + 2 (insert gap in x)
                    opt[i][j] = GSA.min(
                        opt[i + 1][j + 1],
                        opt[i + 1][j] + 2,
                        opt[i][j + 1] + 2
                    );
                } else {
                    // If characters are different, substitution costs +1
                    // Plus the gap insertion costs as above
                    opt[i][j] = GSA.min(
                        opt[i + 1][j + 1] + 1, 
                        opt[i + 1][j] + 2,   
                        opt[i][j + 1] + 2     
                    );
                }
            }
        }

        // Print strings and matrix dimensions
        StdOut.printf("%s\n%s\n%d %d\n", x, y, opt.length, opt[0].length);

        // Print the entire matrix
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    StdOut.printf("%3d ", opt[i][j]); // keep row aligned
                } else {
                    StdOut.printf("%3d\n", opt[i][j]); // newline at end of row
                }
            }
        }
    }
}
