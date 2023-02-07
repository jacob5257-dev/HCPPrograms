import javax.swing.*;

public class QuadraticTest {
    public static void main(String[] args) {
        JTextField aField = new JTextField(5);
        JTextField bField = new JTextField(5);
        JTextField cField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("f(x) = "));
        myPanel.add(aField);
        myPanel.add(new JLabel("x^2 + "));
        myPanel.add(bField);
        myPanel.add(new JLabel("x + "));
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
            Quadratic q = new Quadratic(a, b, c);
            String output = "<html>f(x) = " + a + "x^2 + " + b + "x + " + c + "<br>";
            if (!q.hasSolutions()) output += "No real solutions.</html>";
            else if (q.hasEqualRoots()) output += "x = " + q.getRoot1() + "</html>";
            else output += "x1 = " + q.getRoot1() + ", x2 = " + q.getRoot2() + "</html>";
            JOptionPane.showMessageDialog(null, output);
        }
    }
}
