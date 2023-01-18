import javax.swing.JOptionPane;
/**
 * This class tests the Magic8Ball class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see Magic8Ball
 * @see Magic8BallTest
 */
public class Magic8BallTest {
    /**
     * This method tests the Magic8Ball class.
     * @param args The command line arguments (not used).
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Magic8Ball
     * @see Magic8BallTest
     */
    public static void main(String[] args) {
        // Create a new Magic8Ball object and ask the user for input.
        Magic8Ball ball = new Magic8Ball();
        JOptionPane.showMessageDialog(null, "Welcome to the Magic 8 Ball!");
        while (true) {
            // Asks the user a question every time they don't click cancel.
            String input = JOptionPane.showInputDialog("Ask a yes or no question (Cancel to exit)");
            if (input == null) System.exit(0);
            JOptionPane.showMessageDialog(null, ball.getResponse());
            int playAgain = JOptionPane.showConfirmDialog(null, "Ask another question?", "Ask another question?", JOptionPane.YES_NO_OPTION);
            if (playAgain == JOptionPane.NO_OPTION) System.exit(0);
        }
    }
}
