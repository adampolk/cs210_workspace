import stdlib.StdOut;

public class Factorial {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);
        int factorial_value = n;
        for(int i = n - 1; i > 0; i--){
            factorial_value *= i;
        }
        StdOut.println(factorial_value);
    }
}
