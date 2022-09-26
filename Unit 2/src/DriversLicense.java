import javax.swing.*;

public class DriversLicense {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));

        if (age >= 16) JOptionPane.showMessageDialog(null, name + ", you can apply for a license now!");
        else JOptionPane.showMessageDialog(null, name + ", you can apply for a license in " + (16 - age) + " years.");
    }
}
