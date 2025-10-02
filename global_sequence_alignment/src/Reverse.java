import stdlib.StdIn;
import stdlib.StdOut;

public class Reverse {
    // Entry point.
    public static void main(String[] args) {
        // This program prints the input (a sequence of strings) in reverse order
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // Reverse the order of the strings in array "a"
        for(int i = 0; i<n/2; i++){
            String temp = a[i];
            a[i] = a[n - i - 1];
            a[n-i-1] = temp;
        }

        // Print the final array after the values are swapped
        for(int i = 0; i < n; i++){
            if(i < n - 1){
                StdOut.print(a[i] + " ");
            }else{
                StdOut.println(a[i]);
            }
        }

    }
}
