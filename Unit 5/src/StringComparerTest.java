import java.util.ArrayList;
import java.util.Scanner;

public class StringComparerTest {
    public static void main(String[] args) {
        StringComparer comparer = new StringComparer(new ArrayList<String>());
        // Use the console to get input from the user, split it by spaces, and use comparer.addString() to add each word to the list.
        // Then, print the longest and shortest words.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        for (String word : words) {
            comparer.addString(word);
        }
        System.out.println("The longest word is " + comparer.getLongest());
        System.out.println("The shortest word is " + comparer.getShortest());
        scanner.close();
    }
}
