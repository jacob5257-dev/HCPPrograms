import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Ask the user for an unsorted list of integers
        String input = JOptionPane.showInputDialog("Enter a list of integers separated by spaces:");
        // Split the input into an array of strings
        String[] inputArray = input.split(" ");
        // Create an array of integers with the same length as the input array
        int[] intArray = new int[inputArray.length];
        // Convert each string in the input array to an integer and add it to the integer array
        for (int i = 0; i < inputArray.length; i++) {
            intArray[i] = Integer.parseInt(inputArray[i]);
        }
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                System.out.println("Element " + intArray[i] + " at index " + i + " has been sent to gulag.");
                intArray[i] = 0;
            }
        }
        int finalListCount = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                finalListCount++;
            }
        }
        int[] finalList = new int[finalListCount];
        // Move all elements that are not 0 from intArray to finalList
        int finalListIndex = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                finalList[finalListIndex] = intArray[i];
                finalListIndex++;
            }
        }
        System.out.println("The sorted list is: " + Arrays.toString(finalList));
    }
}