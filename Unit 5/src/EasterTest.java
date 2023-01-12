import javax.swing.JOptionPane;

public class EasterTest {
    public static void main(String[] args) {
        String yearSelectString = JOptionPane.showInputDialog("Enter the year: ");
        int year = 0;
        try {
            year = Integer.parseInt(yearSelectString);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cancelled or invalid input.");
            System.exit(0);
        }
        Easter easter = new Easter(year);
        JOptionPane.showMessageDialog(null, "Easter is on " + easter.getEasterDate() + ".");
    }
}
