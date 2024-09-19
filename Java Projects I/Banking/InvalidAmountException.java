
/**
 * InvalidAmountException
 * 
 * An Exception Class that handles excessive overdrafts.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd 5550203507
 * @version v0.1 (July 18th, 2024)
 */
public class InvalidAmountException extends Exception {
    
    public InvalidAmountException(double potentialAmount, double minBalance) {
        super("Excessive Overdraft: " + potentialAmount + " < " + minBalance);
    }
}
