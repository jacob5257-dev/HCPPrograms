import java.util.ArrayList;
import java.util.List;

public class Player {
    /* Implement the following methods:
     * rollDice(Dice): uses the dice passed in to the function to roll a dice. Save to instance variable lastRoll and return it.
     * getSum(): return the sum of all the rolls the player has made.
     * getRolls(): return an arraylist of all the rolls the player has made.
     * getRollsCount(): return the number of rolls the player has made.
     * 
     */
    private int lastRoll;
    private int sum;
    private ArrayList<Integer> rolls;
    private Dice dice;

    public Player(Dice dice) {
        this.lastRoll = 0;
        this.sum = 0;
        this.rolls = new ArrayList<Integer>();
        this.dice = dice;
    }

    public int rollDice() {
        this.lastRoll = this.dice.roll();
        this.sum += this.lastRoll;
        this.rolls.add(this.lastRoll);
        return this.lastRoll;
    }

    public int getSum() {
        return this.sum;
    }

    public List<Integer> getRolls() {
        return this.rolls;
    }

    public int getRollsCount() {
        return this.rolls.size();
    }

    public int getLastRoll() {
        return this.lastRoll;
    }
}
