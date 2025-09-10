import stdlib.StdOut;

public class Triangle {
    // Entry Point.
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        if(x <= (y + z) && y <= (x + z) && z <= (x + y)){
            StdOut.println(true);
        }else{
            StdOut.println(false);
        }
    }
}
