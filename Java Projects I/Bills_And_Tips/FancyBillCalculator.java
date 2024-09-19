import java.util.Scanner; //Allow Input
import javax.swing.JOptionPane; //Fancy Output
/**
 * Fancy Bill Calculator: Modify an initial bill by a tip percent to produce
 * the final bill after tip. Use a Java Option Pane for the UI instead of
 * the terminal.
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


public class FancyBillCalculator
{
    public static void main(String[] args)
    {   
        
        //Define Variables
        double initialAmount = 0.0; // $0 bill by default 
        double tipPercent = 20.0; // 20% tip by default
        double tipAmount = 0.0; // $0 tip by default
        double finalAmount = 0.0; // $0 final bill by default
        String PaneBuffer; // Input String from JOptionPane Input Dialog
        
        // Ask user for initial bill and parse as a double
        PaneBuffer = JOptionPane.showInputDialog("Enter the bill amount ($): ");
        initialAmount = Double.parseDouble(PaneBuffer);
        
        // Ask user for tip percent and parse as a double
        PaneBuffer = JOptionPane.showInputDialog("Enter the tip percent (%): ");
        tipPercent = Double.parseDouble(PaneBuffer);
        
        // Calculate the tip amount
        tipAmount = (tipPercent/100) * initialAmount;
        
        // Calculate the final bill
        finalAmount = initialAmount + tipAmount;
        
        // Print out final bill
        JOptionPane.showMessageDialog(null,
                    ("The final bill after tip is ($) " + finalAmount));
        
    }
}
