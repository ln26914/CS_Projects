
/**
 * Main:
 * Primary Executable Class. Tests the classes defined in the other files.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd 5550203507
 * @version v0.2 (July 19th, 2024)
 * 
 * Initial Deposit: $500
 * Initial Withdraw: $450
 * 
 * Final Balance after Interest: $50.50
 */
public class Main {
    public static void main(String[] args) throws InvalidAmountException, WithdrawCountException {
        // Define Variables
        // Acct #: 11876521, Interest Rate = 12%
        Account myAccount = new Account(11876521, 12);
        Account savingsAccount1 = new SavingsAccount(11876522, 12);
        Account checkingAccount1 = new CheckingAccount(11876523, 12);
        
        // Testing Account base functions
        // Test deposit amount
        System.out.println("Testing Account Base Functions");
        System.out.printf("Balance: %.2f\n", myAccount.getBalance());
        myAccount.deposit(500);
        
        
        // Test withdraw
        System.out.printf("Balance: %.2f\n", myAccount.getBalance());
        myAccount.withdraw(450);
        
        // Test processEndOfMonth
        System.out.printf("Balance: %.2f\n", myAccount.getBalance());
        myAccount.processEndOfMonth();
        System.out.printf("Balance: %.2f\n\n", myAccount.getBalance());
        
        
        // Testing Savings Account Extra Functionality
        System.out.println("Testing Saving Account Functionality");
        
        // Testing Deposit
        savingsAccount1.deposit(500);
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        // Attempt Overdraft
        savingsAccount1.withdraw(800); // 800 is more than 500.
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        // Withdraw Normally x6
        savingsAccount1.withdraw(50); // 50 is less than 500.
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        // Withdraw $250 over 5 transactions
        for(int i = 0; i < 5; i++) {
            savingsAccount1.withdraw(50);
        }
        
        // Show withdraw count
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        // This withdraw is possible but is stopped by the system.
        savingsAccount1.withdraw(25);
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        // End of Month Processing
        savingsAccount1.processEndOfMonth();
        System.out.printf("Balance: %.2f \nWithdrawals: %d\n\n", 
        savingsAccount1.getBalance(), ((SavingsAccount)savingsAccount1).getWithdrawCount());
        
        
        // Test Checking Account Functionality
        System.out.println("Testing Checking Account Functionality");
        
        // Test Deposit Amount
        checkingAccount1.deposit(500);
        System.out.printf("Balance: %.2f \nDeposits: %d\n", 
        checkingAccount1.getBalance(), ((CheckingAccount) checkingAccount1).getDepositCount());
        
        // Make Withdrawals
        checkingAccount1.withdraw(15);
        System.out.printf("Balance: %.2f \nDeposits: %d\n", 
        checkingAccount1.getBalance(), ((CheckingAccount) checkingAccount1).getDepositCount());
        
        checkingAccount1.withdraw(35);
        System.out.printf("Balance: %.2f \nDeposits: %d\n", 
        checkingAccount1.getBalance(), ((CheckingAccount) checkingAccount1).getDepositCount());
        
        // End of Month Processing
        checkingAccount1.processEndOfMonth();
        System.out.printf("Balance: %.2f \nDeposits: %d\n", 
        checkingAccount1.getBalance(), ((CheckingAccount) checkingAccount1).getDepositCount());
        
    }
}
