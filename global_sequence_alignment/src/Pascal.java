import stdlib.StdOut;

public class Pascal {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] a = new int[n + 1][];

        for(int i = 0; i <= n; i++){
            a[i] = new int[n + 1];
            for(int j = 1; j <= i; j++){
                a[i][j] = 1;
            }
        }

        for(int i = 0; i <= n; i++){
            for(int j = 1; j < i; j++){
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }

        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if(j < i){
                    StdOut.printf("%d ", a[i][j]);
                }else{
                    StdOut.printf("%d\n", a[i][j]);
                }
            }
        }
    }
}
