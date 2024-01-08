/**
 * Wrapper code for other classes since that was the requirement :(
 * Methods in other files are usable without this class
 * @author jacob5257
 */
public class Sentence {
    // Holds the string to perform operations on
    private String s;

    /**
     * Default constructor
     * @author jacob5257
     */
    public Sentence() {
        this.s = "";
    }

    /**
     * Constructor with string
     * @param s The string
     * @author jacob5257
     */
    public Sentence(String s) {
        this.s = s;
    }

    /**
     * Finds a word in the string
     * @param target The word to find
     * @return Whether the word was found
     * @author jacob5257
     */
    public boolean find(String target) {
        return FindWord.findWord(s, target);
    }

    /**
     * Reverses the string
     * @author jacob5257
     */
    public void reverse() {
        this.s = Reverse.reverse(s);
    }

    /**
     * Returns the string
     * @return The string
     * @author jacob5257
     */
    @Override
    public String toString() {
        return s;
    }

    /**
     * Returns the string
     * @return The string
     * @author jacob5257
     */
    public String getText() {
        return s;
    }

    /**
     * Main method
     * @param args cmd line
     * @author jacob5257
     */
    public static void main(String[] args) {
        // Test code from the assignment
        Sentence greeting = new Sentence("Hello!");
        greeting.reverse();
        System.out.println(greeting.getText());
        Sentence s = new Sentence("Mississippi!");
        boolean b = s.find("sip");
        System.out.println(b);
    }
}
