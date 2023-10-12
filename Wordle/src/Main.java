import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("Wordle/src/words.txt");
        Scanner file = new Scanner(reader);
        ArrayList<String> words = new ArrayList<>();
        while (file.hasNext()) {
            words.add(file.next());
        }
        file.close();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() != 5) {
                words.remove(i);
                i--;
            }
        }
        String word = words.get((int) (Math.random() * words.size()));
        System.out.println(word);
        String[] previousGuesses = new String[5];
        int guesses = 0;
        while (guesses <= 5) {
            String guess = JOptionPane.showInputDialog(null, "Guess a word").toLowerCase();
            // Check if their guess was the right length
            if (guess.length() != 5) {
                JOptionPane.showMessageDialog(null, "Invalid length");
                continue;
            }
            // Check if character has anything other than letters a-z
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) < 'a' || guess.charAt(i) > 'z') {
                    JOptionPane.showMessageDialog(null, "Invalid character");
                    continue;
                }
            }
            previousGuesses[guesses] = guess;
            int[] result = evaluateGuess(guess, word);
            for (int r : result) {
                System.out.print(r + " ");
            }
            guesses++;
        }
    }

    public static int[] evaluateGuess(String guess, String answer) {
        int[] result = new int[2];
        HashMap<Character, Integer> guessMap = new HashMap<>();
        HashMap<Character, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            if (guessMap.containsKey(guess.charAt(i))) guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i)) + 1);
            else guessMap.put(guess.charAt(i), 1);
            if (answerMap.containsKey(answer.charAt(i))) answerMap.put(answer.charAt(i), answerMap.get(answer.charAt(i)) + 1);
            else answerMap.put(answer.charAt(i), 1);
        }
        for (char c : guessMap.keySet()) {
            if (answerMap.containsKey(c)) {
                if (guessMap.get(c) > answerMap.get(c)) result[0] += answerMap.get(c);
                else result[0] += guessMap.get(c);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == answer.charAt(i)) result[1]++;
        }
        return result;
    }
}