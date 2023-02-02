import java.util.Scanner;

/**
 * This program tests the Card class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 */

public class CardTest {
    /**
     * This method tests the Card class.
     * @param args The list of arguments passed on the command line. Unused!
     */
    public static void main(String[] args) {
        // Create a Scanner object and stores input to cardInput.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card: ");
        String cardInput = scanner.nextLine();
        // Splits the input into an array of strings.
        String[] cardSplit = cardInput.split("", 0);
        // Creates a new Card object and defined it based on the length of the input. Catches invalid inputs.
        Card card = null;
        if (cardInput.length() == 2) card = new Card(cardSplit[0], cardSplit[1]);
        else if (cardInput.length() == 3) card = new Card(cardSplit[0] + cardSplit[1], cardSplit[2]);
        else {
            System.out.println("Invalid card");
            System.exit(0);
        }
        // Prints the description of the card.
        // skipcq: JAVA-E1083
        System.out.println(card.getDescription());
        scanner.close();
    }
}
