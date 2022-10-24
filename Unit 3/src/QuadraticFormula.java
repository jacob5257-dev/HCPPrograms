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
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            double sqrt = Math.sqrt(b * b - 4 * a * c);
            double x1 = (-b + sqrt) / (2 * a);
            double x2 = (-b - sqrt) / (2 * a);
            if (Double.isNaN(x1) || Double.isNaN(x2)) {
                JOptionPane.showMessageDialog(null, "No real solutions.");
            }
            else if (x1 == x2) {
                JOptionPane.showMessageDialog(null, "x = " + x1);
            }
            else {
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Cancelled.");
        }
    }
}
