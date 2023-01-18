/**
 * A class to test the PairOfNumbers class.
 * @author jacob5257
 * @since 2023-01-18
 * @version 1.0
 * @see PairOfNumbers
 * @see PairOfNumbersTest
 */

public class PairOfNumbersTest {
    /**
     * This method tests the PairOfNumbers class.
     * @since 2023-01-18
     * @param args The command line arguments (not used).
     * @version 1.0
     * @author jacob5257
     * @see PairOfNumbers
     * @see PairOfNumbersTest
     */
    public static void main(String[] args) {
        //Create a pair of numbers and print all the method calls.
        PairOfNumbers pair = new PairOfNumbers(5, 10);
        System.out.println("Sum: " + pair.sum());
        System.out.println("Difference: " + pair.difference());
        System.out.println("Product: " + pair.product());
        System.out.println("Average: " + pair.average());
        System.out.println("Distance: " + pair.distance());
        System.out.println("Maximum: " + pair.max());
        System.out.println("Minimum: " + pair.min());
    }
}
