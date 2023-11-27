/**
 * This program tests the PrimesTable class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see PrimesTable
 * @see PrimesTableTest
 */
public class PrimesTableTest {
    /**
     * This method tests the PrimesTable class.
     * @param args The command line arguments (not used).
     * @since 2023-01-18
     * @author jacob5257
     * @see PrimesTable
     * @see PrimesTableTest
     */
    public static void main(String[] args) {
        // Create a table of primes starting at 1.
        PrimesTable pt = new PrimesTable(1);
        int[] primes = new int[100];
        // Fill the array with the first 100 primes.
        for (int i = 0; i < primes.length; i++) {
            primes[i] = pt.nextPrime();
        }
        int counter = 0;
        // Print the array, formatted with printf.
        for (int prime : primes) {
            System.out.printf("%5d", prime);
            counter++;
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
        }
        
    }
    
}
