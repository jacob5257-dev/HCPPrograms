import java.util.ArrayList;
import java.util.List;

public class Player {
    // Cards in the player's hand
    private List<String> cards = new ArrayList<>();
    // Tokens the player has
    private int tokens;
    // Deck of cards
    final List<String> deck = new ArrayList<>();

    /**
     * Creates a new player with the specified number of tokens.
     * @param tokens The number of tokens to start the player with.
     */
    public Player(int tokens) {
        this.tokens = tokens;
    }

    /**
     * Generates a deck and deals 5 cards to the player.
     * The deck is shuffled 1000 times to give some sort of randomness.
     */
    public void dealCards() {
        // Takes a token for a new round
        tokens--;
        // Creates a deck of cards
        String[] suits = {"S", "H", "C", "D"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K"};
        // Create a deck of cards. The deck should be A-K of each suit.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(values[j] + suits[i]);
            }
        }
        // Shuffle the deck.
        for (int i = 0; i < 1000; i++) {
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            String temp = deck.get(random1);
            deck.set(random1, deck.get(random2));
            deck.set(random2, temp);
        }
        // Deal cards to the player
        cards.add(deck.get(0));
        cards.add(deck.get(1));
        cards.add(deck.get(2));
        cards.add(deck.get(3));
        cards.add(deck.get(4));
    }

    /**
     * Returns the cards in the player's hand.
     * @return The cards in a player's hand
     */
    public String toString() {
        // Replace H with ♥, D with ♦, C with ♣, and S with ♠
        return cards.toString()
                .replace("H", "♥")
                .replace("D", "♦")
                .replace("C", "♣")
                .replace("S", "♠");
    }

    /**
     * Selects cards from the player's hand.
     * @param cards The cards to select.
     */
    public void selectCards(List<Integer> cards) {
        // Cards is now a list of indices of cards to keep.
        List<String> newCards = new ArrayList<>();
        // Adds all the cards the player wants to keep.
        for (Integer card : cards) {
            newCards.add(this.cards.get(card));
        }
        // Replace existing deck with only the cards the player wants to keep.
        this.cards = newCards;
        // Adds cards to the player's hand until they have 5 cards.
        for (int i = 0; i < 5 - cards.size(); i++) {
            this.cards.add(this.deck.get(i + 5));
        }
        // Cards is now a list of 5 cards.
    }

    /**
     * Returns the result of the player's hand.
     * @return The result, encoded in an integer.
     */
    public int getHandResult() {
        // This should be pretty straightforward lol
        if (DetermineHand.isRoyalFlush(cards)) return 9;
        if (DetermineHand.isStraightFlush(cards)) return 8;
        if (DetermineHand.isOfAKind(cards) == 2) return 7;
        if (DetermineHand.isFullHouse(cards)) return 6;
        if (DetermineHand.isFlush(cards)) return 5;
        if (DetermineHand.isStraight(cards)) return 4;
        if (DetermineHand.isOfAKind(cards) == 1) return 3;
        if (DetermineHand.numPairs(cards) == 2) return 2;
        if (DetermineHand.numPairs(cards) == 1) return 1;
        return 0;
    }

    /**
     * Returns the number of tokens the player has.
     * @return The number of tokens the player has.
     */
    public int getTokens() {
        return tokens;
    }

    /**
     * Adds tokens to the player's total.
     * @param result The result of the {@link #getHandResult()} so the proper amount of tokens can be added.
     * @throws IllegalArgumentException If the result is invalid.
     */
    public void addTokens(int result) {
        // This should also be pretty straightforward lol
        if (result <= 6) this.tokens += result;
        else if (result == 7) this.tokens += 25;
        else if (result == 8) this.tokens += 50;
        else if (result == 9) this.tokens += 250;
        else throw new IllegalArgumentException("Result is invalid, please pass in result of getHandResult()");
        cards = new ArrayList<>();
    }
}
