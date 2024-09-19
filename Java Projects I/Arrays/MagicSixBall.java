import java.util.Random;
/**
 * MagicSixBall: Randomly print out one of six answer strings randomly.
 * Default answer is "Try Again".
 * 
 * Inputs: ---
 * Outputs: Message
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (June 27th, 2024)
 */
public class MagicSixBall
{
    public static void main(String[] args) {
        // Set up random number generation
        Random rand = new Random();
        int randomNumber = rand.nextInt(6); // 6 possible outcomes
        
        //Define the messages
        String messages[] = {"Certainly", "Undoubtedly", "Unsure", 
            "Decidedly Not", "Never Say Never", "Try Again"};
            
        System.out.println(messages[randomNumber]); // Implemented my fix      
        
        
    }
}
