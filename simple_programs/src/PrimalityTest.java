import stdlib.StdOut;

public class PrimalityTest {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int i = 2; // Discussion says to set i = 1, but everything is divisible by 1, so it would always break out.
        
        /* This loop will check until it reaches the square root of n
         * Ex: n = 13, i = 2
         *     2 <= 13 / 2 --> 2 <= 6
         *     3 <= 13 / 3 --> 3 <= 4
         *     4 <= 13 / 4 --> 4 <= 3 (stop here)
         *     The floored value of the square root of 13 is 3, and this loop checks until i = 3.
         *     A factor larger than the square root would be unneccessary to check because there would always be a smaller factor.
         */ 
        while(i <= n/i){
            if(n % i == 0){
                break;
            }
            i++;
        }

        /* If we reached the end of the loop without breaking, then i will be greater than n / i, meaning n is prime (true).
         * Otherwise, the factor we got (i) will be smaller, so n is not prime (false)
        */ 

        if(i > n/i){
            StdOut.println(true);
        }else{
            StdOut.println(false);
        }

    }
}
