// Imports for the gui and decimal rounder
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * This program will calculate the tip amount and total bill based on the original bill amount and tip percentage.
 * @since 7/21/2023
 * @version 1.0
 * @author jacob5257
 * you're welcome greg
 */
public class TipCalculator {
    public static void main(String[] args) {
        // Starting variables
        double originalBill = 0;
        String input;
        // Ask the user for the original bill amount and handle errors
        try { originalBill = Double.parseDouble(JOptionPane.showInputDialog("<html>Welcome to the tip calculator.<br>How much money was the original bill? (in dollars)</html>")); }
        catch (Exception e) { JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number."); System.exit(0); }
        // Give the user the option to tip 15%, 18%, 20%, or custom. If they select custom, ask them for the tip percentage
        Object[] options = {"15% (okay)", "18% (good)", "20% (great)", "Custom"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("How much would you like to tip?"));
        int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
        // If it's custom, then ask them for the tip percentage. Otherwise, just substring the option to get the xx for xx%.
        if (selection == 3) {
            input = JOptionPane.showInputDialog("How much would you like to tip? (in percent)");
        } else {
            input = options[selection].toString().substring(0, 2);
        }
        // Convert tip percentage to a double, throw an error if the input is invalid
        double tipPercentage = 0;
        try { tipPercentage = Double.parseDouble(input); }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            System.exit(0);
        }
        // Round the tip amount to the nearest cent and calculate the total bill
        DecimalFormat df = new DecimalFormat("#.##");
        double tipAmount = Double.parseDouble(df.format(originalBill * (tipPercentage / 100)));
        double totalBill = originalBill + tipAmount;
        // Print the final
        JOptionPane.showMessageDialog(null, "The total tip is $" + tipAmount + " and the total bill is $" + totalBill + ".");
        // Give the user the option to split the bill
        JPanel panel2 = new JPanel();
        Object[] options2 = {"Yes", "No"};
        panel2.add(new JLabel("Do you want to split the bill?"));
        int selection2 = ( JOptionPane.showOptionDialog(null, panel2, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, null));
        // If they want to split the bill, ask them how many people are splitting the bill and calculate the split bill. Otherwise, just display the tip amount and total bill.
        if (selection2 == 0) {
            input = JOptionPane.showInputDialog("How many people are splitting the bill?");
            int people = 0;
            try { people = Integer.parseInt(input); }
            catch (Exception e) { JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number."); System.exit(0); }
            double splitBill = totalBill / people;
            JOptionPane.showMessageDialog(null, "The total tip is $" + tipAmount + " and the total bill is $" + totalBill + ". The split bill is $" + splitBill + " per person.");
        }
        else {
            JOptionPane.showMessageDialog(null, "The total tip is $" + tipAmount + " and the total bill is $" + totalBill + ".");
        }
    }
}