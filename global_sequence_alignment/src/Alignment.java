import stdlib.StdArrayIO;
import stdlib.StdIn;
import stdlib.StdOut;

public class Alignment {
    // Entry point.
    public static void main(String[] args) {
        // Read the two sequences
        String x = StdIn.readString();
        String y = StdIn.readString();

        // Save the length of each
        int m = GSA.length(x);
        int n = GSA.length(y);

        // Read opt array from the output of EditDistance
        int[][] opt = StdArrayIO.readInt2D();

        // This is the optimal alignment cost
        StdOut.println(opt[0][0]);

        int i = 0;
        int j = 0;

        // Go through the matrix from top left to bottom right
        // Decide each step in the alignment process
        while(i < m && j < n){
            if(opt[i][j] == opt[i + 1][j] + 2){
                // Put a gap instead of y
                StdOut.println(GSA.charAt(x, i) + " - 2");
                i++;
            }else if(opt[i][j] == opt[i][j + 1] + 2){
                // Put a gap instead of x 
                StdOut.println("- " + GSA.charAt(y, j) + " 2");
                j++;
            }else{
                // Best choice is to align x[i] and y[j]
                if(GSA.charAt(x, i) == GSA.charAt(y, j)){
                    // Characters match, cost is zero
                    StdOut.println(GSA.charAt(x, i) + " " + GSA.charAt(y, j) + " 0");
                }else{
                    // Characters don't match, cost is 1.
                    StdOut.println(GSA.charAt(x, i) + " " + GSA.charAt(y, j) + " 1");
                }
                i++;
                j++;
            }
        }

        // If anything is left over in x (y exhausted before), gaps are added
        while (i < m) {
            StdOut.println(GSA.charAt(x, i) + " - 2");
            i++;
        }

        // If anything is left over in y (x exhausted before), gaps are added
        while (j < n) {
            StdOut.println("- " + GSA.charAt(y, j) + " 2");
            j++;
        }
    }
}
