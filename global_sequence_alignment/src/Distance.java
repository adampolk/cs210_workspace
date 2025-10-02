import stdlib.StdIn;
import stdlib.StdOut;

public class Distance {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = new double[n];
        double[] y = new double[n];
        double sum = 0.0;

        // Populate arrays x and y each with n values provided as input
        for(int i = 0; i < (n * 2); i++){
            if(i < n){
                x[i] = StdIn.readDouble();
            }else{
               y[i - n] = StdIn.readDouble();
            }
        }

        // Add the squared differences between each entry to sum
        for(int i = 0; i < n; i++){
            sum += Math.pow((x[i] - y[i]), 2);
        }

        // Print the square root of sum (Euclidean distance)
        StdOut.println(Math.sqrt(sum));
    }
}
