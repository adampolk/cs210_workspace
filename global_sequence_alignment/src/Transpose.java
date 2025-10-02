import stdlib.StdIn;
import stdlib.StdOut;

public class Transpose {
    // Entry point.
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]); // Number of rows
        int n = Integer.parseInt(args[1]); // Number of columns
        double[][] a = new double[m][n];   // Original array
        double[][] c = new double[n][m];   // Transposed array of array a

        // Populate the array a with values in row-col order
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = StdIn.readDouble();
            }
        }

        // Populate array c with the transpose of array a (col-major order)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                c[i][j] = a[j][i];
            }
        }

        // Print values in array c in col major order
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                StdOut.print(c[i][j] + " ");
            }
            StdOut.println();
        }
    }
}
