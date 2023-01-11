import java.util.Scanner;

public class SodaCanTest {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in);
            System.out.print("Radius: ");
            double radius = myObj.nextDouble();
            System.out.print("Height: ");
            double height = myObj.nextDouble();
            SodaCan sodaCan = new SodaCan(radius, height);

            System.out.println("Surface area: " + sodaCan.getSurfaceArea());
            System.out.println("Volume: " + sodaCan.getVolume());
            myObj.close();
        }
        catch (Exception e) {
            throw new RuntimeException("Are you sure those are valid numbers?");
        }
    }
}
