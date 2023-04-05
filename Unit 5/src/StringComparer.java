import java.util.List;

/**
 * This class compares the length of strings.
 * @author jacob5257
 * @since 2023-02-14
 * @version 1.0
 */
public class StringComparer {
    // Instance variables holding the list of strings and the longest and shortest strings.
    private List<String> list;
    private String longest;
    private String shortest;

    /**
     * Constructor that takes a list of strings as a parameter.
     * @param list The list of strings.
     */
    public StringComparer(List<String> list) {
        this.list = list;
    }

    /**
     * Adds a string to the list.
     * @param string The string to add.
     */
    public void addString(String string) {
        list.add(string);
    }

    /**
     * Returns the longest string in the list.
     * @return The longest string in the list.
     */
    public String getLongest() {
        // If the list is empty, return null.
        if (list.size() == 0) {
            return null;
        }
        // Set the longest string to the first string in the list and changing it when a longer string is found.
        longest = list.get(0);
        for (String string : list) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        return longest;
    }

    /**
     * Returns the shortest string in the list.
     * @return The shortest string in the list.
     */
    public String getShortest() {
        // If the list is empty, return null.
        if (list.size() == 0) {
            return null;
        }
        // Set the shortest string to the first string in the list and changing it when a shorter string is found.
        shortest = list.get(0);
        for (String string : list) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
        }
        return shortest;
    }
}