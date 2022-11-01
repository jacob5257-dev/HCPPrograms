import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LuhnChecker {
    public static void main(String[] args) {
        String digitsString = JOptionPane.showInputDialog("Enter digits to check:");
        JOptionPane.showMessageDialog(null, "Next digit is " + getCheckDigit(digitsString) + ".");
    }

    public static int getCheckDigit(String digits) {
        List<Integer> finalNums = new ArrayList<>();
        String digitsReverse = Main.reverseString(digits);
        for (int i = 0; i < digitsReverse.length(); i++) {
            int number;
            try { number = Integer.parseInt(String.valueOf(digitsReverse.charAt(i))); }
            catch (NumberFormatException e) { return -1; }
            if (i % 2 == 0) {
                number *= 2;
                if (number >= 10) {
                    int firstValue = number / 10;
                    int secondValue = number - 10;
                    number = firstValue + secondValue;
                }
            }
            finalNums.add(number);
        }
        int sum = 0;
        for (Integer integer : finalNums) {
            sum += integer;
        }
        int checkDigit = 10 - (sum % 10);
        if (checkDigit == 10) checkDigit = 0;
        return checkDigit;
    }
}
