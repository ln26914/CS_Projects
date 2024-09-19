import java.util.Scanner; //Allow Input
/**
 * Bill Calculator: Modify an initial bill by a tip percent to produce
 * the final bill after tip.
 * 
 * Input: Initial Bill, Tip Percent
 * Output: Total Bill
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (6/11/2024)
 */


public class BillCalculator
{
    public static void main(String[] args)
    {   
        //Set up the scanner object
        Scanner keyboard = new Scanner (System.in);
        
        //Define Variables
        double initialAmount = 0.0; // $0 bill by default 
        double tipPercent = 20.0; // 20% tip by default
        double tipAmount = 0.0; // $0 tip by default
        double finalAmount = 0.0; // $0 final bill by default
        
        // Ask user for initial bill
        System.out.print("Enter the bill amount ($): ");
        initialAmount = keyboard.nextDouble();
        System.out.println(); // Blank Line
        
        // Ask user for tip percent
        System.out.print("Enter the tip (%): ");
        tipPercent = keyboard.nextDouble();
        System.out.println(); // Blank Line
        
        // Calculate the tip amount
        tipAmount = (tipPercent/100) * initialAmount;
        
        // Calculate the final bill
        finalAmount = initialAmount + tipAmount;
        
        // Print out final bill
        System.out.println("The total bill is ($): " + finalAmount);
        
    }
}
