import javax.swing.JOptionPane;
import java.util.List;

/**
 * This class tests the Cashier class.
 * 
 * @author   jacob5257
 * @version  1.0
 * @since    2023-01-18
 * @see      Cashier
 */
public class CashierTest {
    /**
     * This method tests the Cashier class.
     * 
     * @author   jacob5257
     * @version  1.0
     * @since    2023-01-18
     * @see      Cashier
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Get the cost and amount given from the user
        String cost = JOptionPane.showInputDialog(null, "Enter the cost of the item: ");
        String amountGiven = JOptionPane.showInputDialog(null, "Enter the amount given by the customer: ");
        // Handles cancel button
        if (cost == null || amountGiven == null) {System.exit(1); }
        // Try to create a cashier object and get the change. Will fail if:
        // 1. The cost or amount given is not a number
        // 2. The amount given is less than the cost
        try { 
            // Create a cashier object and gives the change in the JOptionPane.
            Cashier cashier = new Cashier(Double.parseDouble(cost), Double.parseDouble(amountGiven));
            List<Integer> change = cashier.getChange();
            // Round to two decimal places with printf
            System.out.printf("$%.2f", change.get(0) + change.get(1) * 0.25 + change.get(2) * 0.1 + change.get(3) * 0.05 + change.get(4) * 0.01);
            JOptionPane.showMessageDialog(null, "You need to give the customer " + change.get(0) + " dollars, " + change.get(1) + " quarters, " + change.get(2) + " dimes, " + change.get(3) + " nickels, and " + change.get(4) + " pennies.");    
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(1); 
        }
    }
}
