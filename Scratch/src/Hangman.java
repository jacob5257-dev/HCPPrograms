import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private String secretWord;
    private char[] secretWordArray;
    private List<Character> guessedLetters = new ArrayList<>();
    private boolean guessed = false;
    private int validGuesses = 10;
    private char[] dashesArray;

    public Hangman() throws FileNotFoundException {
        // word list from https://raw.githubusercontent.com/dwyl/english-words/master/words.txt
        FileReader reader = new FileReader("Scratch/src/words.txt");
        Scanner file = new Scanner(reader);
        List<String> words = new ArrayList<>();
        while (file.hasNext()) {
            String word = file.next();
            if (word.matches("^[a-zA-Z]*$")) {
                words.add(word.toLowerCase());
            }
        }
        file.close();
        this.secretWord = words.get((int) (Math.random() * words.size()));
        this.secretWordArray = this.secretWord.toCharArray();
        this.dashesArray = new char[this.secretWordArray.length];
        for (int i = 0; i < this.secretWordArray.length; i++) {
            this.dashesArray[i] = '-';
        }
    }

    public String toString() {
        return new String(dashesArray);
    }

    public void getGuess(String c) {
        if (c.length() != 1 || !c.matches("^[a-zA-Z]*$")) throw new IllegalArgumentException("Please enter a single letter.");
        if (this.guessedLetters.contains(c.charAt(0))) throw new RuntimeException("You already guessed that letter.");
        this.guessedLetters.add(c.charAt(0));
    }

    public void update() {
        char[] result = new char[this.secretWordArray.length];
        for (int i = 0; i < this.secretWordArray.length; i++) {
            if (this.secretWordArray[i] == this.guessedLetters.get(this.guessedLetters.size() - 1)) {
                result[i] = this.secretWordArray[i];
            } else {
                result[i] = this.dashesArray[i];
            }
        }
        this.dashesArray = result;
    }

    public void useGuess() { this.validGuesses--; }

    public int getValidGuesses() { return this.validGuesses; }

    public boolean getGuessed() { return this.guessed; }

    public void setGuessed(boolean guessed) { this.guessed = guessed; }

    public char[] getDashes() { return this.dashesArray; }

    public void setDashesArray(char[] dashesArray) { this.dashesArray = dashesArray; }

    public String getSecretWord() { return this.secretWord; }
}
