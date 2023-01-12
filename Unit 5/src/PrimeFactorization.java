public class PrimeFactorization {
    private int a;

    public PrimeFactorization(int a) {
        this.a = a;
    }
    /*
     * Use a class PrimeFactorization with methods nextFactor and hasMoreFactors (a predicate method - A method that returns true or false). The instance fields should be number and factor. The nextFactor method should initialize factor to 2 and use a for loop to count from factor to number. When factor divides into number evenly, take the factor out of number and return the factor. The method hasMoreFactors merely decides if there are more factors and returns true or false.
     * 
     */
    public int nextFactor() {
        int factor = 2;
        for (int i = factor; i <= a; i++) {
            if (a % i == 0) {
                a = a / i;
                return i;
            }
        }
        return 0;
    }

    public boolean hasMoreFactors() {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return true;
        }
        return false;
    }

}
