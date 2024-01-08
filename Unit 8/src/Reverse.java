/**
 * Reverses a string
 * @author jacob5257
 */
public class Reverse {
    /**
     * Reverses the input string. O(n)
     * @param s The string to reverse
     * @return The reversed string
     * @author jacob5257
     */
    public static String reverse(String s) {
        // if string is empty or has one char, return the string
        if (s.isEmpty()) return "";
        else if (s.length() == 1) return s;
        // otherwise return the remaining string with the first char at the end
        else return reverse(s.substring(1)) + s.charAt(0);
    }

    /**
     * The main method
     * @param args cmd line
     * @author jacob5257
     */
    public static void main(String[] args) {
        // Tests
        System.out.println(reverse("Hello world!"));
    }
}
