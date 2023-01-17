import java.util.List;
import java.util.ArrayList;

public class CC {
    private String cardNumber;

    public CC(){}

    public CC(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String validate(boolean printStuff) {

        List<Integer> numsToDouble = new ArrayList<>();
        if (cardNumber.length() != 16) throw new RuntimeException("Invalid credit card number!");
        String ccReverse = reverseString(cardNumber);
        for (int i = 0; i < cardNumber.length(); i++) {
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

        if (sum % 10 == 0) {
            return "Good number!";
        }
        else {
            return "Bad number!";
        }
    }

    private String reverseString(String original) {
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
