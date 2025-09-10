import stdlib.StdOut;

public class Quadratic {
    // Entry point.
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double discriminant = Math.sqrt((Math.pow(b, 2) - (4 * a * c)));

        if(a == 0){
            StdOut.println("Value of a must not be 0");
        }else if(discriminant < 0){
            StdOut.println("Value of discriminant must not be negative.");
        }else{
            double first_zero = (-b + discriminant) / (2 * a);
            double second_zero = (-b - discriminant) / (2 * a);
            StdOut.println(first_zero + " " + second_zero);
        }
    }
}
