public class CardGameTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("New Deck: " + deck);
        deck.shuffle();
        System.out.println("Shuffle: " + deck);

        Hand[] hands = new Hand[4];
        for (int i = 0; i < 4; i++) {
            hands[i] = new Hand();
        }
        System.out.println("Deal the cards:");
        for (int i = 0; i < 13; i++) {
            for (Hand hand : hands) {
                hand.addCard(deck);
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("player " + (i + 1) + ": " + hands[i]);
        }
    }
}