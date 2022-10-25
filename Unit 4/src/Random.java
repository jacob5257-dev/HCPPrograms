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

        while (true) {
            guessed = false;
            tries = 0;
            random = 1 + (int) (Math.random() * (max - min + 1));
            while (!guessed) {
                Scanner myObj = new Scanner(System.in);
                System.out.println("Your guess: ");
                try {
                    if (Objects.equals(myObj.nextLine(), "stop")) {
                        System.out.println("Stopped.");
                        return;
                    }
                    guess = Integer.parseInt(myObj.nextLine());
                } catch (Exception e) {
                    throw new RuntimeException("Invalid input!");
                }
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
