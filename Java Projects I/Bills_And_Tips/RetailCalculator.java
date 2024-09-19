import java.util.Scanner; //Allow Input
/**
 * Retail Calculator: Input the initial price and markup percent, and receive
 * the final price after 2% state tax and 8% city tax.
 * 
 * Input: Initial Price, Markup Percent
 * Output: Total Price After Taxes
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (6/11/2024)
 */


public class RetailCalculator
{
    public static void main(String[] args)
    {   
        //Set up the scanner object
        Scanner keyboard = new Scanner (System.in);
        
        //Define Variables
        double initialPrice = 0.0; // $0 bill by default 
        double markupPercent = 100.0; // 100% markup by default
        double stateTaxPercent = 2.0; // 2.0% State Tax
        double cityTaxPercent = 8.0; // 8.0% City Tax
        double finalPrice = 0.0; // $0 final bill by default
        
        // Ask user for initial price
        System.out.print("Enter the initial price ($): ");
        initialPrice = keyboard.nextDouble();
        System.out.println(); // Blank Line
        
        // Ask user for markup percent
        System.out.print("Enter the markup amount (%): ");
        markupPercent = keyboard.nextDouble();
        System.out.println(); // Blank Line
        
        // Calculate the price after markup
        finalPrice = initialPrice * (1 + (markupPercent / 100));
        
        // Calculate the price after the city and state tax
        finalPrice = finalPrice * (1 + (
                    (cityTaxPercent + stateTaxPercent) / 100)); // Total Tax
        
        // Print out final price
        System.out.println("The final price after markup and taxes is ($): " 
                            + finalPrice);
        
    }
}
