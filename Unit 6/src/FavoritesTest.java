// Imports javax.swing.* for the selection menus
import javax.swing.*;

/**
 * This program comes preloaded with 10 different shows (see Favorites.java). This program loops
 * through each of them and asks the user to choose between 2 or 3 of them. It then displays the
 * user's favorite show after asking it enough questions.
 * @see Favorites
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class FavoritesTest {
    /**
     * @see FavoritesTest
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Creates a new instance of the Favorites class
        Favorites favorites = new Favorites();
        // Continues asking questions until there is only one show left
        while (favorites.getFavorites().size() > 1) {
            // Gets the three options from the Favorite class and displays them in a selection menu
            String[] options;
            // Checks if there are more than 3 shows left
            if (favorites.getFavorites().size() >= 3) {
                options = new String[3];
                for (int i = 0; i < 3; i++) {
                    options[i] = favorites.askQuestions().get(i);
                }
            }
            // If there are less than 3 shows left, it will only display 2 options
            else {
                options = new String[2];
                for (int i = 0; i < 2; i++) {
                    options[i] = favorites.askQuestions().get(i);
                }
            }
            // Actually show the user the dialog box
            int option = JOptionPane.showOptionDialog(null, "Which of these is your favorite?", "Favorite", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            // Tells the favorites program which of the shows the user selected.
            favorites.selectedOption(option);
        }
        // Once there is only one option, it displays it to the user.
        JOptionPane.showMessageDialog(null, "Your favorite is " + favorites.getFavorites().get(0));

    }
}
