/**
 * A class that does things to a pair of numbers.
 * @author jacob5257
 * @since 2023-01-18
 * @version 1.0
 * @see PairOfNumbers
 * @see PairOfNumbersTest
 */

public class PairOfNumbers {
    /**
     * This constructor creates a pair of numbers.
     * @param a The first number.
     * @param b The second number.
     */
    public PairOfNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    // The numbers and the functions. Don't ask for javadocs for all the functions; they're self explanatory!
    private int a;
    private int b;

    public int sum() {
        return a + b;
    }

    public int difference() {
        return a - b;
    }

    public int product() {
        return a * b;
    }

    public double quotient() {
        return (double) a / b;
    }

    public int average() {
        return (a + b) / 2;
    }

    public int distance() {
        return Math.abs(a - b);
    }

    public int max() {
        return Math.max(a, b);
    }

    public int min() {
        return Math.min(a, b);
    }
}
