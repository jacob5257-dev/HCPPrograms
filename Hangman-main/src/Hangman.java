import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    // all the good stuff
    private final String secretWord;
    private final char[] secretWordArray;
    private final List<Character> guessedLetters = new ArrayList<>();
    private boolean guessed = false;
    private int validGuesses = 7;
    private char[] dashesArray;
    private final String category;

    /**
     * Constructor for the Hangman class.
     */
    public Hangman() throws FileNotFoundException, IOException {
        // adds all potential puzzles to the list
        FileReader reader = new FileReader("src/main/java/puzzles.txt");
        Scanner file = new Scanner(reader);
        List<String> words = new ArrayList<>();
        while (file.hasNext()) {
            String word = file.nextLine();
            words.add(word);
        }
        file.close();
        // removes all the used words from the list
        FileReader reader2 = new FileReader("src/main/java/used.txt");
        Scanner file2 = new Scanner(reader2);
        List<String> usedWords = new ArrayList<>();
        while (file2.hasNext()) {
            String word = file2.nextLine();
            usedWords.add(word);
        }
        file2.close();
        for (String word : usedWords) {
            words.remove(word);
        }
        // if they used all the words, tell them
        if (words.size() == 0) {
            System.out.println("No more words!");
            System.exit(0);
        }
        // picks a random word from the list and sets it as the secret word and the category
        String[] split = words.get((int) (Math.random() * words.size())).split(":");
        this.category = split[0];
        this.secretWord = split[1];
        // puts the word into an array of characters
        this.secretWordArray = this.secretWord.toCharArray();
        this.dashesArray = new char[this.secretWordArray.length];
        // fills the dashes array with dashes and / for spaces for the user to know what is left to guess
        for (int i = 0; i < this.secretWordArray.length; i++) {
            if (this.secretWordArray[i] == ' ') {
                this.dashesArray[i] = '/';
            } else {
                this.dashesArray[i] = '-';
            }
        }
    }

    /**
     * Prints the list of dashes
     * @return the dashes
     */
    public String toString() {
        return new String(dashesArray);
    }

    /**
     * Gets the guess and updates the list of guessed characters
     * @param c the guess
     */
    public void getGuess(String c) {
        // if it isn't a single letter, then tell them it's wrong
        if (c.length() != 1 || !c.matches("^[a-zA-Z]*$")) throw new IllegalArgumentException("Please enter a single letter.");
        // if they already guessed that letter, tell them
        if (this.guessedLetters.contains(Character.toUpperCase(c.charAt(0)))) throw new RuntimeException("You already guessed that letter.");
        // add the letter to the guessed letters
        this.guessedLetters.add(Character.toUpperCase(c.charAt(0)));
        update();
    }

    /**
     * Updates the dashes array
     */
    public void update() {
        // creates a new array of characters
        char[] result = new char[this.secretWordArray.length];
        // writes the letters or the dashes to the array
        for (int i = 0; i < this.secretWordArray.length; i++) {
            if (this.secretWordArray[i] == this.guessedLetters.get(this.guessedLetters.size() - 1)) {
                result[i] = this.secretWordArray[i];
            } else {
                result[i] = this.dashesArray[i];
            }
        }
        this.dashesArray = result;
    }

    // a bunch of getters and setters
    public void useGuess() { this.validGuesses--; }

    public int getValidGuesses() { return this.validGuesses; }

    public boolean getGuessed() { return this.guessed; }

    public void setGuessed(boolean guessed) { this.guessed = guessed; }

    public char[] getDashes() { return this.dashesArray; }

    public void setDashesArray(char[] dashesArray) { this.dashesArray = dashesArray; }

    public String getSecretWord() { return this.secretWord; }

    public String getCategory() { return this.category; }
}
