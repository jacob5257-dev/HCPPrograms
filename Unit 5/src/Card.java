/**
 * This class represents a playing card. It has a number and a suit.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 */

public class Card {
    // Defines some variables and lists the convert the card into parsable characters.
    private int numberIndex = -1;
    private int suitIndex = -1;
    private final String[] suits = {"Diamonds", "Spades", "Hearts", "Clubs"};
    private final String[] numbers = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String errorMsg = "";

    /**
     * This method creates a new Card object.
     * @param number The number of the card.
     * @param suit The suit of the card.
     * @throws IllegalArgumentException If the number or suit is invalid.
     * @since 2023-01-18
     * @author jacob5257
     * @see Card
     */
    public Card(String number, String suit) {
        //Check if the number is in numberMaps and the suit in suitMaps and store the index of the element to numberIndex and suitIndex respectively
        String[] numberMaps = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < numberMaps.length; i++) {
            if (numberMaps[i].equals(number)) {
                numberIndex = i;
            }
        }
        String[] suitMaps = {"D", "S", "H", "C"};
        for (int i = 0; i < suitMaps.length; i++) {
            if (suitMaps[i].equals(suit)) {
                suitIndex = i;
            }
        }
        // If the number or suit was not mappable (not a valid card), throw an IllegalArgumentException.
        if (numberIndex == -1) {
            errorMsg += "Error: Invalid number! ";
        }
        if (suitIndex == -1) {
            errorMsg += "Error: Invalid suit! ";
        }
    }
    /**
     * This method returns the description of the card.
     * @return String The description of the card.
     * @since 2023-01-18
     * @author jacob5257
     * @see Card
     */
    public String getDescription() {
        // Converts the number and suit into a readable string and returns it.
        if (!errorMsg.isEmpty()) {
            return errorMsg;
        }
        return numbers[numberIndex] + " of " + suits[suitIndex];
    }
}