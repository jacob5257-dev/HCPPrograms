import javax.swing.*;
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
 * @revisionDate 2023-01-18
 * @revisionAuthor jacob5257
 * @revisionDescription Finished program.
 * @revision 2.0
 * @revisionDate 2023-01-26
 * @revisionAuthor jacob5257
 * @revisionDescription Added gui.
 * @revision 2.1
 * @revisionDate 2023-01-26
 * @revisionAuthor jacob5257
 * @revisionDescription Bugfixing.
 */
public class PiggyBankTester 
{
	public static void main(String[] args) 
	{
		// Setup a dialog input and request the number of coins to put in the piggy bank
		JTextField quarterInput = new JTextField(5);
        JTextField dimeInput = new JTextField(5);
        JTextField nickelInput = new JTextField(5);
        JTextField pennyInput = new JTextField(5);
        // Creates a panel and adds the text fields to it.
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Quarters: "));
        myPanel.add(quarterInput);
        myPanel.add(new JLabel("Dimes: "));
        myPanel.add(dimeInput);
        myPanel.add(new JLabel("Nickels: "));
        myPanel.add(nickelInput);
        myPanel.add(new JLabel("Pennies: "));
        myPanel.add(pennyInput);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Piggy bank creation tool.", JOptionPane.OK_CANCEL_OPTION);
		if (result != JOptionPane.OK_OPTION) {
			// If the user does not click OK, exit the program
			System.exit(0);
		}
		try {
			// Convert all the strings to integers, throwing an error if the input is not a number\
			int pennies = 0;
			int nickels = 0;
			int dimes = 0;
			int quarters = 0;
			if (pennyInput.getText().length() > 0) pennies = Integer.parseInt(pennyInput.getText());
			if (nickelInput.getText().length() > 0) nickels = Integer.parseInt(nickelInput.getText());
			if (dimeInput.getText().length() > 0) dimes = Integer.parseInt(dimeInput.getText());
			if (quarterInput.getText().length() > 0) quarters = Integer.parseInt(quarterInput.getText());
			// Create a piggy bank object by creating an instance of the piggy bank class with user specified input (coins)
			PiggyBank piggyBank = new PiggyBank(quarters, dimes, nickels, pennies);
			while (true) {
				// Ask the user if they want to add more coins, and if so, how many of each type.
				Object[] options = {"Yes", "No"};
                JPanel panel = new JPanel();
				panel.add(new JLabel("<html>The piggy bank has " + piggyBank.getQuarters() + " quarters, " + piggyBank.getDimes() + " dimes, " + piggyBank.getNickels() + " nickels, and " + piggyBank.getPennies() + " pennies.<br>The total number of coins is " + piggyBank.numCoins() + " and the total value is " + piggyBank.formattedTotalValue() + ".<br>Do you want to add more coins?</html>"));
                int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
				if (selection == 0) {
					// If the user wants to add more coins, ask how many of each type
					JTextField quarterInput2 = new JTextField(5);
					JTextField dimeInput2 = new JTextField(5);
					JTextField nickelInput2 = new JTextField(5);
					JTextField pennyInput2 = new JTextField(5);
					// Creates a panel and adds the text fields to it.
					JPanel myPanel2 = new JPanel();
					myPanel2.add(new JLabel("Quarters: "));
					myPanel2.add(quarterInput2);
					myPanel2.add(new JLabel("Dimes: "));
					myPanel2.add(dimeInput2);
					myPanel2.add(new JLabel("Nickels: "));
					myPanel2.add(nickelInput2);
					myPanel2.add(new JLabel("Pennies: "));
					myPanel2.add(pennyInput2);
					int result2 = JOptionPane.showConfirmDialog(null, myPanel2, "Piggy bank addition tool.", JOptionPane.OK_CANCEL_OPTION);
					if (result2 != JOptionPane.OK_OPTION) {
						// If the user does not click OK, exit the program
						System.exit(0);
					}
					// Convert all the strings to integers, throwing an error if the input is not a number
					String pennyString2 = pennyInput2.getText();
					String nickelString2 = nickelInput2.getText();
					String dimeString2 = dimeInput2.getText();
					String quarterString2 = quarterInput2.getText();
					int pennies2 = 0;
					int nickels2 = 0;
					int dimes2 = 0;
					int quarters2 = 0;
					if (pennyString2.length() > 0) pennies2 = Integer.parseInt(pennyInput2.getText());
					if (nickelString2.length() > 0) nickels2 = Integer.parseInt(nickelInput2.getText());
					if (dimeString2.length() > 0) dimes2 = Integer.parseInt(dimeInput2.getText());
					if (quarterString2.length() > 0) quarters2 = Integer.parseInt(quarterInput2.getText());
					// Add the coins to the piggy bank
					List<Integer> coinList = new ArrayList<Integer>();
					coinList.add(quarters2);
					coinList.add(dimes2);
					coinList.add(nickels2);
					coinList.add(pennies2);
					piggyBank.addCoins(coinList);
				}
				else {
					// If the user does not want to add more coins, exit the loop
					break;
				}
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			// If the input is not a number, display an error message
			JOptionPane.showMessageDialog(null, "Error: Input is not a number");
		}
		catch (Exception e) {
			// If the input is a number, but not a valid number of coins, display an error message
			JOptionPane.showMessageDialog(null, "Error: Invalid number of coins");
		}
		
	}
}
