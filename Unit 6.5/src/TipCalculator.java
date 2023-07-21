import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        // Create a program that will take in a bill amount and a tip percentage and calculate the dollar amount of tips and the total bill
        String input = JOptionPane.showInputDialog("How much money was the original bill? (in dollars)");
        double originalBill = Double.parseDouble(input);
        // Give the user the option to tip 15%, 18%, 20%, or custom. If they select custom, ask them for the tip percentage
        Object[] options = {"15% (okay)", "18% (good)", "20% (great)", "Custom"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("How much would you like to tip?"));
        int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
        if (selection == 3) {
            input = JOptionPane.showInputDialog("How much would you like to tip? (in percent)");
        } else {
            input = options[selection].toString().substring(0, 2);
        }
        double tipPercentage = 0;
        try { tipPercentage = Double.parseDouble(input); }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            System.exit(0);
        }
        // Round the tip amount to the nearest cent
        DecimalFormat df = new DecimalFormat("#.##");
        double tipAmount = Double.parseDouble(df.format(originalBill * (tipPercentage / 100)));
        double totalBill = originalBill + tipAmount;
        JOptionPane.showMessageDialog(null, "The tip amount is $" + tipAmount + " and the total bill is $" + totalBill);

    }
}