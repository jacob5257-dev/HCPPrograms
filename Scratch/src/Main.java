public class Main {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 9, 12};
        for (int number : numbers) {
            System.out.println(pert(12, 0.5, number));
        }
    }

    public static double zScore(int x, double mean, double stdDev) {
        return (x - mean) / stdDev;
    }

    public static double pert(double p, double r, double t) {
        return p * Math.exp(r * t);
    }


}