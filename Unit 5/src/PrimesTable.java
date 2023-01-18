/**
 * A class that generates a table of prime numbers.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see PrimesTable
 * @see PrimesTableTest
 */

public class PrimesTable {
    private int a;
    /**
     * This method generates a table of prime numbers.
     * @param a The number to generate the table from.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see PrimesTable
     * @see PrimesTableTest
     */
    public PrimesTable(int a) {
        this.a = a;
    }

    /**
     * This method returns the next prime number after a.
     * @return The next prime number after a.
     */
    public int nextPrime() {
        while (true) {
            a++;
            if (isPrime()) return a;
        }
    }

    /**
     * This method checks if a is prime.
     * @return Whether or not a is prime.
     */
    public boolean isPrime() {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}
