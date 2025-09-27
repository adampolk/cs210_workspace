import stdlib.StdOut;

public class RamanujanNumbers {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int a = 1;
        
        /*
         * This program bruteforces all possible combinations of Ramanujan numbers up to n inclusively
         * Ramanujan numbers are numbers that can be written as the sum of two cubes in atleast two different ways
         * The program tries all combinations of four integers (a, b, c, d), where a^3 + b^3 = c^3 + d^3
         * If this condition is met, then we have a Ramanujan number and the values are printed
         * Otherwise, we keep increasing each integer by 1 and checking until any of the cubes exceed n.
         */
        
        while(a*a*a <= n){
            int b = a + 1;
            while(a*a*a + b*b*b <= n){
                int c = a + 1;
                while(c*c*c <= n){
                    int d = c + 1;
                    while(c*c*c + d*d*d <= n){
                        int x = a*a*a + b*b*b;
                        int y = c*c*c + d*d*d;
                        if(x == y){
                            StdOut.println(x + " = " + a + "^3 + " + b + "^3 = " + c + "^3 + " + d + "^3");
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }
    }
}
