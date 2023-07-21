import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SolarBitflipSort {
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
        System.out.println("The list you gave me (" + intArray + ") is currently stored in memory. The alpha particles from the sun will flip a bit in memory once in a while. Check back later to see if your list has been sorted.");
        while (!BogoSort.isSorted(intArray)) {
            System.out.println("The list is not sorted. Waiting for a bit flip...");
            System.out.println("The list is now: " + intArray);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
