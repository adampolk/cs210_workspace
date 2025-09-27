import stdlib.StdOut;

public class GreatCircle {
    // Entry Point.
    public static void main(String[] args) {
        // Convert each double to radians due to Math methods using radians instead of degrees
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        // Plug in the values into the great circle distance formula
        double d = 6359.83 * (Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1-y2)));
        StdOut.println(d);
    }
}
