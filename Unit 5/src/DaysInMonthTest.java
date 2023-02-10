import javax.swing.JOptionPane;

public class DaysInMonthTest {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Month number: ");
        int month_number;
        try {
            month_number = Integer.parseInt(input);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid month!");
        }
        DaysInMonth daysInMonth = new DaysInMonth(month_number);
        int days = daysInMonth.getDays();
        if (days == -1) throw new RuntimeException("Invalid month!");
        JOptionPane.showMessageDialog(null, days + " days");
    }
}
