
/**
 * Banking Account Class.
 * Simulate the functionality of a banking account.
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @author Noah Boyd 5550203507
 * @version v0.1 (July 14th 2024)
 */
public class Account {
    // Instance Variables
    protected double balance; // Amount in the account
    protected double interestRate; // Rate of growth, in APY.
    protected int accountNumber; // User-generated account number

    /**
     * Constructor for objects of class Account.
     * Given the account number and interest rate, generate a new account.
     */
    public Account(int accountNumber, double interestRate) {
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.balance = 0.00;
    }
    
    /**
     * getBalance:
     * Return the balance within this account.
     * No Parameters
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * getInterestRate
     * Return the interest rate of this account.
     * No Parameters
     */
    public double getInterestRate() {
        return this.interestRate;
    }
    
    /**
     * getAccountNumber
     * Return the bank account number of this account.
     * Use with care. The account numbers are unencrypted.
     * No parameters
     */
    public double getAccountNumber() {
        return this.accountNumber;
    }
    
    /**
     * deposit
     * Add some money to the balance of this account.
     * Given the double amount, add it to this balance and return nothing.
     * Checks for a negative deposit amount.
     */
    public void deposit(double amount) throws IllegalArgumentException {
        
        // Negative deposits cause an error.
        if(amount < 0) throw new IllegalArgumentException("Cannot deposit a negative amount");
        
        // Add the balance to the account.
        this.balance += amount;
    }
    
    /**
     * withdraw
     * Remove some money from the balance of this account.
     * Given the double amount, subtract it rom this balance and return
     * nothing.
     * Checks for a negative withdraw amount.
     */
    public void withdraw(double amount) throws IllegalArgumentException, InvalidAmountException, WithdrawCountException{
        // Negative withdrawals cause an error.
        if(amount < 0) throw new IllegalArgumentException("Cannot withdraw a negative amount");
        
        // Subtract the balance from the account.
        this.balance -= amount;
    }
    
    /**
     * processEndOfMonth()
     * Gain interest to your account.
     */
    public void processEndOfMonth() throws InvalidAmountException{
        double interestAmount = (interestRate / 100.0) * (1 / 12.0) * (balance);
        this.balance += interestAmount;
    }
}
