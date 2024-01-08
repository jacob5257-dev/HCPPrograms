public class Reverse {
    public static String reverse(String s) {
        if (s.isEmpty()) return "";
        else if (s.length() == 1) return s;
        else return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello world!"));
    }
}
