import javax.swing.*;

public class ReadWithJOptionPane {
    public static void main(String[] args) {
        int sum = 0;
        boolean done = false;
        while (!done) {
            String input = JOptionPane.showInputDialog("Enter a number, cancel to quit:");
            if (input == null) {
                done = true;
            }
            else {
                try {
                    sum += Integer.parseInt(input);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Sum: " + sum);
    }
}
