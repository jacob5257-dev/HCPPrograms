import javax.swing.JOptionPane;

public class PrimeFactorizationTest {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter a number.");
        int number = 0;
        try { number = Integer.parseInt(input); }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cancelled or invalid number.");
            System.exit(number);
        }
        PrimeFactorization pf = new PrimeFactorization(number);
        String output = "The prime factors of " + number + " are: ";
        System.out.println(number);
        while (pf.hasMoreFactors()) {
            output += pf.nextFactor() + " ";
        }
        if (output.equals("The prime factors of " + number + " are: ")) output += number;
        JOptionPane.showMessageDialog(null, output);
    }
}
