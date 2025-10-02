import stdlib.StdIn;
import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        String x = StdIn.readString();
        String y = StdIn.readString();

        int m = GSA.length(x);
        int n = GSA.length(y);

        int[][] opt = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            opt[i][n] = 2 * (m - i);
        }

        for(int i = 0; i <= n; i++){
            opt[m][i] = 2 * (n - i);
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(GSA.charAt(x, i) == GSA.charAt(y, j)){
                    opt[i][j] = GSA.min(opt[i + 1][j + 1], opt[i + 1][j] + 2, opt[i][j + 1] + 2);
                }else{
                    opt[i][j] = GSA.min(opt[i + 1][j + 1] + 1, opt[i + 1][j] + 2, opt[i][j + 1] + 2);
                }
            }
        }

        StdOut.printf("%s\n%s\n%d %d\n", x, y, m, n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j < n - 1){
                    StdOut.printf("%3d", opt[i][j]);
                }else{
                    StdOut.printf("%3d\n", opt[i][j]);
                }
            }
        }
    }
}
