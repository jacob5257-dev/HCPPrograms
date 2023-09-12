import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DivideStrings {
    /**
     * This program will ask the user for strings and then divide them into short and long strings.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an arraylist for the user to put strings into
        List<String> strings = new ArrayList<>();
        // Iterate 20 times and ask the user for a string each time. If the user enters nothing, then stop asking for strings. (max 20 times)
        for (int i = 0; i < 20; i++) {
            // JOption cuz why not
            String string = JOptionPane.showInputDialog("Enter a string: ");
            // If they leave the string blank or hit cancel, stop asking for strings
            if (string == null || string.isEmpty()) {
                break;
            }
            // Add input to the arraylist
            strings.add(string);
        }
        // Create new arraylists for short and long strings
        List<String> shortStrings = new ArrayList<>();
        List<String> longStrings = new ArrayList<>();
        // Check through each string, and add it to shortStrings if it's less than 5 characters, or add it to longStrings if it's more than 5 characters
        for (String str : strings) {
            if (str.length() > 5) longStrings.add(str);
            else shortStrings.add(str);
        }
        // Ask the user which list they want
        Object[] options = {"Short strings", "Long strings"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Which strings would you like to display?"));
        int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
        String output = "";
        // If the user selects short, then print all short strings, and vice versa with long
        if (selection == 0) {
            for (String str : shortStrings) {
                output += str;
                output += "\n";
            }
        }
        else if (selection == 1) {
            for (String str : longStrings) {
                output += str;
                output += "\n";
            }
        }
        // If something breaks and selection isn't right, error ig
        else {
            JOptionPane.showMessageDialog(null, "You didn't select an option.");
            System.exit(0);
        }
        // Second ternary = short or long (name of list), first ternary = handling if list is empty
        JOptionPane.showMessageDialog(null, (output.isEmpty() ? "There are no " + (selection == 0 ? "short" : "long") + " strings." : output));
    }
}
