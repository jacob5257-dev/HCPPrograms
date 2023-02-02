/**
 * This method creates a soda can and returns some useful info.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see SodaCan
 * @see SodaCanTest
 */

public class SodaCan {
    /**
     * This method creates a soda can.
     * @param radius The radius of the soda can.
     * @param height The height of the soda can.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see SodaCan
     * @see SodaCanTest
     */
    public SodaCan(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    // Variables of the soda can.
    private double radius = 1.0;
    private double height = 1.0;
    /**
     * This method returns the surface area of the soda can.
     * @return The surface area of the soda can.
     */
    public double getSurfaceArea() {
        return 2 * Math.PI * this.radius * this.height + 2 * Math.PI * Math.pow(radius, 2);
    }
    /**
     * This method returns the volume of the soda can.
     * @return The volume of the soda can.
     */
    public double getVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
