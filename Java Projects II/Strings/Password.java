import java.util.Scanner;
/**
 * Password: Check if a password is strong based on if it has at least one
 * uppercase letter, two digits, and a length of five or more characters.
 *
 * @author Noah Boyd 5550203507
 * @version 0.1 (July 5th 2024)
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 */
public class Password
{
    /**
     * Purpose: check if a password is valid based on the stated criteria:
     * be 5 characters long, with 1 or more uppercase letters and 2 or more 
     * digits.
     * 
     * Inputs: Password (from keyboard)
     * Outputs: Password Feedback (to console)
     * 
     * Returns nothing.
     */
    public static boolean main(String[] args) {
        //Define Variables
        Scanner keys = new Scanner(System.in);
        String userPassword = ""; //String filled by keyboard input
        boolean isValid = true; //Boolean variable to check requirements
        
        //Get input
        System.out.print("Enter a password to check: ");
        userPassword = keys.nextLine();
        System.out.println();
        
        //Check input against requirements
        if(!hasFiveChars(userPassword)) isValid = false;
        if(!hasUppercase(userPassword)) isValid = false;
        if(!hasTwoDigits(userPassword)) isValid = false;
        
        //Present output
        System.out.printf("Password Valid: %b\n",isValid);
        return isValid;
    }
    
    /**
     * Purpose: Check if a string has uppercase letters.
     * Given a string, returns a boolean value
     * hasUppercase("Acids and Bases") returns true.
     * hasUppercase("no") returns false.
     */
    public static boolean hasUppercase(String input) {
        // Declare Variables
        char currentChar = '\0';
        
        // Search for an uppercase letter
        for(int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            if(Character.isUpperCase(currentChar)) return true;
        }
        return false;
    }
    
    /**
     * Purpose: Check how many numerical digits are in a string and return
     * true if there are two or more.
     * 
     * Given a string, returns an boolean
     * hasTwoDigits("G0bl1n") returns true
     */
    public static boolean hasTwoDigits(String input) {
        // Define Variables
        int numDigits = 0;
        char currentChar = '\0';
    
        // Count the digits in the array
        for(int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            if(Character.isDigit(currentChar)) numDigits ++;
        }
        
        // Output
        return numDigits >= 2;
    }
    
    /**
     * Purpose: Determine whether the password meets the 5 character
     * requirement
     * Given a password, return true if it has 5 or more characters
     * and false otherwise.
     * 
     * hasFiveChars("Goblin") returns true.
     */
    public static boolean hasFiveChars(String input) {
        return input.length() > 5;
    }
}
