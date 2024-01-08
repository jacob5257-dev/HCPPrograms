// Imports the java.util.Random and java.util.Scanner classes for use in this program.
import java.util.Random;
import java.util.Scanner;

/**
 * This program tests the randomness of the Random class by generating a specified number of random numbers
 * and printing the number of times each number was generated and the proportion of each number generated.
 * It is designed to check the randomness of the Random class.
 * @see ArrayUnitTest
 * @since 2023-03-09
 * @version 1.0
 * @author jacob5257
 */
//skipcq: JAVA-W1088
public class ArrayUnitTest {
    /**
     * @see ArrayUnitTest
     * @param args Command line arguments (unused)
     * @throws IllegalArgumentException If the user inputs invalid input
     */
    public static void main(String[] args) {
        // Creates a scanner and gets user input for the number of numbers and number of elements
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers do you want to generate: ");
        String input = scanner.nextLine();
        System.out.print("Number of array elements: ");
        String arrayElements = scanner.nextLine();
        // Converts them to integers. If it fails, it throws an exception.
        int numbers;
        int elements;
        try {
            numbers = Integer.parseInt(input);
            elements = Integer.parseInt(arrayElements);
        }
        catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException("Invalid input provided! Try putting in positive whole numbers for the values above.");
        }
        // Checks if both numbers are positive. If not, it throws an exception.
        if (numbers <= 0 || elements <= 0) {
            scanner.close();
            throw new IllegalArgumentException("Positive whole numbers please!");
        }
        // Creates a list to hold the calls for each number
        int[] numberOfCalls = new int[elements];
        // Generates the numbers and adds 1 every time that element is called
        for (int i = 0; i < numbers; i++) {
            Random random = new Random();
            numberOfCalls[random.nextInt(elements)]++;
        }
        // Prints out the results
        for (int i = 0; i < elements; i++) {
            System.out.println(i + " was called " + numberOfCalls[i] + " times (" + (numberOfCalls[i] * 1.0 / numbers * 100.0) + "%).");
        }
        // Closes the scanner cause resources idk
        scanner.close();
    }
}
