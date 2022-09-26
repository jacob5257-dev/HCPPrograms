import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        OG Number: 79927398713
        Every second digit from the right going left * 2
        If result > 1 digit, add digits (6 * 2 = 12, 1 + 2 = 3)

        Add all numbers, if multiple 10, then good!
         */
        List<Integer> numsToDouble = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter CC#: ");
        String ccInput = myScanner.nextLine();
        //79927398713
        if (ccInput.length() != 16) throw new RuntimeException("Invalid credit card number!");
        String ccReverse = reverseString(ccInput);
        for (int i = 0; i < ccInput.length(); i++) {
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
            ch= original.charAt(i); //extracts each character
            str= ch+str; //adds each character in front of the existing string
        }

        return str;
    }
}