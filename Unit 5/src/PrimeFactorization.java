/**
 * This class factors a number into its prime factors.
 * @since 2023-01-18
 * @version 1.0
 * @author jacob5257
 * @see PrimeFactorization
 * @see PrimeFactorizationTest
 */

public class PrimeFactorization {
    private int a;

    /**
     * This method factors a number into its prime factors.
     * @param a The number to prime factorize.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see PrimeFactorization
     * @see PrimeFactorizationTest
     */
    public PrimeFactorization(int a) {
        this.a = a;
    }
    /**
     * This method returns the next prime factor of the number.
     * @return The next prime factor of the number.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see PrimeFactorization
     * @see PrimeFactorizationTest
     */
    public int nextFactor() {
        // Goes through all numbers up to the number and checks if it's a factor. If it is, return that factor. Otherwise, return 0.
        int factor = 2;
        for (int i = factor; i <= a; i++) {
            if (a % i == 0) {
                a /= i;
                return i;
            }
        }
        return 0;
    }
    /**
     * This method checks if the number has more factors.
     * @return Whether or not the number has more factors.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see PrimeFactorization
     * @see PrimeFactorizationTest
     */
    public boolean hasMoreFactors() {
        // Goes through all numbers up to the number and checks if it's a factor. If it is, return true. Otherwise, return false.
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) return true;
        }
        return false;
    }

}
