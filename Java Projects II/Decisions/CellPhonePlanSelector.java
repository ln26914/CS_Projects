import java.util.Scanner;
/**
 * CellPhonePlanSelector: Select one of three pre-determined plans and input
 * how many talk minutes you used and output the total cost.
 * The name "CellPhonePlans" is bad form since it's a plural noun as opposed
 * to a singular noun, which is why I named this class "CellPhonePlanSelector".
 * 
 * Input: Letter (A, B, or C), Talk Minutes
 * Output: Total cost
 *
 * @author Noah Boyd, 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (June 13th, 2024)
 */
public class CellPhonePlanSelector
{
    public static int main(String[] args) {
        // Define Variables
        double monthlyFlatCosts[] = {0.00, 10.00, 20.00}; // A, B, C respectively
        double minuteCosts[] = {0.09, 0.05, 0.00}; // A, B, C respectively
        double flatCost = 0.00; // Selected flat cost
        double minuteCost = 0.00; // Selected minute cost
        
        char selectedPlan = 'A'; // Input: Plan selected
        int talkMinutes = 0; // Input: Talk minutes
        
        double totalCost = 0.00; // Output: Total Cost
        
        String inputBuffer; // String input
        Scanner keyboard = new Scanner(System.in); // Allow keyboard input
        
        // Input: User selects a plan
        System.out.printf(("Plan A: $%.2f per month and $%.2f per minute \n" +
                          "Plan B: $%.2f per month and $%.2f per minute \n" +
                          "Plan C: $%.2f per month and $%.2f per minute \n\n" +
                          "Enter your Cell Phone Plan: "), 
                           monthlyFlatCosts[0], minuteCosts[0],
                           monthlyFlatCosts[1], minuteCosts[1],
                           monthlyFlatCosts[2], minuteCosts[2]);
        inputBuffer = keyboard.nextLine();
        selectedPlan = inputBuffer.charAt(0);
        
        System.out.println();
        
        // Input: User enters their talk time
        System.out.print("Enter your talk time (min): ");
        talkMinutes = keyboard.nextInt();
        System.out.println();
        
        // Calculate Final Cost
        switch(selectedPlan) {
            case 'A':
            case 'a':
                flatCost = monthlyFlatCosts[0];
                minuteCost = minuteCosts[0];
                break;
            case 'B':
            case 'b':
                flatCost = monthlyFlatCosts[1];
                minuteCost = minuteCosts[1];
                break;
            case 'C':
            case 'c':
                flatCost = monthlyFlatCosts[2];
                minuteCost = minuteCosts[2];
                break;
            default:
                System.out.println("Unrecognized plan. Exiting program...");
                return 1; // Execution failed
        }
        
        totalCost = flatCost + (minuteCost * talkMinutes);
        
        // Output: 
        System.out.printf("Total cost this month: $%.2f \n", totalCost);
        return 0; // Executed successfully
    }
}
