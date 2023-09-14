import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // New player with 10 tokens
        Player player = new Player(10);
        while (player.getTokens() > 0) {
            // Deal cards to the player
            player.dealCards();
            // Print the cards
            System.out.println("You have " + player.getTokens() + " tokens.");
            System.out.println("Your cards are: " + player);
            System.out.print("Select the indices of the cards you want to keep seperated by spaces (e.g. 0 1 2, you must keep at least one): ");
            String[] input = scanner.nextLine().split(" ");
            List<Integer> cardsToKeep = new ArrayList<>();
            for (String s : input) {
                try {
                    cardsToKeep.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.exit(1);
                }
            }
            player.selectCards(cardsToKeep);
            // Print their new cards
            System.out.println("Your new cards are: " + player);
            int result = player.getHandResult();
            switch (result) {
                case 0 -> System.out.println("You have a high card.");
                case 1 -> System.out.println("You have a pair.");
                case 2 -> System.out.println("You have two pairs.");
                case 3 -> System.out.println("You have three of a kind.");
                case 4 -> System.out.println("You have a straight.");
                case 5 -> System.out.println("You have a flush.");
                case 6 -> System.out.println("You have a full house.");
                case 7 -> System.out.println("You have four of a kind.");
                case 8 -> System.out.println("You have a straight flush.");
                case 9 -> System.out.println("You have a royal flush.");
            }
            player.addTokens(result);
            System.out.println("You now have " + player.getTokens() + " tokens.");
            System.out.print("Do you want to play again? ([y]/n): ");
            String playAgain = scanner.nextLine();
            if (playAgain.equals("n")) break;
        }
        System.out.println("You ended with " + player.getTokens() + " tokens.");
        if (player.getTokens() == 0) System.out.println("You lost all your tokens. Better luck next time!");
    }
}