import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void validate(String ccInput) {
        List<Integer> numsToDouble = new ArrayList<>();
        if (ccInput.length() != 16) throw new RuntimeException("Invalid credit card number!");
        String ccReverse = reverseString(ccInput);
        for (int i = 0; i < ccInput.length(); i++) {
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
                throw new RuntimeException("Invalid credit card number!");
            }
        }
        int sum = 0;
        for (Integer integer : numsToDouble) {
            sum += integer;
        }

        if (sum % 10 == 0) System.out.println("Good number!");
        else System.out.println("Bad number!");
    }

    public static String reverseString(String original) {
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