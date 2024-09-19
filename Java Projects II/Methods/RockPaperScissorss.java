import java.util.Random;
import java.util.Scanner;
/**
 *
 * RockPaperScissors: Simulate the game Rock Paper Scissors against a 
 * computer opponent. The computer will pick a random option each time.
 *
 * @author Noah Boyd 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * McFadyen, R. (2015). Java with BlueJ Part I.
 * 
 * @version 0.1 (June 24th 2024)
 * 
 */

public class RockPaperScissorss
{
    public static Random rand = new Random();
    public static Scanner keys = new Scanner(System.in);
    /**
     * Purpose: Executable method for this class
     * Input/Output: Given no arguments, test the functionality of
     *               the functions implemented in this class
     * Examples: main() returns void.
     * Note: To simulate all possible games, use test() instead.
     */
    public static int main(String[] args) {
        // Define Variables
        String humanSelection, comSelection;
        String winner;
        
        // Get Input
        humanSelection = getUserChoice();
        comSelection = getComputerChoice();
        
        // Check for errors
        if(humanSelection.equals("ERROR") || comSelection.equals("ERROR")) {
            System.out.println("Invalid Response Received");
            return 1;
        }
        
        // Compare selections
        winner = findWinner(humanSelection, comSelection);
        
        // Announce winner
        if(winner.equals("Error")) {
            System.out.println("A critical error has occurred.");
            return 1;
        } else if(winner.equals("Tie")) {
            System.out.println("It's a tie!");
        } else {
            System.out.printf("%s wins! \n",winner);
        }
        
        return 0;
    }
    
    /**
     * Purpose: Get the user's choice
     * Input/Output: From keyboard, return player's rock/paper/scissors 
     *               selection
     * Examples: getUserChoice() returns "Rock", "Paper", or "Scissors"
     */
    public static String getUserChoice() {
        String selection; // player's choice
        
        // Get player input
        System.out.print("Rock, paper, scissors! :");
        selection = keys.nextLine();
        System.out.println();
        
        // Check and rectify input
        if(selection.equals("rock") ||  selection.equals("Rock") ||
           selection.equals("r") || selection.equals("R")){
               return "Rock";
        } else if(selection.equals("paper") || selection.equals("Paper") ||
           selection.equals("p") || selection.equals("P")) {
               return "Paper";
        } else if(selection.equals("scissors") || selection.equals("Scissors") ||
           selection.equals("s") || selection.equals("S")) {
               return "Scissors";
        } else {
            System.out.println("Error: Invalid Input");
            return "ERROR";
        }
    }
    
    /**
     * Purpose: Get the computer's choice
     * Input/Output: From random number generation, find the computer's
     *               rock/paper/scissors selection
     * Examples: getComputerChoice() returns "Rock", "Paper", or "Scissors"
     */
    public static String getComputerChoice() {
        int r = rand.nextInt(0,3);
        
        switch(r) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "ERROR";
        }
    }
    
    /**
     * Purpose: Check the winner from the Rock Paper Scissors
     * Input/Output: From the two selections, prints the winner
     * Examples: findWnner("Rock", "Scissors") print "You win!"
     */
    public static String findWinner(String humanSelection, String comSelection) {
        
        // Human chooses "Rock"
        if(humanSelection.equals("Rock")) {
            if(comSelection.equals("Rock")) {
                return "Tie";
            } else if(comSelection.equals("Paper")) {
                return "Computer";
            } else {
                return "You";
            }
        }
        
        // Human chooses "Paper"
        if(humanSelection.equals("Paper")) {
            if(comSelection.equals("Paper")) {
                return "Tie";
            } else if(comSelection.equals("Scissors")) {
                return "Computer";
            } else {
                return "You";
            }
        }
        
        //Human chooses "Scissors"
        if(humanSelection.equals("Scissors")) {
            if(comSelection.equals("Scissors")) {
                return "Tie";
            } else if(comSelection.equals("Rock")) {
                return "Computer";
            } else {
                return "You";
            }
        }
        
        return "Error!";
    }
    
    /**
    * Purpose: test the functionality of the findWinner function
    * Input/Output: Simulate the 9 possible Rock Paper Scissors games and
    *               display the winners
    * Examples: test() displays the results to the console
    */
   
    public static void test() {
        String[] hmnSelections = {"Rock", "Paper", "Scissors"};
        String[] comSelections = {"Rock", "Paper", "Scissors"};
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                // Simulate the match
                System.out.printf("%s vs. %s: %s", 
                                   hmnSelections[i], comSelections[j],
                                   findWinner(hmnSelections[i], comSelections[j]));
                System.out.println();
            }
        }
    }
}
