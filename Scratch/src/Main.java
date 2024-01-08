public class Main {
    public static void main(String[] args) {
        System.out.print(d( 2, 8));
    }

    public static double d(int x, int m) {
        System.out.println("In power " + x + " : " + m);
        if (m == 0) return 1.0;
        else if (m % 2 != 0) return x * Math.pow(d(x, m / 2), 2);
        else return Math.pow(d(x, m / 2), 2);
    }
}