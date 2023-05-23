// Imports Random for randomizing the order and javax.swing.* for the GUI
import java.util.Random;
import javax.swing.*;

/**
 * Generates a multiple choice quiz with 3 questions and 3 answers each, randomizes the order of the answers, and checks if the user's answer is correct.
 * If the user closes the quiz, the quiz will be reset.
 * If the user gets a question wrong, the correct answer will be displayed.
 * At the end, the user's score will be displayed.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class MultipleChoiceQuiz {
    /**
     * Generates a multiple choice quiz with 3 questions and 3 answers each, randomizes the order of the answers, and checks if the user's answer is correct.
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Creates the appropriate arrays with the questions, answer choices, and correct answers
        String[] questions = {"What is 1 + 1?", "What is 2 + 2?", "What is 3 * 3?"};
        String[][] answers = {{"1", "2", "3"}, {"4", "5", "6"}, {"6", "8", "9"}};
        String[] correct = {"2", "4", "9"};
        // Randomizer function
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int pos1 = random.nextInt(3);
            int pos2 = random.nextInt(3);
            while (pos1 == pos2) {
                pos1 = random.nextInt(3);
                pos2 = random.nextInt(3);
            }
            String temp = answers[i][pos1];
            String temp2 = answers[i][pos2];
            answers[i][pos2] = temp;
            answers[i][pos1] = temp2;
            pos1 = random.nextInt(3);
            pos2 = random.nextInt(3);
            while (pos1 == pos2) {
                pos1 = random.nextInt(3);
                pos2 = random.nextInt(3);
            }
            temp = answers[i][pos1];
            temp2 = answers[i][pos2];
            answers[i][pos2] = temp;
            answers[i][pos1] = temp2;
        }
        // Goes through each question and keeps track of score
        int score = 0;
        for (int i = 0; i < 3; i++) {
            // Creates the question panel and displays it
            Object[] options = answers[i];
            JPanel panel = new JPanel();
            panel.add(new JLabel("<html>Question:<br>" + questions[i] +"</html>"));
            int selection = ( JOptionPane.showOptionDialog(null, panel, "Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
            // Checks if they closed it
            if (selection < 0 || selection > 2) {
            	JOptionPane.showMessageDialog(null, "Don't close the quiz! Your quiz will be reset.");
            	score = 0;
                // i set to -1 here since when the loop ends it will add 1 to i, making it 0 again
            	i = -1;
            }
            // Checks if they got it right
            else if (answers[i][selection].equals(correct[i])) {
                JOptionPane.showMessageDialog(null, "Correct!");
                score++;
            }
            // If they got it wrong, it will display the correct answer
            else {
                JOptionPane.showMessageDialog(null, "Incorrect! The correct answer is " + correct[i]);
            }
        }
        // Displays their final score as a fraction and a percentage.
        JOptionPane.showMessageDialog(null, "<html>You got " + score + " questions correct!<br>That's equal to a " + (score / 3.0 * 100.0) + "%.</html>");
    }
}