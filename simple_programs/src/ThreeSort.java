import stdlib.StdOut;

public class ThreeSort {
    // Entry Point.
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        // Find the smallest, middle, and greatest of the 3 values
        int first = Math.min(Math.min(x, y), z);
        int last = Math.max(Math.max(x, y), z);
        int middle = (x + y + z) - first - last;
        StdOut.println(first + " " + middle + " " + last);
    }
}
