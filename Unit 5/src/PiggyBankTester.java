import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

/**
 * This is the test class for the piggy bank program.  This class will obtain the
 * number of coins in each denomination to put into the piggy bank and display the 
 * total number of coins and the value contained in the piggy bank.
 *  
 * @author gfw1
 * @author jacob5257
 * @revision 1.1
 * @revisionDate 20123-01-18
 * @revisionAuthor jacob5257
 * @revisionDescription Finished program.
 *
 */
public class PiggyBankTester 
{
	public static void main(String[] args) 
	{
		// Setup a dialog input and request the number of coins to put in the piggy bank
		String pennyString = JOptionPane.showInputDialog("Enter the number of pennies ");
		String nickelString = JOptionPane.showInputDialog("Enter the number of nickels ");
		String dimeString = JOptionPane.showInputDialog("Enter the number of dimes ");
		String quarterString = JOptionPane.showInputDialog("Enter the number of quarters ");
		try {
			// Convert all the strings to integers, throwing an error if the input is not a number
			int pennies = Integer.parseInt(pennyString);
			int nickels = Integer.parseInt(nickelString);
			int dimes = Integer.parseInt(dimeString);
			int quarters = Integer.parseInt(quarterString);
			// Create a piggy bank object by creating an instance of the piggy bank class with user specified input (coins)
			PiggyBank piggyBank = new PiggyBank(quarters, dimes, nickels, pennies);
			// Display the total number of each coin, the total number of coins and the total value in the piggy bank.
			JOptionPane.showMessageDialog(null, "The piggy bank has " + piggyBank.getQuarters() + " quarters, " + piggyBank.getDimes() + " dimes, " + piggyBank.getNickels() + " nickels, and " + piggyBank.getPennies() + " pennies.  The total number of coins is " + piggyBank.numCoins() + " and the total value is $" + piggyBank.totalValue());
			while (true) {
				// ask the user if they want to add more coins, and if so, how many of each type.
				String addCoins = JOptionPane.showInputDialog("Would you like to add more coins? (y/n)");
				if (addCoins.equals("y")) {
					// If the user wants to add more coins, ask how many of each type
					String pennyString2 = JOptionPane.showInputDialog("Enter the number of pennies ");
					String nickelString2 = JOptionPane.showInputDialog("Enter the number of nickels ");
					String dimeString2 = JOptionPane.showInputDialog("Enter the number of dimes ");
					String quarterString2 = JOptionPane.showInputDialog("Enter the number of quarters ");
					// Convert all the strings to integers, throwing an error if the input is not a number
					int pennies2 = Integer.parseInt(pennyString2);
					int nickels2 = Integer.parseInt(nickelString2);
					int dimes2 = Integer.parseInt(dimeString2);
					int quarters2 = Integer.parseInt(quarterString2);
					// Add the coins to the piggy bank
					List<Integer> coinList = new ArrayList<Integer>();
					coinList.add(quarters2);
					coinList.add(dimes2);
					coinList.add(nickels2);
					coinList.add(pennies2);
					piggyBank.addCoins(coinList);
					// Display the total number of each coin, the total number of coins and the total value in the piggy bank.
					JOptionPane.showMessageDialog(null, "The piggy bank has " + piggyBank.getQuarters() + " quarters, " + piggyBank.getDimes() + " dimes, " + piggyBank.getNickels() + " nickels, and " + piggyBank.getPennies() + " pennies.  The total number of coins is " + piggyBank.numCoins() + " and the total value is $" + piggyBank.totalValue());
				}
				else {
					// If the user does not want to add more coins, exit the loop
					break;
				}
			}
		}
		catch (NumberFormatException e) {
			// If the input is not a number, display an error message
			JOptionPane.showMessageDialog(null, "Error: Input is not a number");
		}
		catch (Exception e) {
			// If the input is a number, but not a valid number of coins, display an error message
			JOptionPane.showMessageDialog(null, "Error: Invalid number of coins");
		}
		
	}
}
