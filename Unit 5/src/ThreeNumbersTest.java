import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class tests the ThreeNumbers class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see ThreeNumbers
 * @see ThreeNumbersTest
 */
public class ThreeNumbersTest {
    /**
     * This method tests the ThreeNumbers class.
     * @param args The command line arguments (not used).
     * @throws FileNotFoundException If the file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Gets files and starts a scanner on the file.
        FileReader reader = new FileReader("Unit 5/src/numbers.dat");
        Scanner file = new Scanner(reader);
        // While the file has a next line, create a new ThreeNumbers object and print out the smallest, middle, and largest numbers.
        while (file.hasNext()) {
            double a = file.nextDouble(),
                   b = file.nextDouble(),
                   c = file.nextDouble();
            ThreeNumbers numbers = new ThreeNumbers(a, b, c);
            //Get numbers.getSmallest(), numbers.getMiddle(), and numbers.getLargest() and print them out, formatted with printf, so they are aligned.
            System.out.printf("%10.2f%10.2f%10.2f\n", numbers.getSmallest(), numbers.getMiddle(), numbers.getLargest());
        }
        file.close();
    }    
}
