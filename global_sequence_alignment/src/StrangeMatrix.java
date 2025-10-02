import stdlib.StdOut;

public class StrangeMatrix {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]); // Rows
        int n = Integer.parseInt(args[1]); // Columns
        int[][] a = new int[m][n];

        for(int i = 0; i < m; i++){
            a[i][n - 1] = m - i - 1;
        }

        for(int i = 0; i < n; i++){
            a[m - 1][i] = n - i - 1;
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                a[i][j] = a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j < n - 1){
                    StdOut.printf("%5d", a[i][j]);
                }else{
                    StdOut.printf("%5d\n", a[i][j]);
                }
            }
        }
    }
}
