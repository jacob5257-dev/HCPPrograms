import java.util.Scanner;

public class FavoritesTest {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        System.out.println(favorites.askQuestions());
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        favorites.selectedOption(option);
        System.out.println(favorites.askQuestions());
        option = scanner.nextInt();
        favorites.selectedOption(option);
        System.out.println(favorites.askQuestions());
        option = scanner.nextInt();
        favorites.selectedOption(option);
        System.out.println(favorites.askQuestions());
        option = scanner.nextInt();
        favorites.selectedOption(option);
        System.out.println(favorites.askQuestions());
        option = scanner.nextInt();
        favorites.selectedOption(option);
        System.out.println("Your favorite TV show is " + favorites.getFavorites().get(0));
        scanner.close();
    }
}
