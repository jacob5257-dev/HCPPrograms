import javax.swing.*;

public class JOptionPaneStuffs {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter an integer: ");
        int num1 = Integer.parseInt(input);

        input = JOptionPane.showInputDialog("Enter an integer: ");
        int num2 = Integer.parseInt(input);

        JOptionPane.showMessageDialog(null, "The sum is " + (num1 + num2));
    }
}
