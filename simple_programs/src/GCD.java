import stdlib.StdOut;

public class GCD {
    // Entry point.
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int greatest = 1;
        for(int i = 2; i <= (Math.min(p,q)); i++){
            if(p % i == 0 && q % i == 0){
                greatest = i;
            }
        }

        StdOut.println(greatest);
    }
}
