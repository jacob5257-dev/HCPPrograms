import javax.swing.*;

public class QuadraticFormula {
    public static void main(String[] args) {
        JTextField aField = new JTextField(5);
        JTextField bField = new JTextField(5);
        JTextField cField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Format: ax^2 + bx + c = 0"));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("a:"));
        myPanel.add(aField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("b:"));
        myPanel.add(bField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("c:"));
        myPanel.add(cField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter values.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
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
            double sqrt = Math.sqrt(b * b - 4 * a * c);
            double x1 = (-b + sqrt) / (2 * a);
            double x2 = (-b - sqrt) / (2 * a);
            String output = "f(x) = " + a + "x^2 + " + b + "x + " + c + " = 0\n";
            if (Double.isNaN(x1) || Double.isNaN(x2)) output += "No real solutions.";
            else if (x1 == x2) output += "x = " + x1;
            else output += "x1 = " + x1 + ", x2 = " + x2;
            JOptionPane.showMessageDialog(null, output);
        }
        else {
            JOptionPane.showMessageDialog(null, "Cancelled.");
        }
    }
}
