import javax.swing.JOptionPane;

public class EasterTest {
    public static void main(String[] args) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String yearSelectString = JOptionPane.showInputDialog("Enter the year: ");
        int year = Integer.parseInt(yearSelectString);
        Easter easter = new Easter(year);
        System.out.println(year);
        System.out.println(easter.getMonth());
        System.out.println(easter.getDay());
        JOptionPane.showMessageDialog(null, "Easter is on " + months[easter.getMonth()] + " " + easter.getDay() + ".");
    }
}
