
/**
 * MoneyCalculators: A few functions for working with money.
 * calculateTipAmount: Given the bill and tip rate, find the tip amount
 * calculateFinalBill: Given the bill and the tip rate, find the final bill
 * calculateMarkup: Given the initial price and markup rate, find the final
 *                  cost after tax.
 *
 *
 * @author Noah Boyd: 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * McFadyen, R. (2015). Java with BlueJ Part I.
 * 
 * @version 0.1 (June 21, 2024)
 */
public class MoneyCalculators
{
    // Main Function for testing
    public static void main(String[] args) {
        //Function Testing
        
        // Test calculateTipAmount
        System.out.println("Testing function calculateTipAmount");
        System.out.println("Bill = 50, tip = 10.00% (should be 5): " 
                        + calculateTipAmount(50.00, 10.00));
        //calculateFinalBill(100.00,32.0)
        System.out.println("Bill = 100, tip = 32.00% (should be 32): " 
                        + calculateTipAmount(100.00, 32.00));
        
        // Test calculateFinalBill
        System.out.println("Testing function calculateFinalBill");
        //calculateFinalBill(50.0,10.0)
        System.out.println("Bill = 50, tip = 10.00% (should be 55): " 
                        + calculateFinalBill(50.00, 10.00));
        //calculateFinalBill(100.00,32.0)
        System.out.println("Bill = 100, tip = 32.00% (should be 132): " 
                        + calculateFinalBill(100.00, 32.00));
                        
        // Test calculateMarkup
        System.out.println("Testing function calculateMarkup");
        System.out.println("Initial Price = 25, Markup = 100% (Should be 55): "
                            + calculateMarkup(25,100));
        System.out.println("Initial Price = 64, Markup = 250% (Should be 246.40): "
                            + calculateMarkup(64,250));
    }

    /**
     * Purpose: Calculate the tip amount for a bill
     * Input/Output: Given bill and tipPercent, return tipAmount
     * Examples:
     * calculateTipAmount(50.00,10.00) returns 5.00
     */
    public static double calculateTipAmount(double bill, double tipPercent) {
        double tipAmount = (bill * (tipPercent / 100));
        return tipAmount;
    }
    
    /**
     * Purpose: Calculate the bill with the tip added.
     * Input/Output: Given bill and tipPercent, return billWithTip
     * Examples:
     * calculateFinalBill(50.00,10.00) returns 55.00
     */
    public static double calculateFinalBill(double bill, double tipPercent) {
        double billWithTip = bill + (bill * (tipPercent / 100));
        return billWithTip;
    }
    
    /**
     * Purpose: Calculate the final price after markup, city and state taxes.
     * Input/Output: Given initialPrice and markupPercent, return finalPrice
     * Examples:
     * calculateMarkup(50.00,100.00) returns 110.00
     */
    public static double calculateMarkup(double initialPrice, double markupPercent) {
        double preTaxPrice = initialPrice + 
                            (initialPrice * (markupPercent / 100));
        // City tax = 2%, State tax = 8%
        double finalPrice = preTaxPrice + (0.08 * preTaxPrice)
                            + (0.02 * preTaxPrice);
        return finalPrice;
    }
}
