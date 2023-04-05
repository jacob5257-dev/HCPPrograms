/**
 * This class compares three numbers and returns the largest, middle, and smallest.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see ThreeNumbers
 * @see ThreeNumbersTest
 */

public class ThreeNumbers {
    // Variables of the three numbers.
    private final double a;
    private final double b;
    private final double c;

    /**
     * This method creates a ThreeNumbers object.
     * @param a The first number.
     * @param b The second number.
     * @param c The third number.
     */
    public ThreeNumbers(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * This method returns the largest number.
     * @return The largest number.
     */
    public double getLargest() {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }
    /**
     * This method returns the middle number.
     * @return The middle number.
     */
    /*
    public double getMiddle() {
        if (a > b && a < c) {
            return a;
        } else if (b > a && b < c) {
            return b;
        } else {
            return c;
        }
    }
    */

    public double getMiddle() {
        double sum = a + b + c;
        return sum - getLargest() - getSmallest();
    }
    /**
     * This method returns the smallest number.
     * @return The smallest number.
     */
    public double getSmallest() {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }
}
