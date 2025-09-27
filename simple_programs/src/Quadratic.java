import stdlib.StdOut;

public class Quadratic {
    // Entry point.
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double discriminant = b*b - (4 * a * c);

        // Make sure a is not 0 and the discriminant is not negative before solving for zeros
        if(a == 0){
            StdOut.println("Value of a must not be 0");
        }else if(discriminant < 0){
            StdOut.println("Value of discriminant must not be negative.");
        }else{
            double first_zero = (-b + Math.sqrt(discriminant)) / (2 * a);
            double second_zero = (-b - Math.sqrt(discriminant)) / (2 * a);
            StdOut.println(first_zero + " " + second_zero);
        }
    }
}
