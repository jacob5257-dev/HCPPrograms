import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 * Sorts a list and sends numbers out of order to gulag.
 * O(n)
 */
public class StalinSort {
    public static void main(String[] args) {
        // Ask the user for an unsorted list of integers
        String input = JOptionPane.showInputDialog("Enter a list of integers separated by spaces:");
        // Split the input into an array of strings
        String[] inputArray = input.split(" ");
        // Create an array of integers with the same length as the input array
        int[] intArray = new int[inputArray.length];
        // Convert each string in the input array to an integer and add it to the integer array
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("0")) {
                System.out.println("No zeroes in the list.");
                System.exit(0);
            }
            intArray[i] = Integer.parseInt(inputArray[i]);
        }
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                System.out.println("Element " + intArray[i] + " at index " + i + " has been sent to gulag.");
                intArray[i] = 0;
            }
        }
        int finalListCount = 0;
        for (int j : intArray) {
            if (j != 0) {
                finalListCount++;
            }
        }
        int[] finalList = new int[finalListCount];
        // Move all elements that are not 0 from intArray to finalList
        int finalListIndex = 0;
        for (int j : intArray) {
            if (j != 0) {
                finalList[finalListIndex] = j;
                finalListIndex++;
            }
        }
        System.out.println("The sorted list is: " + Arrays.toString(finalList));
    }
}