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

    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) return 0;
        if (bunnies == 1) return 2;
        if (bunnies == 2) return 5;
        return (bunnies % 2 == 0 ? 3 : 2) + bunnyEars2(bunnies - 1);
    }

    public int count7(int n) {
        int count = 0;
        if (n < 10) {
            if (n == 7) return 1;
            else return 0;
        }
        if (n % 10 == 7) count++;
        count += count7(n / 10);
        return count;
    }

    public int countX(String str) {
        int count = 0;
        if (str.length() == 1) {
            if (str.equals("x")) return 1;
            else return 0;
        }
        if (str.length() < 2) return 0;
        if (str.charAt(0) == 'x') count++;
        count += countX(str.substring(1));
        return count;
    }

    public int countHi(String str) {
        int count = 0;
        if (str.length() < 2) return 0;
        if (str.charAt(0) == 'h' && str.charAt(1) == 'i') count++;
        count += countHi(str.substring(1));
        return count;
    }

    public String changeXY(String str) {
        if (str.isEmpty()) return "";
        if (str.length() < 2) {
            if (str.charAt(0) == 'x') return "y";
            return str;
        }
        String string = "";
        if (str.charAt(0) == 'x') string += "y";
        else string += str.substring(0, 1);
        string += changeXY(str.substring(1));
        return string;
    }

    public String changePi(String str) {
        if (str.length() < 2) return str;
        String string = "";
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            string += "3.14";
            string += changePi(str.substring(2));
        }
        else {
            string += str.substring(0, 1);
            string += changePi(str.substring(1));}
        return string;
    }

    public String noX(String str) {
        if (str.isEmpty()) return "";
        if (str.length() < 2) {
            if (str.charAt(0) == 'x') return "";
            return str;
        }
        String string = "";
        if (str.charAt(0) == 'x') string += "";
        else string += str.substring(0, 1);
        string += noX(str.substring(1));
        return string;
    }

    public boolean array6(int[] nums, int index) {
        if (index == nums.length) return false;
        return (nums[index] == 6 || array6(nums, index + 1));
    }

    public int array11(int[] nums, int index) {
        int count = 0;
        if (index == nums.length) return 0;
        if (nums[index] == 11) count++;
        count += array11(nums, index + 1);
        return count;
    }
}