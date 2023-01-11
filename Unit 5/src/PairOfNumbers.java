public class PairOfNumbers {
    public PairOfNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    private int a;
    private int b;

    public int sum() {
        return a + b;
    }

    public int difference() {
        return a - b;
    }

    public int product() {
        return a * b;
    }

    public double quotient() {
        return (double) a / b;
    }

    public double average() {
        return (a + b) / 2.0;
    }

    public int distance() {
        return Math.abs(a - b);
    }

    public int max() {
        return Math.max(a, b);
    }

    public int min() {
        return Math.min(a, b);
    }
}
