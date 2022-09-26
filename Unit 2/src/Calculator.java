import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Number 1:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Number 2:"));

        JOptionPane.showMessageDialog(null, "Sum: " + (num1 + num2) + "\n Difference: " + (num1 - num2) + "\n Product: " + (num1 * num2) + "\n Quotient: " + (num1 / num2));
    }
}
