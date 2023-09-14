import java.util.Arrays;
import java.util.List;

public class DetermineHand {
    /**
     * Determines if the player has a pair.
     * @deprecated Use {@link #numPairs(List)} instead.
     * @param cards List of cards to check.
     * @return Whether the player has a pair (true = yes, false = no).
     */
    public static boolean hasOnePair(List<String> cards) {
        // if (method.deprecated()) method.hasComments = false;
        boolean hasPair = false;
        int[] previousCards = new int[13];
        for (String card : cards) {
            int cardValue = Integer.parseInt(card.substring(0, card.length() - 1));
            if (previousCards[cardValue] == 1) {
                hasPair = true;
            }
            previousCards[cardValue]++;
        }
        return hasPair;
    }

    /**
     * Determines the number of pairs a deck has.
     * @param cards The cards to check.
     * @return The number of pairs in the deck.
     */
    public static int numPairs(List<String> cards) {
        // not commenting
        int[] previousCards = new int[14];
        int pairs = 0;
        for (String card : cards) {
            String value = card.substring(0, card.length() - 1);
            int cardValue = 0;
            try { cardValue = Integer.parseInt(value); }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 1;
                    default -> cardValue;
                };
            }
            if (previousCards[cardValue] == 1) {
                pairs++;
                previousCards[cardValue] = 0;
            }
            previousCards[cardValue]++;
        }
        return pairs;
    }

    /**
     * Determines if the player has three cards of the same value/kind.
     * @deprecated Use {@link #isOfAKind(List)} instead.
     * @param cards List of cards to check.
     * @return Whether the player has three of a kind (true = yes, false = no).
     */
    public static boolean isThreeOfAKind(List<String> cards) {
        // This is deprecated, why are you reading this
        // Three of a kind is when there are three cards of the same value.
        int[] previousCards = new int[14];
        for (String card : cards) {
            String value = card.substring(0, card.length() - 1);
            int cardValue = 0;
            try { cardValue = Integer.parseInt(value); }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 1;
                    default -> cardValue;
                };
            }
            previousCards[cardValue]++;
        }
        for (int previousCard : previousCards) {
            if (previousCard == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the player has three or four cards of the same value/kind.
     * @param cards List of cards to check.
     * @return Whether the player has four of a kind (2), three of a kind (1), or neither (0).
     */
    public static int isOfAKind(List<String> cards) {
        // not commenting
        int[] previousCards = new int[14];
        for (String card : cards) {
            String value = card.substring(0, card.length() - 1);
            int cardValue = 0;
            try { cardValue = Integer.parseInt(value); }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 1;
                    default -> cardValue;
                };
            }
            previousCards[cardValue]++;
        }
        int result = 0;
        for (int previousCard : previousCards) {
            if (previousCard == 4) result = 2;
            else if (previousCard == 3 && result == 0) result = 1;
        }
        return result;
    }

    /**
     * Determines if the player has a full house.
     * @param cards The cards to check.
     * @return Whether the player has a full house (true = yes, false = no).
     */
    public static boolean isFullHouse(List<String> cards) {
        // Checks if there is a three of a kind and a pair.
        return isOfAKind(cards) == 1 && numPairs(cards) == 3;
    }

    /**
     * Determines if the player has a flush.
     * @param cards The cards to check.
     * @return Whether the player has a flush (true = yes, false = no).
     */
    public static boolean isFlush(List<String> cards) {
        // Get the suit of the first card
        String suit = cards.get(0).substring(cards.get(0).length() - 1);
        for (String card : cards) {
            // If the suit of any of the future cards don't match the first card, return false.
            if (!card.substring(card.length() - 1).equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if the player has a straight.
     * @param cards The cards to check.
     * @return Whether the player has a straight (true = yes, false = no).
     */
    public static boolean isStraight(List<String> cards) { //skipcq: JAVA-R1000
        // Try to figure out what this does too lazy to comment
        int[] previousCards = new int[5];
        for (int i = 0; i < cards.size(); i++) {
            String value = cards.get(i).substring(0, cards.get(i).length() - 1);
            int cardValue = 0;
            try { cardValue = Integer.parseInt(value); }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 1;
                    default -> cardValue;
                };
            }
            previousCards[i] = cardValue;
        }
        boolean failed = false;
        SortingAlgorithms.bubbleSort(previousCards);
        for (int i = 0; i < previousCards.length - 1; i++) {
            if (previousCards[i] + 1 != previousCards[i + 1]) {
                failed = true;
                break;
            }
        }
        if (!failed) return true;
        for (int i = 0; i < cards.size(); i++) {
            String value = cards.get(i).substring(0, cards.get(i).length() - 1);
            int cardValue = 0;
            try { cardValue = Integer.parseInt(value); }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 14;
                    default -> cardValue;
                };
            }
            previousCards[i] = cardValue;
        }
        SortingAlgorithms.bubbleSort(previousCards);
        for (int i = 0; i < previousCards.length - 1; i++) {
            if (previousCards[i] + 1 != previousCards[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if the player has a straight flush.
     * @param cards The cards to check.
     * @return Whether the player has a straight flush (true = yes, false = no).
     */
    public static boolean isStraightFlush(List<String> cards) {
        // A straight flush is a straight and a flush lol
        return isStraight(cards) && isFlush(cards);
    }

    /**
     * Determines if the player has a royal flush.
     * @param cards The cards to check.
     * @return Whether the player has a royal flush (true = yes, false = no).
     */
    public static boolean isRoyalFlush(List<String> cards) {
        // A royal flush has to be a straight flush, so if it isn't a straight flush, return false.
        if (!isStraightFlush(cards)) return false;
        // Get the sum of the cards
        int[] cardsNumber = new int[5];
        for (int i = 0; i < cards.size(); i++) {
            String value = cards.get(i).substring(0, cards.get(i).length() - 1);
            int cardValue = 0;
            try {
                cardValue = Integer.parseInt(value);
            }
            catch (NumberFormatException e) {
                cardValue = switch (value) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 14;
                    default -> cardValue;
                };
            }
            cardsNumber[i] += cardValue;
        }
        return Arrays.equals(cardsNumber, new int[]{10, 11, 12, 13, 14});
    }
}
