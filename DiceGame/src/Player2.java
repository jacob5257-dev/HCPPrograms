public class Player2 {
    private final String name;
    private int score;

    public Player2(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void removeScore(int score) {
        this.score -= score;
    }
}
