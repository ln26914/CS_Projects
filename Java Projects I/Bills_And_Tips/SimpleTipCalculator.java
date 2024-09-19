import java.util.Scanner; //Allow Input
/**
 * SimpleTipCalculator: Find the tip amount for a bill 
 * when the tip percent is 20%
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (6/11/2024)
 */


public class SimpleTipCalculator
{
    public static void main(String[] args)
    {   
        //Set up the scanner object
        Scanner keyboard = new Scanner (System.in);
        
        //Define Variables
        double initialAmount = 0.0; // $0 bill by default 
        double tipPercent = 20.0; // 20% tip by default
        double tipAmount = 0.0; // $0 tip by default
        
        // Ask user for input
        System.out.print("Enter amount ($): ");
        initialAmount = keyboard.nextDouble();
        System.out.println(); // Blank Line
        
        // Calculate the tip amount
        tipAmount = (tipPercent/100) * initialAmount;
        
        // Print out tip amount
        System.out.println("The tip is ($): " + tipAmount);
    }
}
