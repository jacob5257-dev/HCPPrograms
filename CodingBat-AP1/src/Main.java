public class Main {
    public boolean scoresIncreasing(int[] scores) {
        if (scores.length < 2) return true;
        if (scores.length == 2) {
            if (scores[1] > scores[0]) return true;
            return false;
        }
        int previous = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < previous) return false;
            previous = scores[i];
        }
        return true;
    }

    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i] == scores[i + 1]) return true;
        }
        return false;
    }
}