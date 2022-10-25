public class SodaCan {
    public static double getSurfaceArea(double radius, double height) {
        return 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
    }

    public static double getVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
