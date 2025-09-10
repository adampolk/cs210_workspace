import stdlib.StdOut;

public class ThreeSort {
    // Entry Point.
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        int smallest = Math.min(Math.min(x, y), z);
        int largest = Math.max(Math.max(x, y), z);
        int middle = (x + y + z) - smallest - largest;
        StdOut.println(smallest + " " + middle + " " + largest);
    }
}
