import javax.swing.JOptionPane;

public class RunLuhnCheck {
    public static void main(String[] args) {
        String digitsString = JOptionPane.showInputDialog("Enter digits to check:");
        LuhnChecker luhnChecker = new LuhnChecker(digitsString);
        JOptionPane.showMessageDialog(null, "Next digit is " + luhnChecker.getCheckDigit(digitsString) + ".");
    }
}
