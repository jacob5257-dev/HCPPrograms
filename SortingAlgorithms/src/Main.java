import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 4, 3, 2, 5})));
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 4, 3, 2, 5})));
        System.out.println(Arrays.toString(selectionSort(new int[]{5, 4, 3, 2, 5})));
    }

    /**
     * Sorts an array using bubble sort.
     * @param arr The array to sort.
     * @return The sorted array.
     */
    public static int[] bubbleSort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }

    /**
     * Sorts an array using insertion sort.
     * @param arr The array to sort.
     * @return The sorted array.
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Sorts an array using selection sort.
     * @param arr The array to sort.
     * @return The sorted array.
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // i = the position where the lowest element should be
            int lowest = arr[i];
            int lowestPosition = i;
            // Traverse the array from element i to the end, and save the position of the lowest element
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < lowest) {
                    lowest = arr[j];
                    lowestPosition = j;
                }
            }
            // Swap the lowest element with the element at position i
            int temp = arr[i];
            arr[i] = arr[lowestPosition];
            arr[lowestPosition] = temp;
        }
        return arr;
    }
}