import javax.swing.*;

public class MadLib {
    public static void main(String[] args) {
        String noun1 = JOptionPane.showInputDialog("Enter a noun:");
        String noun2 = JOptionPane.showInputDialog("Enter a noun:");
        String adj1 = JOptionPane.showInputDialog("Enter an adjective:");
        String verb1 = JOptionPane.showInputDialog("Enter a verb:");

        JOptionPane.showMessageDialog(null, "Mary had a little " + noun1 + "\n Its " + noun2 + " was " + adj1 + " as snow. \n And everywhere that Mary " + verb1 + ", \n the " + noun1 + " was sure to go.");
    }
}
