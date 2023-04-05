import javax.swing.*;

public class FavoritesTest {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        while (favorites.getFavorites().size() > 1) {
            String[] options;
            if (favorites.getFavorites().size() >= 3) {
                options = new String[3];
                for (int i = 0; i < 3; i++) {
                    options[i] = favorites.askQuestions().get(i);
                }
            }
            else {
                options = new String[2];
                for (int i = 0; i < 2; i++) {
                    options[i] = favorites.askQuestions().get(i);
                }
            }
            int option = JOptionPane.showOptionDialog(null, "Which of these is your favorite?", "Favorite", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            favorites.selectedOption(option);
        }
        JOptionPane.showMessageDialog(null, "Your favorite is " + favorites.getFavorites().get(0));

    }
}
