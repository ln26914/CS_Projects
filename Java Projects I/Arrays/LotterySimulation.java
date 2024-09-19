import java.util.Random;
import java.util.Scanner;
/**
 * LotterySimulation: Simulate a random drawing of 5 numbers from 1-10. 
 * If you guess all five unique numbers in any order, you win.
 * 
 * Inputs: your lottery numbers int[5]
 * Outputs: winning lottery numbers, whether you won
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (June 29th, 2024)
 */
public class LotterySimulation
{
    /**
     * Purpose: Simulate a simplified lottery.
     * Given 5 numbers from the user, print whether those 5 numbers win.
     * User's input and lottery numbers can be in different orders
     * returns an integer. 0 for success, 1 for failure.
     * main() returns 0 or 1 depending on if you win
     */
    public static int main(String[] args) {
        // Define Variables and pick random numbers
        int[] ticketNumbers = {0,0,0,0,0};
        int[] targetNumbers = pickWinningNumbers();
        Scanner keys = new Scanner(System.in);
        
        // Input: Input your numbers:
        for(int i = 0; i < 5; i++) {
            System.out.printf("Enter the #%d number on your ticket: ", i+1);
            ticketNumbers[i] = keys.nextInt();
            System.out.println();
        }
        
        // Check winner
        if(isWinner(ticketNumbers, targetNumbers)) {
            
            // Display victory message with context
            System.out.println("Your Numbers: " + stringify(ticketNumbers));
            System.out.println("Target Numbers: " + stringify(targetNumbers));
            System.out.println("You Win! Congratulations!");
            
            //Success!
            return 0;
            
        } else {
             // Display defeat message with context
            System.out.println("Your Numbers: " + stringify(ticketNumbers));
            System.out.println("Target Numbers: " + stringify(targetNumbers));
            System.out.println("You Lose! Better luck next time...");
            
            //Failure!
            return 1;
        }
    }
    
    /**
     * Purpose: Check if the key value is contained in the array.
     * Given an array and a key value, return true if the key is anywhere in
     * the array.
     * contains({2,4,6},2) returns true.
     */
    public static boolean contains(int[] array, int key) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == key) return true;
        }
        return false;
    }
    
    /**
     * Purpose: Return a spread of 5 unique numbers
     * Given no arguments, return an array of 5 unique integers from 1-9.
     * pickWinningNumbers could return {1,4,5,6,9}
     */
    
    public static int[] pickWinningNumbers() {
        //Define variables
        Random rand = new Random();
        int[] winningNumbers = {0,0,0,0,0};
        int random = 0, index = 0;
        boolean endOfArray = false;
        
        // Determine the winning numbers
        while(!endOfArray) {
            
            // Generate a random number from 1 to 9.
            random = rand.nextInt(1,9);
            
            // Add the random number to the array if it's new
            if(!contains(winningNumbers, random)) {
                winningNumbers[index] = random;
                index++;
            }
            
            // Check if the array's end has been reached
            if(index >= winningNumbers.length - 1) endOfArray = true;
        }
        
        return winningNumbers; // Return the winning numbers
    }
    
    /**
     * Purpose: Determine whether you win
     * Given two arrays, return whether their contents match regardless
     * of the order
     * isWinner({0,2,4,6},{6,0,2,4}) returns true.
     * isWinner({1,4,2,6},{6,0,2,4}) returns false.
     */
    public static boolean isWinner(int[] guess, int[] answer) {
        
        //Arrays can't be equal if they're different sizes.
        if(guess.length != answer.length) return false;
        
        // Check if each element of the answer resides in the guess array
        for(int i = 0; i < answer.length; i++) {
            if(!contains(guess, answer[i])) return false;
        }
        
        // If both tests pass, the arrays must have the same elements.
        return true;
    }
    
    /**
     * Purpose: Print an array prettily
     * Given an array, return a string of the contents
     * stringify({2,4,8,16}) returns "2, 4, 8, 16"
     * Empty array returns an empty string
     */
    public static String stringify(int[] array) {
        // Check if array is empty
        if(array.equals(null)) return ""; //empty string
        
        // Define Variables, and add the first element to the string.
        String outputString = "" + array[0];
        
        // Convert the integer elements of the array to a readable string
        // format
        for(int i = 1; i < array.length; i++) {
            outputString += ",";
            outputString += "" + array[i];
        }
        
        return outputString;
    }
    
    
}
