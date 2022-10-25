import java.util.ArrayList;
import java.util.List;

public class LuhnChecker {
    public static void main(String[] args) {
        String digitsString = "35317365537912";
        System.out.println(getCheckDigit(digitsString));
    }

    public static int getCheckDigit(String digits) {
        List<Integer> numsToDouble = new ArrayList<>();
        String ccReverse = Main.reverseString(digits);
        for (int i = 0; i < digits.length(); i++) {
            try {
                int number = Integer.parseInt(String.valueOf(ccReverse.charAt(i)));
                if (i % 2 != 0) {
                    number *= 2;
                    while (number >= 10) {
                        int firstValue = number / 10;
                        int secondValue = number - 10;
                        number = firstValue + secondValue;
                    }
                }
                numsToDouble.add(number);
            }
            catch (Exception e) {
                throw new RuntimeException("Not valid for some reason!");
            }
        }
        int sum = 0;
        for (Integer integer : numsToDouble) {
            sum += integer;
        }

        return 0;
    }
}
