import java.util.Scanner;

public class InBetween {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;

        try {
            System.out.println("First number: ");
            num1 = myObj.nextInt();
            System.out.println("Second number:+++ ");
            num2 = myObj.nextInt();
        }
        catch (Exception e) {
            myObj.close();
            throw new RuntimeException("Invalid input!");
        }

        int lowerNumber = 0;
        int higherNumber = 0;
        if (num1 > num2) {
            lowerNumber = num2;
            higherNumber = num1;
        }
        else if (num1 < num2) {
            lowerNumber = num1;
            higherNumber = num2;
        }
        if (higherNumber - lowerNumber == 1 || higherNumber - lowerNumber == -1 || num1 - num2 == 0) { myObj.close(); throw new RuntimeException("Select numbers that have more than one number in between them."); }

        for (int i = lowerNumber; i < higherNumber - 1; i++) {
            System.out.println(i + 1);
        }
        myObj.close();
    }
}
