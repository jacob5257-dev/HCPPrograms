public class Main {
    // Automated my math hw lol
    /*
    public static void main(String[] args) {
        System.out.println(math3(5.0, Math.sqrt(5.0)));
    }

    public static double math(double start, double end) {
        double a1 = -1.0 * start * start;
        double a2 = 18.0 * start;
        double a3 = -65.0;
        double b1 = -1.0 * end * end;
        double b2 = 18.0 * end;
        double b3 = -65.0;
        return (b1 + b2 + b3 - a1 - a2 - a3) / (end - start);
    }

    public static double math2(double x) {
        return 0.04 * (8 * x - x * x);
    }

    public static double math3(double qx, double qy) {
        double px = 4.0;
        double py = 2.0;
        if (px > qx) {
            return (py - qy) / (px - qx);
        }
        return (qy - py) / (qx - px);
    }
     */

    public static void main(String[] args) {
        System.out.println(prefixAgain("abXYabc", 1));
        System.out.println(prefixAgain("abXYabc", 2));
    }

    public static boolean prefixAgain(String str, int n) {
        String substring = str.substring(0, n);
        for (int i = 0; i < str.length() - substring.length() - 1; i++) {
            String abc = str.substring(n + i - 1, n + i + substring.length());
            if (abc.equals(substring)) return true;
        }
        return false;
    }

}