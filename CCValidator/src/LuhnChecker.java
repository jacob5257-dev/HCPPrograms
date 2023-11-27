import java.util.ArrayList;
import java.util.List;

public class LuhnChecker {
    final String digits;

    public LuhnChecker(String digits) {
        this.digits = digits;
    }

    public int getCheckDigit(String digits) {
        List<Integer> finalNums = new ArrayList<>();
        String digitsReverse = reverseString(digits);
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

    private static String reverseString(String original) {
        String str = "";
        char ch;


        for (int i = 0; i< original.length(); i++)
        {
            ch= original.charAt(i);
            str= ch+str;
        }

        return str;
    }
}
