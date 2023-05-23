// Imports necessary classes
import java.util.Arrays;
import java.util.Random;

/**
 * Generates an array of 10 random integers, sorts it, and prints the sum, min, max, and median.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class RandomArray {
    /**
     * Generates an array of 10 random integers, sorts it, and prints the sum, min, max, and median.
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Creates a variable of the Random class
        Random random = new Random();
        // Creates an array and fills it with 10 random numbers
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
        }
        // Print the original array
        System.out.println(Arrays.toString(array));
        // Sort the array and print from smallest to biggest
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        // Reverse the order of the array and print from biggest to smallest
        int[] reverse = new int[10];
        for (int i = 0; i < 10; i++) {
            reverse[i] = array[9 - i];
        }
        System.out.println(Arrays.toString(reverse));
        // Calculates the sum, min, max, and median of the array and prints it.
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += array[i];
        }
        int min = array[0];
        int max = reverse[0];
        double median = (array[4] + array[5]) / 2.0;
        System.out.println("Sum: " + sum + ", min: " + min + ", max: " + max + ", median: " + median);
    }
}
