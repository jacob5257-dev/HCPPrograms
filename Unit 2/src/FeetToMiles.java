import javax.swing.*;

public class FeetToMiles {
    public static void main(String[] args) {
        final int feetInMiles = 5280;
        final double distance = Double.parseDouble(JOptionPane.showInputDialog("How long to convert (miles)?"));
        JOptionPane.showMessageDialog(null, distance + " miles is " + (distance * feetInMiles) + " feet.");
    }
}
