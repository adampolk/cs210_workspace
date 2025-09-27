import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    // Entry point.
    public static void main(String[] args) {
        int value = StdRandom.uniform(1, 7); // 7 because the second argument is not inclusive (gives 1-6)
        String output;

        // Set the correct dice art depending on random roll value
        if(value == 1){
            output = "     \n  *  \n     ";
        }else if(value == 2){
            output = "*    \n     \n    *";
        }else if(value == 3){
            output = "*    \n  *  \n    *";
        }else if(value == 4){
            output = "*   *\n     \n*   *";
        }else if(value == 5){
            output = "*   *\n  *  \n*   *";
        }else{
            output = "* * *\n     \n* * *";
        }

        StdOut.println(output);
    }
}
