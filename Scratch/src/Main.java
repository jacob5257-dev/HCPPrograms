import javax.swing.*;
import java.io.FileNotFoundException;

// this code is messy but it works
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Hangman hangman = new Hangman();
        System.out.println("The category is: " + hangman.getCategory());
        while (hangman.getValidGuesses() != 0) {
            char[] currentDashes = hangman.getDashes();
            if (hangman.getGuessed()) {
                System.out.println("You win!");
                break;
            }
            System.out.println(hangman);
            try {
                String guess = JOptionPane.showInputDialog("Guess a letter: ");
                if (guess == null) {
                    JOptionPane.showMessageDialog(null, "You quit the game.");
                    System.exit(0);
                }
                hangman.getGuess(guess);
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
            hangman.update();
            char[] newDashes = hangman.getDashes();
            boolean same = true;
            for (int i = 0; i < currentDashes.length; i++) {
                if (currentDashes[i] != newDashes[i]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                hangman.useGuess();
                System.out.println("That letter is not in the word.");
            }
            if (!hasDashes(newDashes)) {
                hangman.setGuessed(true);
                System.out.println("You win!");
                break;
            }
            System.out.println("You have " + hangman.getValidGuesses() + " guesses left.");
        }

        if (hangman.getGuessed()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose! The word was " + hangman.getSecretWord());
        }
    }

    public static boolean hasDashes(char[] dashes) {
        for (char c : dashes) {
            if (c == '-') return true;
        }
        return false;
    }
}