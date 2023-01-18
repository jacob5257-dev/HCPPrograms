import javax.swing.JOptionPane;

/**
 * This class tests the Easter class.
 * @since 2023-01-18
 * @version 1.0
 * @author jacob5257
 * @see Easter
 */
public class EasterTest {
    /**
     * This method tests the Easter class.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Easter
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Get the year from the user.
        String yearSelectString = JOptionPane.showInputDialog("Enter the year: ");
        int year = 0;
        // Convert the year to an integer, if possible.
        try {
            year = Integer.parseInt(yearSelectString);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cancelled or invalid input.");
            System.exit(0);
        }
        // Create an Easter object and display the date of Easter.
        Easter easter = new Easter(year);
        JOptionPane.showMessageDialog(null, "Easter is on " + easter.getEasterDate() + ".");
    }
}
