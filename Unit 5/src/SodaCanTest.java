import java.util.Scanner;

/**
 * This class tests the SodaCan class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see SodaCan
 * @see SodaCanTest
 */
public class SodaCanTest {
    /**
     * This method tests the SodaCan class.
     * @param args The command line arguments (not used).
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see SodaCan
     * @see SodaCanTest
     */
    public static void main(String[] args) {
        try {  
            // Create a scanner object and saved them in their respective variables.
            Scanner myObj = new Scanner(System.in);
            System.out.print("Radius: ");
            double radius = myObj.nextDouble();
            System.out.print("Height: ");
            double height = myObj.nextDouble();
            // Create a new soda can object and prints its properties.
            SodaCan sodaCan = new SodaCan(radius, height);
            System.out.println("Surface area: " + sodaCan.getSurfaceArea());
            System.out.println("Volume: " + sodaCan.getVolume());
            myObj.close();
        }
        // Catches invalid input.
        catch (Exception e) {
            throw new RuntimeException("Are you sure those are valid numbers?");
        }
    }
}
