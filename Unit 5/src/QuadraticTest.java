import javax.swing.*;

/**
 * A class to test the Quadratic class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-02-07
 * @see Quadratic
 */
public class QuadraticTest {
    /**
     * The main method.
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create text fields for the user to enter the coefficients.
        JTextField aField = new JTextField(5);
        JTextField bField = new JTextField(5);
        JTextField cField = new JTextField(5);
        // Create a panel to hold the text fields.
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("f(x) = "));
        myPanel.add(aField);
        myPanel.add(new JLabel("x^2 + "));
        myPanel.add(bField);
        myPanel.add(new JLabel("x + "));
        myPanel.add(cField);
        // Show the panel in a dialog box.
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter values.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Get the values from the text fields and assign them to variables, catching errors if they occur.
            double a;
            double b;
            double c;
            try {
                a = Double.parseDouble(aField.getText());
                b = Double.parseDouble(bField.getText());
                c = Double.parseDouble(cField.getText());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input.");
                return;
            }
            // Create a Quadratic object and use it to get the roots.
            String output = getString(a, b, c);
            JOptionPane.showMessageDialog(null, output);
        }
    }

    private static String getString(double a, double b, double c) {
        Quadratic q = new Quadratic(a, b, c);
        // Create a string to display the roots with html for line breaks.
        String output = "<html>f(x) = " + a + "x^2 + " + b + "x + " + c + "<br>";
        if (!q.hasSolutions()) output += "No real solutions.</html>";
        else if (q.hasEqualRoots()) output += "x = " + q.getRoot1() + "</html>";
        else output += "x1 = " + q.getRoot1() + ", x2 = " + q.getRoot2() + "</html>";
        return output;
    }
}
