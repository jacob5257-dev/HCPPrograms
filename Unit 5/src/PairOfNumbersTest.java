public class PairOfNumbersTest {
    public static void main(String[] args) {
        PairOfNumbers pair = new PairOfNumbers(5, 10);
        System.out.println("Sum: " + pair.sum());
        System.out.println("Difference: " + pair.difference());
        //Print the product, average, distance, maximum, and minimum of the pair.
        System.out.println("Product: " + pair.product());
        System.out.println("Average: " + pair.average());
        System.out.println("Distance: " + pair.distance());
        System.out.println("Maximum: " + pair.max());
        System.out.println("Minimum: " + pair.min());
    }
}
