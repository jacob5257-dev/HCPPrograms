import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class tests the LeapYear class.
 * @author jacob5257
 * @since 2023-02-14
 * @version 1.0
 * @see LeapYear
 */
public class LeapYearTest {
    public static void main(String[] args) throws FileNotFoundException {
        // Read the first five years from dates.dat and use the LeapYear class to determine if it is a leap year.
        // Then, print the result
        FileReader reader = new FileReader("Unit 5/src/dates.dat");
        Scanner scanner = new Scanner(reader);
        for (int i = 0; i < 5; i++) {
            int year = scanner.nextInt();
            LeapYear leapYear = new LeapYear(year);
            System.out.println(leapYear);
        }
        scanner.close();
    }
}
