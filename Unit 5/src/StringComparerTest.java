import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class tests the StringComparer class.
 * @author jacob5257
 * @since 2023-02-14
 * @version 1.0
 * @see StringComparer
 */
//skipcq: JAVA-W1062
public class StringComparerTest {
    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Set up the StringComparer object with an empty list.
        StringComparer comparer = new StringComparer(new ArrayList<String>());
        // Use the console to get input from the user, split it by spaces, and use comparer.addString() to add each word to the list.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        // Splits the input by spaces and adds each word to the list.
        String[] words = sentence.split(" ");
        for (String word : words) {
            comparer.addString(word);
        }
        // Prints the longest and shortest strings.
        System.out.println("The longest word is " + comparer.getLongest());
        System.out.println("The shortest word is " + comparer.getShortest());
        scanner.close();
    }
}
