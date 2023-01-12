import java.util.Scanner;

public class CardTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card: ");
        String cardInput = scanner.nextLine();
        String[] cardSplit = cardInput.split("", 0);
        Card card = null;
        if (cardInput.length() == 2) card = new Card(cardSplit[0], cardSplit[1]);
        else if (cardInput.length() == 3) card = new Card(cardSplit[0] + cardSplit[1], cardSplit[2]);
        else {
            System.out.println("Invalid card");
            System.exit(0);
        }
        System.out.println(card.getDescription());
        scanner.close();
    }
}
