import java.util.Objects;
import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        int max = 5;
        int min = 0;
        int random;
        int guess;
        boolean guessed;
        int tries;
        Scanner myObj = new Scanner(System.in);

        while (true) {
            guessed = false;
            tries = 0;
            random = (int) (Math.random() * (max - min + 1) + min);
            while (!guessed) {

                System.out.print("Your guess: ");
                String input = myObj.nextLine();
                if (Objects.equals(input, "stop")) {
                    System.out.println("Stopped.");
                    myObj.close();
                    return;
                }
                try { guess = Integer.parseInt(input); }
                catch (Exception e) { myObj.close(); throw new RuntimeException("Invalid input!"); }
                tries++;
                if (guess == random) {
                    System.out.println("Correct! It took you " + tries + " tries to guess correctly.");
                    guessed = true;
                }
                else if (guess > random) { System.out.println("Your guess was too high!"); }
                else { System.out.println("Your guess was too low!"); }
            }
        }
    }
}
