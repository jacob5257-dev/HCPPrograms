import javax.swing.JOptionPane;

/**
 * This program asks the user for a month number and displays the number of days in that month.
 * @author jacob5257
 * @version 1.0
 * @since 2023-02-14
 * @see DaysInMonth
 */

public class DaysInMonthTest {
    /**
     * This is the main method of the program.
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Asks user for input and tries to parse it to an integer, throwing an error if it isn't.
        String input = JOptionPane.showInputDialog("Month number: ");
        int month_number;
        try {
            month_number = Integer.parseInt(input);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid month!");
            return;
        }
        // Creates a new DaysInMonth object and gets the number of days in the month.
        DaysInMonth daysInMonth = new DaysInMonth(month_number);
        int days = daysInMonth.getDays();
        if (days == -1) throw new RuntimeException("Invalid month!");
        JOptionPane.showMessageDialog(null, days + " days");
    }
}
