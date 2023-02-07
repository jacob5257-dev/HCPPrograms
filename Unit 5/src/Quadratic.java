public class Quadratic {
    private double discriminant;
    private double root1;
    private double root2;

    public Quadratic(double a, double b, double c) {
        discriminant = b * b - 4 * a * c;
        root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
    }

    public double getRoot1() {
        return root1;
    }

    public double getRoot2() {
        return root2;
    }

    public boolean hasEqualRoots() {
        return discriminant == 0;
    }

    public boolean hasSolutions() {
        return !(discriminant < 0 || Double.isNaN(discriminant));
    }

}
