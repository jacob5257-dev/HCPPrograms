public class SodaCan {
    public SodaCan(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    private double radius;
    private double height;
 
    public double getSurfaceArea() {
        return 2 * Math.PI * this.radius * this.height + 2 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
