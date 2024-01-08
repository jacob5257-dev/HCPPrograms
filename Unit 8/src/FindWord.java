import javax.swing.*;

/**
 * Finds a word inside a word
 * @author jacob5257
 */
public class FindWord {
    /**
     * Find a substring in a bigger string. O(n)
     * @param s The full string
     * @param target The substring to search
     * @return Whether or not target was found in s
     * @author jacob5257
     */
    public static boolean findWord(String s, String target) {
        if (s.length() < target.length()) return false;
        if (s.startsWith(target)) return true;
        return findWord(s.substring(1), target);
    }

    /**
     * Main method
     * @param args cmd line
     * @author jacob5257
     */
    public static void main(String[] args) {
        System.out.println(findWord(JOptionPane.showInputDialog("Word? "), JOptionPane.showInputDialog("Substring? "))? "found" : "not found");
    }
}
