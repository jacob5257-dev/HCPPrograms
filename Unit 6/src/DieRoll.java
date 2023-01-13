import java.util.List;
import java.util.ArrayList;

public class DieRoll {
    private int numRolls;
    private List<Integer> rolls = new ArrayList<Integer>();
    public DieRoll(int numRolls) {
        this.numRolls = numRolls;
    }

    public void roll(int times) {
        for (int i = 0; i < times; i++) {
            rolls.add((int) (Math.random() * 6) + 1);
        }
    }

    public List<Integer> getRolls() {
        roll(numRolls);
        return rolls;
    }

}
