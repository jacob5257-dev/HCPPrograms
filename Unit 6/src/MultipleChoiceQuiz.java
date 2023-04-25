import java.util.List;
import java.util.Random;
import javax.swing.*;

public class MultipleChoiceQuiz {
    public static void main(String[] args) {
        String[] questions = {"What is 1 + 1?", "What is 2 + 2?", "What is 3 * 3?"};
        String[][] answers = {{"1", "2", "3"}, {"4", "5", "6"}, {"6", "8", "9"}};
        String[] correct = {"2", "4", "9"};
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
        int score = 0;
        for (int i = 0; i < 3; i++) {
            Object[] options = answers[i];
            JPanel panel = new JPanel();
            panel.add(new JLabel("<html>Question:<br>" + questions[i] +"</html>"));
            int selection = ( JOptionPane.showOptionDialog(null, panel, "Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
            if (selection < 0 || selection > 2) {
            	JOptionPane.showMessageDialog(null, "Don't close the quiz! Your quiz will be reset.");
            	score = 0;
            	i = -1;
            }
            else if (answers[i][selection].equals(correct[i])) {
                JOptionPane.showMessageDialog(null, "Correct!");
                score++;
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect! The correct answer is " + correct[i]);
            }

        }
        JOptionPane.showMessageDialog(null, "<html>You got " + score + " questions correct!<br>That's equal to a " + (score / 3.0 * 100.0) + "%.</html>");
    }
}