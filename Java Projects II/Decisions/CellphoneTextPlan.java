import java.util.Scanner;
/**
 * CellphoneTextPlan: Simulate a cellphone plan. The $8 plan provides 100 free
 * texts each month, and every subsequent text is 2¢.
 * 
 * Input: Number of texts
 * Output: The total cost
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (June 13th, 2024)
 */
public class CellphoneTextPlan
{
    public static void main(String[] args) {
        // Define Variables
        double baseCost = 8.00; // Monthly cost
        double extraTextCost = 0.02; // Extra Text cost
        double finalCost = 0; // Final cost after calculation
        int textCount = 0; // Input: Number of texts (0 by default)
        Scanner keyboard = new Scanner(System.in); // Input Scanner
        
        // Get Input (Number of texts)
        System.out.print("Enter the number of texts you sent this month: ");
        textCount = keyboard.nextInt();
        System.out.println();
        
        // Calculate Total Cost
        if(textCount < 100) finalCost = baseCost; // No extra charge
        else finalCost = baseCost + (extraTextCost * (textCount - 100)); // Extra charge
        
        // Print out total cost
        System.out.println("Total due this month: " + finalCost);
    }
}
