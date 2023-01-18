/**
 * This class contains the methods used to track the number of coins in a "piggy bank" and the 
 * total amount of money/value in the piggy bank.  Total number of coins is the total number of
 * pennies, nickels, dimes and quarters in the piggy bank.  The value is the sum of the pennies, nickels, 
 * dimes and quarters in the piggy bank.
 * @version 1.0
 * @author gfw1
 * @author jacob5257
 * @since 2016-11-01
 * @see PiggyBankTester
 * @revision 1.1
 * @revisionDate 2016-11-01
 * @revisionAuthor jacob5257
 * @revisionDescription Finished program.
 */
public class PiggyBank 
{	
	// constant coin denomination
	private static final double QUARTER_VALUE = .25;
	private static final double DIME_VALUE = .10;
	private static final double NICKEL_VALUE = .05;
	private static final double PENNY_VALUE = .01;
		  
	// instance variables
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;
	
	/**
	 * This is the constructor method for the piggy bank.
	 * This constructor will be called with the number of coins
	 * for each denomination.
	 */

	//default constructor that constructs an empty piggy bank (finish initializing instance variables)
	public PiggyBank()
	{
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}
	/**
	 * This is the constructor method for the piggy bank.
	 * @param pennies The number of pennies in the piggy bank
	 * @param nickels The number of nickels in the piggy bank
	 * @param dimes The number of dimes in the piggy bank
	 * @param quarters The number of quarters in the piggy bank
	 */
	public PiggyBank (int quarters, int dimes, int nickels, int pennies)
	{
		// Set the instance variables to the values passed in
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickels = nickels;
		this.pennies = pennies;
	}
	
	/**
	 * This method returns the total number of coins in the piggy bank
	 * @return The total number of coins in the piggy bank
	 */
	public int numCoins()
	{
		return pennies + nickels + dimes + quarters;
	}
	
	/**
	 * This methods returns the value of the coins in the piggy bank (complete the method implementation)
	 * @return The value of the coins in the piggy bank
	 */
	public double totalValue()
	{
		return (pennies * PENNY_VALUE) + (nickels * NICKEL_VALUE) + (dimes * DIME_VALUE) + (quarters * QUARTER_VALUE);
	}

	/**
	 * Get the number of quarters in the piggy bank
	 * @return The number of quarters in the piggy bank
	 */
	public int getQuarters( )
	{
		return quarters;
	}

	/** 
	 * Amount of dimes in the piggy bank   
	 * @return The number of dimes in the piggy bank
	 */
	public int getDimes( )
	{
		return dimes;
	}

	/**
	 * Amount of nickels in the piggy bank
	 * @return The number of nickels in the piggy bank
	 */
	public int getNickels( )
	{
		return nickels;
	}

	/**
	 * Amount of pennies in the piggy bank
	 * @return The number of pennies in the piggy bank
	 */
	public int getPennies( )
	{
		return pennies;
	}
	
	/** This toString method will return a string containing the current number of coins in the piggy bank.
	 * @return A string containing the current number of coins in the piggy bank.
	 */
	public String toString()
	{
		return "Total coins in the piggy bank = " + numCoins();
	}
}
