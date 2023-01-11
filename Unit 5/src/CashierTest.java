import javax.swing.JOptionPane;
import java.util.List;

public class CashierTest {
    public static void main(String[] args) {
        String cost = JOptionPane.showInputDialog(null, "Enter the cost of the item: ");
        String amountGiven = JOptionPane.showInputDialog(null, "Enter the amount given by the customer: ");
        if (cost == null || amountGiven == null) System.exit(1);
        try { 
            Cashier cashier = new Cashier(Double.parseDouble(cost), Double.parseDouble(amountGiven));
            List<Integer> change = cashier.getChange();
            JOptionPane.showMessageDialog(null, "You need to give the customer " + change.get(0) + " dollars, " + change.get(1) + " quarters, " + change.get(2) + " dimes, " + change.get(3) + " nickels, and " + change.get(4) + " pennies.");    
        }
        catch (Exception e) { System.exit(1); }
    }
}
