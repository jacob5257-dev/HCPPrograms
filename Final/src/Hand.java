import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<>();
    }
    
    public void addCard(Deck deck) {
        hand.add(deck.removeCard());
        hand.sort((a, b) -> {
            if (a.compareTo(b) > 0) {
                return 1;
            } else if (a.compareTo(b) < 0) {
                return -1;
            }
            return 0;
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString();
    }
}
