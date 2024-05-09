import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> list = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String card = switch (i) {
                    case 0 -> "D";
                    case 1 -> "C";
                    case 2 -> "H";
                    case 3 -> "S";
                    default -> throw new IllegalArgumentException("Invalid suit");
                };
                list.add(new Card(j, card));
            }
        }
    }

    public Card removeCard() {
        return list.removeFirst();
    }

    public void shuffle() {
        Collections.shuffle(list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : list) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString();
    }
}
