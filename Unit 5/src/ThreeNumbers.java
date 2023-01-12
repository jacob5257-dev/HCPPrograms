public class ThreeNumbers {
    private final double a;
    private final double b;
    private final double c;

    public ThreeNumbers(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getLargest() {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public double getMiddle() {
        if (a > b && a < c) {
            return a;
        } else if (b > a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public double getSmallest() {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }
}
