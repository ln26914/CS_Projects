import java.util.Random;
/**
 * Palindrome: Methods to reverse a string and check if it's a palindrome
 * 
 * Inputs: ---
 * Outputs: ---
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 1st, 2024)
 */

public class Palindrome {
    /**
     * Purpose: Demonstrate the string reversal and palindrome functionality
     * Input: ---
     * Output: Method Testing Results
     * main() returns nothing but prints results
     */
    public static void main(String[] args) {
        // Define Variables
        String testString1 = "Noah Boyd";
        String testString2 = "tacocat";
        
        System.out.println("Noah Boyd -> " + reverse(testString1));
        System.out.println("Is it a palindrome? " + isPalindrome(testString1));
        System.out.println("tacocat -> " + reverse(testString2));
        System.out.println("Is it a palindrome? " + isPalindrome(testString2));
    }
    
    /**
     * Purpose: Reverse the parameter string
     * Given a string, returns its reverse
     * reverse("test") returns "tset"
     */
    public static String reverse(String toReverse) {
        // Define Variables
        String reversed = "";
        
        //Last to first character
        for(int i = toReverse.length()-1; i >= 0; i--) {
            reversed += toReverse.charAt(i);
        }
        
        // Return reversed string
        return reversed;
    }
    
    /**
     * Purpose: Check if the parameter string is the same 
     * backward and forward
     * Given a string, return whether it's a palindrome
     * (same backward and forward)
     * isPalindrome("bruh") returns false
     */
    public static boolean isPalindrome(String target) {
        return target.equals(reverse(target));
    }
}
