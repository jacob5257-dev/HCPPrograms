import java.text.DecimalFormat;
import javax.swing.*;
//skipcq: JAVA-W1088
public class UnitConverterTest {
    public static void main(String[] args) {
        Object[] options = {"Inches", "Feet", "Miles", "Meters", "Millimeters", "Centimeters", "Kilometers"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("What unit would you like to convert from?"));
        int option = JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (option == -1) JOptionPane.showMessageDialog(null, "Invalid option!");
        String input = JOptionPane.showInputDialog("Value: ");
        double value = 0;
        try {
            value = Double.parseDouble(input);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid option!");
            System.exit(0);
        }
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("What unit would you like to convert to?"));
        int option2 = JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        UnitConverter unitConverter = new UnitConverter(option, value);
        double convertedValue = unitConverter.toMeters();
        UnitConverter unitConverter2 = new UnitConverter(option2, convertedValue);
        double finalValue = unitConverter2.fromMeters();
        // Use decimal format to round to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        finalValue = Double.parseDouble(df.format(finalValue));
        

        JOptionPane.showMessageDialog(null, "Value: " + finalValue + " " + options[option2].toString().toLowerCase() + "(s)");
    }
}
