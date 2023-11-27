import java.util.*;

@SuppressWarnings("UnusedReturnValue")
public class CustomDice {
    private final List<String> sides;
    private String lastRoll;

    public CustomDice(List<String> sides) {
        this.sides = sides;
    }

    public String roll() {
        this.lastRoll = this.sides.get((int) (Math.random() * this.sides.size()));
        return this.lastRoll;
    }

    public String getLastRoll() {
        return this.lastRoll;
    }
}
