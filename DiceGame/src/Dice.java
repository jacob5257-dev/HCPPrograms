public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return (int) (Math.random() * this.sides) + 1;
    }
}
