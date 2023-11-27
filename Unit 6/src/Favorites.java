// Imports java.util.List and java.util.ArrayList for use in the class
import java.util.List;
import java.util.ArrayList;

/**
 * Stores a list of favorite TV shows and asks the user questions to determine their favorite TV show.
 * @see FavoritesTest
 * @see Favorites
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-01
 */
public class Favorites {
    // Creates two instance variables.
    final List<String> favorites = new ArrayList<>();
    List<String> options = new ArrayList<>();
    // Pre-fills the favorites list with 10 shows.
    public Favorites() {
        favorites.add("The Office");
        favorites.add("Saturday Night Live");
        favorites.add("The Simpsons");
        favorites.add("Stranger Things");
        favorites.add("Family Guy");
        favorites.add("Game of Thrones");
        favorites.add("The Mandalorian");
        favorites.add("The Big Bang Theory");
        favorites.add("His Dark Materials");
        favorites.add("Avatar");
    }

    /**
     * Determines which two or three shows to ask the user about.
     * @return The list of shows to ask about (List<String>)
     */
    public List<String> askQuestions() {
        // If there is only one show left, it will return that show as the only element.
        if (favorites.size() == 1) {
            options.add(favorites.get(0));
            return options;
        }
        // Otherwise, it will return two or three shows.
        while (options.size() < 3) {
            // Picks a random show from the list
            int index = (int) (Math.random() * favorites.size());
            // Checks if it is already in the list. If it isn't, add it.
            if (!options.contains(favorites.get(index))) {
                options.add(favorites.get(index));
            }
            // Once all the shows are in the list, break out of the loop.
            if (options.size() == favorites.size()) {
                break;
            }
        }
        return options;
    }

    /**
     * Determines which show the user selected and removes the other shows from the favorites list.
     * @param option The index of the show the user selected (int)
     */
    public void selectedOption(int option) {
        //Remove the option from options, and remove the remaining elements from favorites
        options.remove(option);
        for (String s : options) {
            favorites.remove(s);
        }
        // Clears the options list for the next set of questions
        options = new ArrayList<>();
    }

    /**
     * Returns the list of favorite shows.
     * @return The list of favorite shows (List<String>)
     */
    public List<String> getFavorites() {
        return favorites;
    }
}
