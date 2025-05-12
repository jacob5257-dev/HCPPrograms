import javax.swing.*;
import java.io.*;

// this code is messy but it works
public class Main {
    // throws the exceptions if the files aren't in the right places
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // resets the used list of words to empty at the beginning
        FileWriter writer = new FileWriter("src/main/java/used.txt", false);
        writer.write("");
        writer.close();
        // creates win/loss counter
        int wins = 0;
        int losses = 0;
        // keep going until the user wants to stop
        while (true) {
            // if they got the word, add one to win count
            if (play()) {
                wins++;
            }
                // otherwise add one to the loss count
            else {
                losses++;
            }
            // print total win/loss and ask of they want to play again
            System.out.println("Wins: " + wins + " Losses: " + losses);
            if (JOptionPane.showConfirmDialog(null, "Play again?") != 0) {
                break;
            }
        }
    }

    /**
     * Checks if a given list of characters has dashes. Makes checking if there's any unknown characters left.
     * @param list the list of characters
     * @return true if there are dashes, false if not
     */
    public static boolean hasDashes(char[] dashes) {
        for (char c : dashes) {
            // if at any point there is a '-', then return true
            if (c == '-') return true;
        }
        return false;
    }

    /**
     * Plays a game of hangman.
     * @return true if the user won, false if they lost
     * @throws FileNotFoundException if the file used.txt doesn't exist
     * @throws IOException if the file used.txt is empty
     */
    public static boolean play() throws FileNotFoundException, IOException {
        // creates a new game
        Hangman hangman = new Hangman();
        // message for JOP
        String message = "";
        // prints the category
        System.out.println("The category is: " + hangman.getCategory());
        // checks if they have any guesses left
        while (hangman.getValidGuesses() != 0) {
            // gets the dashes
            char[] currentDashes = hangman.getDashes();
            // if they already won, don't bother running the rest (just in case)
            if (hangman.getGuessed()) {
                System.out.println("You win!");
                break;
            }
            // draw the hangman with the proper number of body parts based on number of guesses used
            drawHangman(hangman.getValidGuesses());
            // print the dashes
            System.out.println(hangman);
            // keep trying to get a valid guess
            try {
                message += String.format("%s%nGuess a letter:", hangman.toString());
                String guess = JOptionPane.showInputDialog(message);
                message = "";
                // if they cancel, stop asking them
                if (guess == null) {
                    JOptionPane.showMessageDialog(null, "You quit the game.");
                    System.exit(0);
                }
                // put in the guess, the catch will print the error and ask again
                hangman.getGuess(guess);
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
            // check if the new dashes (after guessing) are the same as before. this means their character was in the word and shouldn't count as a wrong guess
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
                message += "That letter is not in the word.\n";
            }
            // if there aren't any more dashes, that means they won
            if (!hasDashes(newDashes)) {
                hangman.setGuessed(true);
                System.out.println("You win!");
                break;
            }
            System.out.println("You have " + hangman.getValidGuesses() + " guesses left.");
            message += "You have " + hangman.getValidGuesses() + " guesses left.\n";
        }

        // writes the word to the used.txt file so that it won't be shown in the same session
        FileWriter writer = new FileWriter("src/main/java/used.txt", true);
        writer.write(hangman.getCategory() + ":" + hangman.getSecretWord() + "\n");
        writer.close();
        // if they guessed the word, print the win message and vice versa
        if (hangman.getGuessed()) {
            System.out.println("You win! The word was " + hangman.getSecretWord());
            return true;
        } else {
            System.out.println("You lose! The word was " + hangman.getSecretWord());
            return false;
        }
    }

    /**
     * Draws the hangman based on the number of guesses left.
     * @param guesses the number of guesses left
     */
    public static void drawHangman(int guessesLeft) {
        // does what it says it does
        System.out.println("  _______");
        if (guessesLeft < 7) {
            System.out.println("  |     |");
        } else {
            System.out.println("  |");
        }
        if (guessesLeft < 6) {
            System.out.println("  |     O");
        } else {
            System.out.println("  |");
        }
        if (guessesLeft < 4) {
            System.out.println("  |    /|\\");
        } else if (guessesLeft < 5) {
            System.out.println("  |    /|");
        } else if (guessesLeft < 6) {
            System.out.println("  |    /");
        } else {
            System.out.println("  |");
        }
        if (guessesLeft < 2) {
            System.out.println("  |    / \\");
        } else if (guessesLeft < 3) {
            System.out.println("  |    /");
        } else {
            System.out.println("  |");
        }
        System.out.println("__|__");
    }
}