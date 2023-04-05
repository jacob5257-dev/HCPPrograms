/**
 * A class that represents a quadratic equation.
 * @author jacob5257
 * @version 1.0
 * @since 2023-02-07
 * @see QuadraticTest
 */

public class Quadratic {
    // Creates some basic variables
    private double discriminant;
    private double root1;
    private double root2;

    /**
     * The constructor for the quadratic equation.
     * @param a The coefficient of x^2.
     * @param b The coefficient of x.
     * @param c The constant.
     */
    public Quadratic(double a, double b, double c) {
        discriminant = b * b - 4 * a * c;
        root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
    }

    /**
     * Gets the one of the two roots.
     * @return The root.
     */
    public double getRoot1() {
        return root1;
    }

    /**
     * Gets the other of the two roots.
     * @return The root.
     */
    public double getRoot2() {
        return root2;
    }

    /**
     * Checks if the roots are equal.
     * @return True if the roots are equal, false otherwise.
     */
    public boolean hasEqualRoots() {
        return discriminant == 0;
    }

    /**
     * Checks if the equation has solutions.
     * @return True if the equation has solutions, false otherwise.
     */
    public boolean hasSolutions() {
        return !(discriminant < 0 || Double.isNaN(discriminant));
    }

}
