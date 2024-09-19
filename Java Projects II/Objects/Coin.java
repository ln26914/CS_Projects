import java.util.Random;
/**
 * Simulate the functionality of a coin, with a heads and tails side.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * @author Noah Boyd (5550203507)
 * @version 0.1 July 5th 2024
 */
public class Coin {
    /**
     * Test the coin class
     */
    public static void main(String[] args) {
        //Define Variables
        Coin penny = new Coin();
        int headCount = 0, tailCount = 0;
        
        // Simulate
        for(int i = 0; i < 100; i++) {
            penny.flip();
            System.out.printf("Side: %s \n",penny.getSide());
            if(penny.getSide().equals("Heads")) headCount ++;
            else tailCount++;
        }
        
        System.out.printf("Heads: %d\nTails: %d\n", headCount, tailCount);
    }
    // instance variables
    private boolean headsUp;

    /**
     * Constructor for objects of class Coins
     */
    public Coin() {
        headsUp = true;
        this.flip();
    }

    /**
     * Flip the coin, randomly assigning the value "true" or "false" to
     * the headsUp value.
     */
    public void flip() {
        // Define Variables
        Random rand = new Random();
        int flip = rand.nextInt(0,100);
        
        if(flip%2 == 0) headsUp = false;
        else headsUp = true;
        
    }
    
    public String getSide() {
        if(headsUp) return "Heads";
        else return "Tails";
    }
}
