public class Logic2 {
    public boolean makeBricks(int small, int big, int goal) {
        return goal % 5 <= small && goal - big * 5 <= small;
    }

    public int loneSum(int a, int b, int c) {
        int sum = 0;
        if (a != b && a != c) sum += a;
        if (b != a && b != c) sum += b;
        if (c != a && c != b) sum += c;
        return sum;
    }

    public int luckySum(int a, int b, int c) {
        if (a == 13) return 0;
        if (b == 13) return a;
        if (c == 13) return a + b;
        return a + b + c;
    }

    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    public int fixTeen(int n) {
        if (n >= 13 && n <= 19 && n != 15 && n != 16) return 0;
        return n;
    }

    public int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }

    public int round10(int num) {
        if (num % 10 < 5) return num / 10 * 10;
        else return (num / 10 + 1) * 10;
    }

    public boolean closeFar(int a, int b, int c) {
        return Math.abs(a - b) <= 1 && Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2 || Math.abs(a - c) <= 1 && Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2;
    }

    public int blackjack(int a, int b) {
        if (a > 21 && b > 21) return 0;
        int max = Math.max(a, b);
        if (max <= 21) return max;
        return Math.min(a, b);
    }

    public boolean evenlySpaced(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;
        return max - mid == mid - min;
    }

    public int makeChocolate(int small, int big, int goal) {
        int bigBars = goal / 5;
        if (bigBars <= big) goal -= bigBars * 5;
        else goal -= big * 5;
        if (goal <= small) return goal;
        return -1;
    }
}