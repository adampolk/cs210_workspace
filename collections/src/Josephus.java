import dsa.LinkedQueue;
import stdlib.StdOut;

public class Josephus {
    // Entry point.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        for(int i = 1; i <= n; i++){
            queue.enqueue(i);
        }

        int i = 0;
        while(!queue.isEmpty()){
            i++;
            int pos = queue.dequeue();
            // If we are at the mth person, keep them removed and print the number
            if(m == i){
                StdOut.println(pos);
                i = 0;
            }else{
                queue.enqueue(pos);
            }
        }
    }
}
