import javax.swing.JOptionPane;
public class JOptionPaneReader {
    public static int readInt(String string) {
        int output = 0;
        try {
            output = Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(string + " is an invalid integer!");
        }
        return output;
    }

    public static double readDouble(String string) {
        double output = 0;
        try {
            output = Double.parseDouble(string);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(string + " is an invalid double!");
        }
        return output;
    }
}
