import javax.swing.*;

/**
 * This class tests the Employee class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-19
 * @see EmployeeTest
 * @see Employee
 */

public class EmployeeTest {
    /**
     * Tests the Employee class.
     * @param args the command line arguments (not used).
     */
    public static void main(String[] args) {
        JTextField nameInput = new JTextField(5);
        JTextField balanceInput = new JTextField(5);
        // Creates a panel and adds the text fields to it.
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name: "));
        myPanel.add(nameInput);
        myPanel.add(new JLabel("Salary: $"));
        myPanel.add(balanceInput);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Employee creation tool.", JOptionPane.OK_CANCEL_OPTION);
		if (result != JOptionPane.OK_OPTION) {
			// If the user does not click OK, exit the program
			System.exit(0);
		}
        String name;
        double balance;
        Employee employee;
        if (nameInput.getText().length() == 0 && balanceInput.getText().length() == 0) employee = new Employee();
        else {
            try {
                name = nameInput.getText();
                balance = Double.parseDouble(balanceInput.getText());
                employee = new Employee(name, balance);
            }
            catch (NumberFormatException e) {
                // If the user enters an invalid balance, exit the program
                System.exit(0);
                return;
            }
        }
        while (true) {
            // Give the user the name and current salary at the top. Below that, ask how much they want to raise the salary by.
            String[] options = {"Raise salary", "Change name", "Exit"};
            int option = JOptionPane.showOptionDialog(null, employee.getName() + "'s current salary is $" + employee.getFormatSalary() + ".", "Employee management tool.", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option == 0) {
                // If the user wants to raise the salary, ask how much they want to raise it by.
                String raiseInput = JOptionPane.showInputDialog(null, "How much would you like to raise the salary by (percent)?", "Employee management tool.", JOptionPane.QUESTION_MESSAGE);
                if (raiseInput == null) {
                    // If the user clicks cancel, exit the program
                    System.exit(0);
                }
                try {
                    double raise = Double.parseDouble(raiseInput);
                    employee.raiseSalary(raise);
                }
                catch (NumberFormatException e) {
                    continue;
                }
            }
            else if (option == 1) {
                // If the user wants to change the name, ask what they want to change it to.
                String newName = JOptionPane.showInputDialog(null, "What would you like to change the name to?", "Employee management tool.", JOptionPane.QUESTION_MESSAGE);
                if (newName == null) {
                    // If the user clicks cancel, exit the program
                    System.exit(0);
                }
                employee.changeName(newName);
            }
            else {
                // If the user wants to exit, exit the program
                System.exit(0);
            }
        }
    }
}
