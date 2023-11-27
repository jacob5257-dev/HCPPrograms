public class Dice {
    private final int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return (int) (Math.random() * this.sides) + 1;
    }
}
