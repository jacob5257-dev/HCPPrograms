import javax.swing.JOptionPane;

/**
 * This class tests the PrimeFactorization class.
 * @since 2023-01-18
 * @version 1.0
 * @author jacob5257
 * @see PrimeFactorization
 */
//skipcq: JAVA-W1062
public class PrimeFactorizationTest {
    /**
     * This method tests the PrimeFactorization class.
     * @since 2023-01-18
     * @param args The command line arguments (not used).
     * @version 1.0
     * @author jacob5257
     * @see PrimeFactorization
     */
    public static void main(String[] args) {
        // Get the number from the user and tries to parse it into a number.
        String input = JOptionPane.showInputDialog("Enter a number.");
        int number = 0;
        try { number = Integer.parseInt(input); }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cancelled or invalid number.");
            System.exit(number);
        }
        if (number < 0) {
            JOptionPane.showMessageDialog(null, "Number must be positive.");
            System.exit(1);
        }
        // Create a PrimeFactorization object and sets up the output string.
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
