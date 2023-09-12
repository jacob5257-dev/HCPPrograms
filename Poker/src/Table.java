import java.util.List;
import java.util.ArrayList;

public class Table {
    List<String> deck = new ArrayList<>();
    String[] revealedCards = new String[5];
    int currentBet = 0;
    public Table() {
        String[] suits = {"S", "H", "C", "D"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
                           "10", "J", "Q", "K"};
        // Create a deck of cards. The deck should be A-K of each suit.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(values[j] + suits[i]);
            }
        }
        // Deck is now created w/ formatting as 2C, 3C, etc.
    }

    public void shuffle() {
        // Shuffle the deck.
        for (int i = 0; i < 1000; i++) {
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            String temp = deck.get(random1);
            deck.set(random1, deck.get(random2));
            deck.set(random2, temp);
        }
    }

    public void shuffle(int depth) {
        // Shuffle the deck.
        for (int i = 0; i < depth; i++) {
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            String temp = deck.get(random1);
            deck.set(random1, deck.get(random2));
            deck.set(random2, temp);
        }
    }

    public String deal() {
        // Deal a card from the deck.
        String card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public boolean revealCard() {
        // Get the first null element in the list
        int index = -1;
        for (int i = 0; i < revealedCards.length; i++) {
            if (revealedCards[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        if (index == 0) {
            revealedCards[0] = deal();
            revealedCards[1] = deal();
            revealedCards[2] = deal();
            return true;
        }
        revealedCards[index] = deal();
        return true;
    }
}