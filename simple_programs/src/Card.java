import javax.print.attribute.standard.QueuedJobCount;

import stdlib.StdOut;
import stdlib.StdRandom;

public class Card {
    // Entry point.
    public static void main(String[] args) {
        int rank = StdRandom.uniform(2, 15);
        int suit = StdRandom.uniform(1, 5);

        String rankStr;
        String suitStr;

        // Convert random rank integer to correct rank string
        if(rank > 10){
            if(rank == 11){
                rankStr = "Jack";
            }else if(rank == 12){
                rankStr = "Queen";
            }else if(rank == 13){
                rankStr = "King";
            }else{
                rankStr = "Ace";
            }
        }else{
            rankStr = Integer.toString(rank);
        }

        // Convert random suit integer to correct suit string
        if(suit == 1){
            suitStr = "Clubs";
        }else if(suit == 2){
            suitStr = "Diamonds";
        }else if(suit == 3){
            suitStr = "Hearts";
        }else{
            suitStr = "Spades";
        }

        StdOut.println(rankStr + " of " + suitStr);
        


    }
}
