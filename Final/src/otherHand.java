import java.util.ArrayList;

public class otherHand {
    private ArrayList<Card> hand;
    
    public otherHand() {
        hand = new ArrayList<>();
    }
    
    public void addCard(Deck deck) {
        hand.add(deck.removeCard());
        hand.sort((a, b) -> {
            if (a.getSuit().equals(b.getSuit())) {
                return Integer.compare(a.getNumber(), b.getNumber());
            }
            return switch (a.getSuit()) {
                case "S" -> 1;
                case "H" -> b.getSuit().equals("C") || b.getSuit().equals("D") ? 1 : -1;
                case "C" -> b.getSuit().equals("D") ? 1 : -1;
                default -> -1;
            };
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
