import javax.swing.*;
import java.util.*;

public class BogoSort {
    public static void main(String[] args) {
        // Ask the user for an unsorted list of integers
        String input = JOptionPane.showInputDialog("Enter a list of integers separated by spaces:");
        // Split the input into an array of strings
        String[] inputArray = input.split(" ");
        // Create an array of integers with the same length as the input array
        List<Integer> intArray = new ArrayList<Integer>();
        // Convert each string in the input array to an integer and add it to the integer array
        for (String s : inputArray) {
            intArray.add(Integer.parseInt(s));
        }
        int count = 0;
        while (!isSorted(intArray)) {
            //System.out.println("The list is not sorted. Shuffling...");
            //System.out.println("The list is now: " + intArray);
            count++;
            Collections.shuffle(intArray);
        }
        System.out.println("The sorted list after " + count + " shuffles is: " + intArray);
    }

    public static boolean isSorted(List<Integer> startingList) {
        for (int i = 1; i < startingList.size(); i++) {
            if (startingList.get(i) < startingList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
