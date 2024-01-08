// Imports java.util.List and java.util.ArrayList for use in this program.
import java.util.List;
import java.util.Scanner;

/**
 * This program tests the DieRoll class by creating a DieRoll object and
 * printing the rolls and the proportion of each number rolled.
 * It is designed to check the randomness of the Math.random() method.
 * @author jacob5257
 * @version 1.0
 * @since 2023-03-09
 */
//skipcq: JAVA-W1062
public class DieRollTest {
    /**
     * @see DieRollTest
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Asks the user for the number of rolls/tests to make
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rolls? ");
        int numRolls = scanner.nextInt();
        // Creates an instance of DieRoll that contains the number of rolls
        DieRoll dieRoll = new DieRoll(numRolls);
        // Prints the rolls from the dieRoll variable
        List<Integer> rolls = dieRoll.getRolls();
        System.out.println("Rolls: " + rolls);
        // Counts the number of each number rolled and prints the proportion of each number rolled
        int[] counts = new int[6];
        for (int roll : rolls) {
            counts[roll - 1]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("Proportion of " + (i + 1) + "s: " + (double) counts[i] / rolls.size() * 100.0 + "%");
        }
        // Closes the scanner cause resources idk
        scanner.close();
    }
}
