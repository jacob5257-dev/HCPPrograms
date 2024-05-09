public class CardGameTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

        Hand[] hands = new Hand[4];
        for (int i = 0; i < 4; i++) {
            hands[i] = new Hand();
        }

        for (int i = 0; i < 13; i++) {
            for (Hand hand : hands) {
                hand.addCard(deck);
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Hand " + (i + 1) + ": " + hands[i]);
        }
    }
}