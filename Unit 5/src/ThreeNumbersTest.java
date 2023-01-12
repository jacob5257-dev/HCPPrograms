import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ThreeNumbersTest {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("Unit 5/src/numbers.dat");
        Scanner file = new Scanner(reader);
        while (file.hasNext()) {
            ThreeNumbers numbers = new ThreeNumbers(file.nextDouble(), file.nextDouble(), file.nextDouble());
            //Get numbers.getSmallest(), numbers.getMiddle(), and numbers.getLargest() and print them out, formatted with printf so they are aligned.
            System.out.printf("%10.2f%10.2f%10.2f\n", numbers.getSmallest(), numbers.getMiddle(), numbers.getLargest());
        }
        file.close();
    }    
}
