import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Number: ");
        String user_number = myObj.nextLine();

        int number;
        try {
            number = Integer.parseInt(user_number);
        } catch (Exception e) {
            throw new RuntimeException("Not a number!");
        }

        if (number % 2 == 0) System.out.println("Number is even.");
        else System.out.println("Number is odd.");
    }
}
