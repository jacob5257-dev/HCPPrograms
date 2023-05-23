// Allows user input from the terminal
import java.util.Scanner;

/**
 *
 * This class lets the user define a 2D array's width and height and then fills it with random numbers.
 * It then prints the array, the sum of each row, and the number of even and odd numbers.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see UserDefined2DArray
 *
 */
public class UserDefined2DArray {
    /**
     * This method creates a 2D array with user defined width and height and fills it with random numbers.
     * @param args The command line arguments (not used).
     * @since 2023-01-18
     * @version 1.0
     * @see UserDefined2DArray
     * @author jacob5257
     */
    public static void main(String[] args) {
        // Gets the number of rows and columns from the terminal.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        // Creates an array with the number of rows and columns, and adds some counters.
        int[][] array = new int[rows][columns];
        int sum = 0;
        int even = 0;
        int odd = 0;
        // Fills the array with random numbers
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // Sets the value of the 2D array
                array[i][j] = (int) (Math.random() * 100);
                // Prints it out
                System.out.printf("%3d", array[i][j]);
                // Add its sum to the sum counter
                sum += array[i][j];
                // Add one to either the even or odd counter, depending on if the number is even or odd.
                if (array[i][j] % 2 == 0) {
                    even++;
                }
                else {
                    odd++;
                }
            }
            // After a row, it prints out the sum counter and resets it for the next row.
            System.out.printf("  Sum: %4d", sum);
            sum = 0;
            System.out.println();
        }
        // Prints out the final number of even and odd numbers in the whole array.
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        // Closes the scanner cause resources idk
        scanner.close();
        
    }
}
