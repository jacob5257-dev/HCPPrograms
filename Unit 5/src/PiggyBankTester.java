import javax.swing.JOptionPane;

/**
 * This is the test class for the piggy bank program.  This class will obtain the
 * number of coins in each denomination to put into the piggy bank and display the 
 * total number of coins and the value contained in the piggy bank.
 *  
 * @author gfw1
 *
 */
public class PiggyBankTester 
{
	public static void main(String[] args) 
	{
		String input = ""; // this is a temp placeholder for user input
		
		// Setup a dialog input and request the number of coins to put in the piggy bank
		input = JOptionPane.showInputDialog("Enter the number of pennies ");
		int pennies = Integer.parseInt(input);
		input = JOptionPane.showInputDialog("Enter the number of nickels ");
		int nickels = Integer.parseInt(input);
		//complete the code to get user input for dimes and quarters
		input = JOptionPane.showInputDialog("Enter the number of dimes ");
		int dimes = Integer.parseInt(input);
		input = JOptionPane.showInputDialog("Enter the number of quarters ");
		int quarters = Integer.parseInt(input);
		// Create a piggy bank object by creating an instance of the piggy bank class with user specified input (coins)
		PiggyBank piggyBank = new PiggyBank(quarters, dimes, nickels, pennies);
		// Display the total number of each coin, the total number of coins and 
		// the total value in the piggy bank.
		JOptionPane.showMessageDialog(null, "The piggy bank has " + piggyBank.getQuarters() + " quarters, " + piggyBank.getDimes() + " dimes, " + piggyBank.getNickels() + " nickels, and " + piggyBank.getPennies() + " pennies.  The total number of coins is " + piggyBank.numCoins() + " and the total value is $" + piggyBank.totalValue());
		
	}
}
