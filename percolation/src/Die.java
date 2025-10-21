import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    private int value; // the face value

    // Constructs a die.
    public Die() {
        this.value = -1;
    }
    
    // Rolls this die.
    public void roll() {
        this.value = StdRandom.uniform(1, 7); // 7 because the second argument is not inclusive (gives 1-6)
    }

    // Returns the face value of this die.
    public int value() {
        return this.value;
    }

    // Returns true if this die is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        return this.value == ((Die) other).value;

    }

    // Returns a string representation of this die.
    public String toString() {
        // If the dice hasn't been rolled yet then return an error
        if(this.value == -1){
            return "Error";
        }

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

        return output;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        StdOut.println(die);
    }
}
