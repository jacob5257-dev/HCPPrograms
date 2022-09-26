import javax.swing.*;

public class MovieQuote {
    public static void main(String[] args) {
        String first = JOptionPane.showInputDialog("What is your first name? ");
        String last = JOptionPane.showInputDialog("What is your last name?");
        String quote = JOptionPane.showInputDialog("What is your favorite movie quote?");

        JOptionPane.showMessageDialog(null, first + " " + last + " " + quote);
    }
}
