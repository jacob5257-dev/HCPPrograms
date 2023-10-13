import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Read words from all possible words
        FileReader reader = new FileReader("Wordle/src/words.txt");
        Scanner file = new Scanner(reader);
        // Adds all words to an ArrayList
        ArrayList<String> words = new ArrayList<>();
        while (file.hasNext()) {
            words.add(file.next());
        }
        file.close();
        // Remove all words that aren't 5 letters long
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() != 5) {
                words.remove(i);
                i--;
            }
        }
        // Picks a random word from the ArrayList to be the answer
        String word = words.get((int) (Math.random() * words.size()));
        System.out.println(word); //todo this prints the word delete after testing
        // Creates a list of previous guesses
        String[] previousGuesses = new String[5];
        // Counter for number of guesses
        int guesses = 0;
        // Checks if they have any more turns available
        while (guesses <= 5) {
            // Asks them to guess a word
            String guess = JOptionPane.showInputDialog(null, "<html>Guess a word<br>" + createGuessGrid(previousGuesses, word) + "</html>").toLowerCase();
            // Check if their guess was the right length
            if (guess.length() != 5) {
                JOptionPane.showMessageDialog(null, "Invalid length");
                continue;
            }
            // Check if character has anything other than letters a-z
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) < 'a' || guess.charAt(i) > 'z') {
                    JOptionPane.showMessageDialog(null, "Invalid character");
                    break;
                }
            }
            previousGuesses[guesses] = guess;
            guesses++;
        }
    }

    /**
     * Evaluates a guess and returns an array of integers representing the result.
     * @param guess The guess that the player made.
     * @param answer The correct answer to the wordle.
     * @return An array of integers representing the result. 0 = gray, 1 = yellow, 2 = green. (ex. [0, 2, 1, 1, 0])
     * @throws IllegalArgumentException If the guess or answer is not 5 characters long.
     */
    public static int[] evaluateGuess(String guess, String answer) {
        if (guess.length() != 5 || answer.length() != 5) throw new IllegalArgumentException("Invalid length");
        char[] answerChars = answer.toCharArray();
        char[] guessChars = guess.toCharArray();
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            // Check if the character is in the right place
            System.out.println("comparing " + answerChars[i] + " and " + guessChars[i]);
            if (answerChars[i] == guessChars[i]) result[i] = 2;
            // If not, check if it is in the word but in the wrong place
            else {
                System.out.println("not in right place");
                for (int j = 0; j < 5; j++) {
                    System.out.println("comparing " + answerChars[i] + " and " + guessChars[j]);
                    if (answerChars[i] == guessChars[j]) {
                        System.out.println("in word but wrong place");
                        result[i] = 1;
                        break;
                    }
                }
            }
        }
        // 0 = gray, 1 = yellow, 2 = green
        return result;
    }

    /**
     * Given the guesses, creates the wordle grid with the guess and color beneath it.
     * @param guesses The array of guesses the user has played.
     * @param answer The correct answer to the wordle.
     * @return A string formatted as a wordle grid.
     */
    public static String createGuessGrid(String[] guesses, String answer) {
        String grid = "";
        for (String guess : guesses) {
            if (guess == null) break;
            grid += guess + "<br>";
            int[] result = evaluateGuess(guess, answer);
            for (int r : result) {
                if (r == 2) grid += "G";
                else if (r == 1) grid += "Y";
                else grid += "X";
                System.out.println(r + " ");
            }
            grid += "<br>";
        }
        return grid;
    }
}