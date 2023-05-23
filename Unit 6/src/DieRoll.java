// Imports the java.util.List and java.util.ArrayList classes for use in this program.
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a die roll with a specified number of rolls.
 * It is designed to check the randomness of the Math.random() method.
 * @see DieRollTest
 * @since 2023-03-09
 * @version 1.0
 */
public class DieRoll {
    // Creates instance variables to contain the number of rolls and the rolls themselves
    private int numRolls;
    private List<Integer> rolls = new ArrayList<Integer>();

    /**
     * Creates a new DieRoll object with the specified number of rolls.
     * @param numRolls The number of rolls to make
     */
    public DieRoll(int numRolls) {
        this.numRolls = numRolls;
    }

    /**
     * Rolls the die the specified number of times and adds the rolls to the rolls list.
     * @param times The number of times to roll the die
     */
    public void roll(int times) {
        for (int i = 0; i < times; i++) {
            rolls.add((int) (Math.random() * 6) + 1);
        }
    }

    /**
     * Returns the rolls list.
     * @return The rolls list
     */
    public List<Integer> getRolls() {
        roll(numRolls);
        return rolls;
    }

}
