import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DivideStrings {
    /*
    Write an application that accepts up to 20 strings.  Divide them into two array lists - one for short Strings that are five characters or fewer, and the other for long Strings.  After data entry is complete, prompt the user to enter which type of String to display, and then output to the correct list.  If there are no Strings in a requested list, then output an appropriate message.  Save the file as DivideStrings.java
     */
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String string = JOptionPane.showInputDialog("Enter a string: ");
            if (string == null || string.isEmpty()) {
                break;
            }
            strings.add(string);
        }
        List<String> shortStrings = new ArrayList<>();
        List<String> longStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > 5) longStrings.add(str);
            else shortStrings.add(str);
        }
        Object[] options = {"Short strings", "Long strings"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Which strings would you like to display?"));
        int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
        String output = "";
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
        else {
            JOptionPane.showMessageDialog(null, "You didn't select an option.");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, (output.isEmpty() ? "There are no " + (selection == 0 ? "short" : "long") + " strings." : output));
    }
}
