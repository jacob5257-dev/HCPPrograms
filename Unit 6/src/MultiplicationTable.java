/**
 * Makes a multiplication table.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class MultiplicationTable {
    /**
     * Makes a multiplication table.
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Creates a 12 * 12 array to house our multiplication table
        int[][] table = new int[12][12];
        // Fills each value with the appropriate value of the multiplication table
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        // Goes through each array in the 2D array
        for (int[] ints : table) {
            // Goes through each element in the array and prints it formatted with printf
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }
}
