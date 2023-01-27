import javax.swing.*;

public class VendingMachineTest {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the price of a can: ");
        double price = scanner.nextDouble();
        VendingMachine machine = new VendingMachine(price);
        machine.fillUp(10);
        */
        JTextField priceInput = new JTextField(5);
        JTextField canInput = new JTextField(5);
        // Creates a panel and adds the text fields to it.
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Price of Can $: "));
        myPanel.add(priceInput);
        myPanel.add(new JLabel("Number of Cans: "));
        myPanel.add(canInput);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Vending Machine creation tool.", JOptionPane.OK_CANCEL_OPTION);
		if (result != JOptionPane.OK_OPTION) {
			// If the user does not click OK, exit the program
			System.exit(0);
		}
        VendingMachine machine;
        double price = 0;
        int numCans = 0;
		try {
			// Convert all the strings to integers, throwing an error if the input is not a number\
			if (priceInput.getText().length() > 0) price = Double.parseDouble(priceInput.getText());
			if (canInput.getText().length() > 0) numCans = Integer.parseInt(canInput.getText());
        }
        catch (NumberFormatException e) {
            // If the user enters a non-number, exit the program
            System.exit(0);
        }
        machine = new VendingMachine(price);
        machine.fillUp(numCans);
        while (true) { 
            JOptionPane optionPane = new JOptionPane("Do you want to buy a soda can?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog dialog = optionPane.createDialog(null, "Vending Machine");
            dialog.setVisible(true);
            int input = (int) optionPane.getValue();
            if (input == JOptionPane.YES_OPTION && machine.getCanCount() > 0) {
                double moneyInserted = 0;
                while (moneyInserted < price) {
                    String moneyInput = JOptionPane.showInputDialog(null, "Money inserted: " + moneyInserted + " Enter a coin: ");
                    machine.insertCoin(Double.parseDouble(moneyInput));
                    moneyInserted += Double.parseDouble(moneyInput);
                }
                JOptionPane.showMessageDialog(null, "<html>Enjoy your soda can! There are " + machine.getCanCount() + " cans left in the machine.<br>The machine has $" + machine.getBankBalance() + " in it and $" + (moneyInserted - price) + " in change has been returned.</html>");

            }
            else if (input == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "There are " + machine.getCanCount() + " cans left in the machine. The machine has $" + machine.getBankBalance() + " in it.");
                break;
            }
            else {
                JOptionPane questionPane = new JOptionPane("<html>This machine is out of soda cans.<br>Do you want to refill it?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                JDialog questionDialog = questionPane.createDialog(null, "Vending Machine");
                questionDialog.setVisible(true);
                int questionInput = (int) questionPane.getValue();
                if (questionInput == JOptionPane.YES_OPTION) {
                    machine.fillUp(10);
                }
                else {
                    break;
                }
            }
        }
        System.exit(0);
    }
}
