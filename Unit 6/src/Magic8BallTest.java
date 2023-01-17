import javax.swing.JOptionPane;

public class Magic8BallTest {
    public static void main(String[] args) {
        Magic8Ball ball = new Magic8Ball();
        JOptionPane.showMessageDialog(null, "Welcome to the Magic 8 Ball!");
        while (true) {
            String input = JOptionPane.showInputDialog("Ask a yes or no question (Cancel to exit)");
            if (input == null) System.exit(0);
            JOptionPane.showMessageDialog(null, ball.getResponse());
            int playAgain = JOptionPane.showConfirmDialog(null, "Ask another question?", "Ask another question?", JOptionPane.YES_NO_OPTION);
            if (playAgain == JOptionPane.NO_OPTION) System.exit(0);
        }
    }
}
