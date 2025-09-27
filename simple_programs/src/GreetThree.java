import stdlib.StdOut;

public class GreetThree {
    public static void main(String[] args) {
        // Greet the three input values
        String name1 = args[0];
        String name2 = args[1];
        String name3 = args[2];
        StdOut.println("Hi " + name3 + ", " + name2 + ", and " + name1 + ".");
    }
}
