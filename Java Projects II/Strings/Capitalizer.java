
/**
 * Capitalizer: Given a string of words, capitalize the first letter of each
 * word.
 * Given "dell conhager" returns "Dell Conhager"
 * capitalize("dell conhager") returns "Dell Conhager
 * 
 * Capitalizing an empty string returnCapitalizer: Given a string of words, capitalize the first letter of each
 * word.
 * Given "dell conhager" returns "Dell Conhager"
 * capitalize("dell conhager") returns "Dell Conhager
 * 
 * Capitalizing an empty string returns an empty strings an empty string
 *
 * @author Noah Boyd 5550203507
 * @version 0.1 7/5/2024
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 */
public class Capitalizer
{
    /**
     * Test the functionality of the capitalize() function.
     * Given nothing, prints out a capitalized string and returns nothing.
     * main() returns nothing
     */
    public static void main(String[] args) {
        String test = "a cup of liber-tea";
        System.out.printf("%s -> %s \n",test,capitalize(test));
    }
    
    /**
     * Given a string of words, capitalize the first letter of 
     * each word.
     * Given "dell conhager" returns "Dell Conhager"
     * capitalize("dell conhager") returns "Dell Conhager
     * Capitalizing an empty string returns an empty string
     */
    public static String capitalize(String input) {
        String[] inputWords = input.split(" ");
        String output = "";
        
        for(int i = 0; i < inputWords.length; i++ ) {
            inputWords[i] = inputWords[i].substring(0,1).toUpperCase()
                            + inputWords[i].substring(1);
            
            output += (inputWords[i] + " ");
        }
        
        return output;
    }
}
