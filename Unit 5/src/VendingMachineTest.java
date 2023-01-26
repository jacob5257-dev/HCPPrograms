import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VendingMachineTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the price of a can: ");
        double price = scanner.nextDouble();
        VendingMachine machine = new VendingMachine(price);
        machine.fillUp(10);
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
                JOptionPane.showMessageDialog(null, "Enjoy your soda can! There are " + machine.getCanCount() + " cans left in the machine. The machine has $" + machine.getBankBalance() + " in it.");

            }
            else if (input == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "There are " + machine.getCanCount() + " cans left in the machine. The machine has $" + machine.getBankBalance() + " in it.");
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "The machine is out of soda cans.");
                break;
            }
        }
        scanner.close();
        System.exit(0);
    }
}
