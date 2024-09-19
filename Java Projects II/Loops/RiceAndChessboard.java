import java.util.Scanner;
/**
 * RiceAndChessboard: You are offered a job for 7 weeks. You have the choice
 * to be paid $100 the first day, $200 the second, $300 the third day, etc. for
 * the rest of the time. Or, you can be paid 1¢ for the first day, 2¢ the 
 * second day, 4¢ the third day, doubling each day. 
 * Use an accumulation variable.
 * 
 * Input: Income Plan, Number of Days
 * Output: Total Income
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * @version 0.1 (June 14th 2024)
 */
public class RiceAndChessboard
{
    public static int main(String[] args) {
        // Define Variables
        double accumulation = 0.00; // total accumulation
        
        int option = 0; // Input: Which income type
        int numDays = 0; // Input: Length of time to simulate income
        
        Scanner keyboard = new Scanner(System.in); // Get keyboard input
        
        // Input: Enter the income plan
        System.out.print("Select the income plan: \n 1: linear \n 2: exponential \n:");
        option = keyboard.nextInt();
        System.out.println();
        
        //Input: Enter the number of days
        System.out.print("How long do you want to simulate the income plan? ");
        numDays = keyboard.nextInt();
        System.out.println();
        
        //Calculation:
        switch(option) {
            case 1:
                // Use the linear scaling
                accumulation = 100;
                for(int i = 0; i <= numDays; i++) {
                    accumulation += (100 * i);
                }
                break;
            case 2:
                // Use the exponential scaling
                accumulation = 0.01;
                for(int i = 0; i<= numDays; i++) {
                    accumulation += accumulation;
                }
                break;
            default:
                System.out.println("Invalid option. Exiting program...");
                return 1;
        }
        
        // Output income
        System.out.println("Income: "+ accumulation);
        return 0;
        
    }
}
