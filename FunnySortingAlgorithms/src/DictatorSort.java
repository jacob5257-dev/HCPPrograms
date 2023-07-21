import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DictatorSort {
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
        System.out.println("The list you gave me (" + intArray + ") is already in order. If you disagree, I will find you and you may or may not mysteriously disappear for the rest of your life.");
    }

}
