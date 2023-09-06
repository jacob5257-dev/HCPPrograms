public class Player {
    String[] cards = new String[2];

    public Player() {}

    public void setCards(String card1, String card2) {
        cards[0] = card1;
        cards[1] = card2;
    }

    public String toString() {
        return cards[0] + " " + cards[1];
    }
}
