import stdlib.StdOut;

public class Pascal {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] a = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            a[i] = new int[i + 1]; // row i has i+1 elements
            a[i][0] = 1;           // first element is always 1
            a[i][i] = 1;           // last element is always 1
        }

        // Find elements past 1
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }

        // Print the triangle
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    StdOut.printf("%d ", a[i][j]);
                } else {
                    StdOut.printf("%d\n", a[i][j]);
                }
            }
        }
    }
}
