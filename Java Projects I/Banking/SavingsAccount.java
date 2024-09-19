
/**
 * A Savings Account Class
 * Just like a bank account, except limited to $0 balance or higher with only
 * 6 withdraws per month.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd
 * @version v0.1 (July 14th, 2024)
 */
public class SavingsAccount extends Account { // is-a Bank Account
    
    // Instance Variables
    private double minBalance = 0; // Minimum Account Balance
    private int withdrawals = 0; // Track the number of withdrawals
    
    /**
     * Constructor:
     * Create objects of type SavingsAccount
     */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber, interestRate);
        this.balance = 0.00;
    }
    
    /**
     * getWithdrawCount
     * Returns the number of withdrawals from this account.
     */
    public int getWithdrawCount() {
        return this.withdrawals;
    }
    
    /**
     * Withdraw:
     * 
     * Override:
     * Withdraw an amount that's less than or equal to this account's balance
     */
    @Override
    public void withdraw(double amount) throws InvalidAmountException, WithdrawCountException {
        if(amount <= this.balance + minBalance && withdrawals < 6) {
            // Balance is at least the amount. Withdraw Possible.
            // Minimum balance is 0.
            // Number of withdrawals is less than 6.
            super.withdraw(amount);
            this.withdrawals ++;
        } else if (amount >= this.balance + minBalance) {
            // Too much overdraft
            throw new InvalidAmountException((this.balance - amount), this.minBalance);
        } else if (withdrawals >= 6) {
            throw new WithdrawCountException(this.withdrawals);   
        }
        /*
        * Maximum Withdraws reached
        * OR
        * Insufficient Balance
        */
            
    }
    
    /**
     * ProcessEndOfMonth
     * Add interest from the end of this month.
     * Override: Reset withdrawal count.
     */
    @Override
    public void processEndOfMonth() throws InvalidAmountException{
        super.processEndOfMonth();
        withdrawals = 0;
    }
}
