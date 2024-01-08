public class Countdown {
    public static String countdown(int n) {
        if (n < 0) return "";
        else return n + " " + countdown(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(countdown(5));
    }
}
