import javax.swing.*;
import java.util.*;


public class Generator {
    public static void main(String[] args) {
        Object[] options = {"Validate", "Generate"};
        int optionInput = createPopup(options);

        if (Objects.equals(optionInput, 0)) {
            String ccInput = createOption("Enter CC#.");
            CC cc = new CC(ccInput);
            if (cc.validate(false) == "Good number!") JOptionPane.showMessageDialog(null, "This is a valid credit card number!");
            else JOptionPane.showMessageDialog(null, "This is not a valid number!");
        }
        else if (Objects.equals(optionInput, 1)) {
            String optionInput2 = createOption("How many numbers to generate?");
            int count = 1;
            Object[] options2 = {"Visa", "MasterCard"};
            int type = createPopup(options2);

            try { count = Integer.parseInt(optionInput2); }
            catch (Exception e) { System.out.println("Invalid option, going with 1..."); }
            if (count == 0) System.out.println("Done!");
            if (count < 0) System.out.println("Negative number, going with infinity...");

            String output = "";
            String ccNumber;
            while (count != 0) {

                if (type == 0) ccNumber = "4" + generateRandomNumbers(15);
                else if (type == 1) ccNumber = "5" + generateMCFirstDigit() + generateRandomNumbers(14);
                else ccNumber = "0000000000000000";
                CC cc = new CC(ccNumber);
                if (cc.validate(false) == "Good number!") {
                    output += ccNumber;
                    output += "\n";
                    count--;
                }
            }

            JOptionPane.showMessageDialog(null, output);
        }
        else System.out.println("Invalid option!");
    }

    public static String generateRandomNumbers(int numOfNum) {
        String numbers = "";
        for (int i = 0; i < numOfNum; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            numbers += String.valueOf(randomNumber);
        }

        return numbers;
    }

    public static String generateMCFirstDigit() {
        Random random = new Random();
        return String.valueOf(random.nextInt(5) + 1);
    }

    public static int createPopup(Object[] options1) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("What would you like to do?"));

        return JOptionPane.showOptionDialog(null, panel, "Select an option.",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
    }

    public static String createOption(String text) {
        return JOptionPane.showInputDialog(text);
    }
}
