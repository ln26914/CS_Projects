
/**
 * A Checking Account Class
 * Just like a bank account, except limited to -$100 balance and tracks
 * deposit fees.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd
 * @version v0.1 (July 14th, 2024)
 */
public class CheckingAccount extends Account { // is-a Account
    
    // Instance Variables
    private double minBalance = -100; // Minimum balance in the account
    private int deposits = 0; // Deposit counter for fee charging
    
    /**
     * Constructor:
     * Create objects of type CheckingAccount
     */
    public CheckingAccount(int accountNumber, double interestRate) {
        super(accountNumber, interestRate);
        this.balance = 0.00;
    }
    
    /**
     * getDeposits
     * Returns the number of deposits from this account.
     */
    public int getDepositCount() {
        return this.deposits;
    }
    
    /**
     * Withdraw:
     * 
     * Override:
     * Withdraw an amount that's less than or equal to this account's balance
     */
    @Override
    public void withdraw(double amount) throws WithdrawCountException, InvalidAmountException {
        if(amount <= this.balance - minBalance) {
            // Balance is at least the amount. Withdraw Possible.
            // Minimum balance is -100.
            super.withdraw(amount);
        } else {
            // Too much overdraft
            throw new InvalidAmountException((this.balance - amount), this.minBalance);
        }
        // Insufficient Balance
        // Do nothing
    }
    
    /**
     * Deposit:
     * 
     * Override:
     * Track the deposit count with this object's deposit count variable
     */
    public void deposit(double amount) {
        super.deposit(amount);
        this.deposits ++;
    }
    
    /**
     * ProcessEndOfMonth
     * Add interest from the end of this month.
     * Override: Reset withdrawal count.
     */
    @Override
    public void processEndOfMonth() throws InvalidAmountException {
        super.processEndOfMonth();        
        this.balance -= (this.getDepositCount() * 2); // $2 deposit fee for each deposit.
        this.deposits = 0;
    }
}
