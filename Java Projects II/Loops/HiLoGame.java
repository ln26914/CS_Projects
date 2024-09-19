import java.util.Scanner;
import java.util.Random;
/**
 * HiLoGame: Guess a number between 0-99. Take as many tries as you need.
 * 
 * Input: Number Guess
 * Output: Guess count, (too high / too low / correct)
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * @version 0.1 (June 17th 2024)
 */
public class HiLoGame
{
    public static int main(String[] args) {
        
        //Define Variables
        Scanner keys = new Scanner(System.in);
        Random rand = new Random();
        
        int guess = 0; // Guess made by the player
        int guessCount = 0; // Number of guesses
        int comGuess = rand.nextInt(0,100); // Random number from 0-99
        
        // Game loop
        do {
            // Increment Guess Counter
            guessCount += 1; // Guess entered:
            
            // Input: enter guess
            System.out.print("Enter a number (0-99): ");
            guess = keys.nextInt();
            System.out.println();
            
            // Process guess
            
            
            if(guess > comGuess) {
                System.out.println("Too high!");
            } else if(guess < comGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct!");
            }
        } while(guess != comGuess);
        
        // Output: Results
        System.out.printf("Congrats! You guessed correctly after %d tries!",
                           guessCount);
        
        return 0; // Program runs successfully
        
    }
}
