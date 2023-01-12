public class Card {
    private int numberIndex = -1;
    private int suitIndex = -1;
    private String[] suits = {"Diamonds", "Spades", "Hearts", "Clubs"};
    private String[] suitMaps = {"D", "S", "H", "C"};
    private String[] numbers = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] numberMaps = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Card(String number, String suit) {
        //Check if the number is in numberMaps and the suit in suitMaps and store the index of the element to numberIndex and suitIndex respectively
        for (int i = 0; i < numberMaps.length; i++) {
            if (numberMaps[i].equals(number)) {
                numberIndex = i;
            }
        }
        for (int i = 0; i < suitMaps.length; i++) {
            if (suitMaps[i].equals(suit)) {
                suitIndex = i;
            }
        }
        if (numberIndex == -1) {
            throw new IllegalArgumentException("Invalid number");
        }
        if (suitIndex == -1) {
            throw new IllegalArgumentException("Invalid suit");
        }
    }

    public String getDescription() {

        return numbers[numberIndex] + " of " + suits[suitIndex];
    }
}