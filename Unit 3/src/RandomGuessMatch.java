import java.util.Scanner;

public class RandomGuessMatch {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        int max = 5;
        int min = 0;
        int random;
        int guess;
        boolean guessed = false;

        while (true) {
            guessed = false;
            random = 1 + (int) (Math.random() * (max - min + 1));
            while (!guessed) {
                Scanner myObj = new Scanner(System.in);
                System.out.println("Your guess: ");
                try {
                    guess = Integer.parseInt(myObj.nextLine());
                } catch (Exception e) {
                    myObj.close();
                    throw new RuntimeException("Invalid input!");
                }
                if (guess == random) {
                    System.out.println("Correct!");
                    guessed = true;
                }
                else {
                    System.out.println("Incorrect! Your guess is " + Math.abs(guess - random) + " away from the correct answer.");
                }
                myObj.close();
            }
        }
    }
}
