public class PrimesTable {
    private int a;
    public PrimesTable(int a) {
        this.a = a;
    }

    public int nextPrime() {
        while (true) {
            a++;
            if (isPrime()) return a;
        }
    }

    public boolean isPrime() {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}
