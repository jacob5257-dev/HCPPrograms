public class Main {
    public int factorial(int n) {
        if (n == 1) return 1;
        return n * (factorial(n - 1));
    }

    public int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;
        return bunnyEars(bunnies - 1) + 2;

    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    public int sumDigits(int n) {
        if (n < 10) return n;
        return (sumDigits(n / 10) + n % 10);
    }

    public int powerN(int base, int n) {
        if (n == 1) return base;
        return (base * (powerN(base, n - 1)));
    }
}