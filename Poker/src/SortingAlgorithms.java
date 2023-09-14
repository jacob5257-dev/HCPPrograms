public class SortingAlgorithms {
    // Copied from SortingAlgorithms/src/Main.java

    /**
     * Sorts an array using bubble sort.
     *
     * @param arr The array to sort.
     */
    public static void bubbleSort(int[] arr) {
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
    }
}