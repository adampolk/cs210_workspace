import stdlib.StdOut;

public class Harmonic {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        for(int i = 1; i <= n; i++){
            Rational term = new Rational(1, i);
            total = total.add(term);
        }
        StdOut.println(total);
    }
}
