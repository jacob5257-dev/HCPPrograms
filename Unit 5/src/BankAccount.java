/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-19
 * @see BankAccount
 * @see BankAccountTest
 */

public class BankAccount {
    // Properties of the bank account
    private final String name;
    private double balance;
    private final double interestRate;
    private final double overdraftFee;
    
    /**
     * Constructs a bank account with a zero balance.
     * @param name The name of the account holder
     * @param balance The initial balance
     * @param interestRate The interest rate
     * @param overdraftFee The overdraft fee
     */
    public BankAccount(String name, double balance, double interestRate, double overdraftFee) {
        this.name = name;
        this.balance = balance;
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
    }

    /**
     * Gets the name of the account holder.
     * @return The name of the account holder
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current balance of the bank account.
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits money into the bank account.
     * @param amount The amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraws money from the bank account.
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount) {
        balance -= amount;
        if (balance < 0.0) {
            balance -= overdraftFee;
        }
    }

    /**
     * Adds interest to the bank account.
     * Prevents people from adding interest to a negative balance.
     */
    public void addInterest() {
        if (balance > 0) balance += balance * interestRate / 100;
    }
}
