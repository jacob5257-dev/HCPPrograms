import javax.swing.*;

/**
 * Counts down numbers and prints them
 * @author jacob5257
 */
public class Countdown {
    /**
     * Return strings with numbers starting at n and ending with 0, inclusive
     * @param n The number to start at
     * @return The string representation of all number between n and 0, decreasing, inclusive
     * @author jacob5257
     */
    public static String countdown(int n) {
        // the ternary way
        return (n < 0) ? "" : n + " " + countdown(n - 1);
        // the if way
        // if the number is already less than 0, nothing to count
        // uncomment this line if (n < 0) return "";
        // return the current number and call countdown on 1 less than current number
        // uncomment this line else return n + " " + countdown(n - 1);
    }

    /**
     * The main method
     * @param args cmd line
     * @author jacob5257
     */
    public static void main(String[] args) {
        // test the countdown
        System.out.println(countdown(Integer.parseInt(JOptionPane.showInputDialog("Number? "))));
    }
}
