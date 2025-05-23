public class Recursion1 {
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

    public boolean array220(int[] nums, int index) {
        if (nums.length <= index + 1) return false;
        if (index == nums.length - 1) {
            return nums[index] * 10 == nums[index + 1];
        }
        return nums[index] * 10 == nums[index + 1] || array220(nums, index + 1);
    }

    public String allStar(String str) {
        if (str.length() <= 1) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    public int countAbc(String str) {
        int count = 0;
        if (str.length() <= 3) {
            if (str.equals("abc") || str.equals("aba")) return 1;
            return 0;
        }
        if (str.startsWith("abc") || str.startsWith("aba")) count++;
        count += countAbc(str.substring(1));
        return count;
    }

    public int count11(String str) {
        int count = 0;
        if (str.length() <= 2) {
            if (str.equals("11")) return 1;
            return 0;
        }
        if (str.startsWith("11")) {
            count++;
            count += count11(str.substring(2));
        }
        else count += count11(str.substring(1));
        return count;
    }

    public int countHi2(String str) {
        int count = 0;
        if (str.length() <= 3) {
            if (str.equals("xhi")) return 0;
            if (str.contains("hi")) return 1;
            return 0;
        }
        if (str.startsWith("xhi")) count += countHi2(str.substring(2));
        else {if (str.startsWith("hi")) count += 1;
            count += countHi2(str.substring(1));}
        return count;
    }

    public int strCount(String str, String sub) {
        int count = 0;
        if (str.length() <= sub.length()) {
            if (str.equals(sub)) return 1;
            return 0;
        }
        if (str.startsWith(sub)) {
            count++;
            count += strCount(str.substring(sub.length()), sub);
        }
        else {
            count += strCount(str.substring(1), sub);
        }
        return count;
    }

    public int count8(int n) {
        int count = 0;
        if (n < 10) {
            if (n == 8) return 1;
            return 0;
        }
        if (n % 10 == 8) {
            if (n % 100 == 88) count += 2;
            else count++;
        }
        count += count8(n / 10);
        return count;
    }

    public String pairStar(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + pairStar(str.substring(1));
        return str.charAt(0) + pairStar(str.substring(1));
    }

    public String endX(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == 'x') return endX(str.substring(1)) + "x";
        return str.charAt(0) + endX(str.substring(1));
    }

    public int countPairs(String str) {
        int count = 0;
        if (str.length() < 3) return 0;
        if (str.length() == 3) {
            if (str.charAt(0) == str.charAt(2)) return 1;
            return 0;
        }
        if (str.charAt(0) == str.charAt(2)) count++;
        count += countPairs(str.substring(1));
        return count;
    }

    public String stringClean(String str) {
        String result = "";
        if (str.length() < 2) return str;
        if (str.charAt(0) != str.charAt(1)) result += Character.toString(str.charAt(0));
        result += stringClean(str.substring(1));
        return result;
    }

    public String parenBit(String str) {
        if (str.charAt(0) == '(') {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ')') return str.substring(0, i + 1);
            }
        }
        else return parenBit(str.substring(1));
        return "";
    }

    public boolean nestParen(String str) {
        if (str.isEmpty()) return true;
        if (str.length() == 1) return false;
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') return nestParen(str.substring(1, str.length() - 1));
        return false;
    }

    public boolean strCopies(String str, String sub, int n) {
        if (str.length() < sub.length()) return n == 0;
        if (str.startsWith(sub)) return strCopies(str.substring(1), sub, n - 1);
        return strCopies(str.substring(1), sub, n);
    }

    public int strDist(String str, String sub) {
        if (str.length() < sub.length()) return 0;
        if (str.startsWith(sub) && str.endsWith(sub)) return str.length();
        if (str.startsWith(sub)) return strDist(str.substring(0, str.length() - 1), sub);
        return strDist(str.substring(1), sub);
    }
}