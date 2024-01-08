//skipcq: JAVA-W1062
public class RoachPopulationTest {
    public static void main(String[] args) {
        // Create a roach population
        RoachPopulation roaches = new RoachPopulation(10);
        System.out.println("The number of roaches is " + roaches.getRoaches());
        // Wait for the roaches to double
        roaches.waitForDoubling();
        System.out.println("The number of roaches is " + roaches.getRoaches());
        // Spray the roaches
        roaches.spray();
        // Print the number of roaches
        System.out.println("The number of roaches is " + roaches.getRoaches());
    }
}
