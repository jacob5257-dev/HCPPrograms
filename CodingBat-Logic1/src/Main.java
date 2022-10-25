public class Main {
    public boolean cigarParty(int cigars, boolean isWeekend) {
        return cigars >= 40 && (isWeekend || cigars <= 60);
    }
    public int dateFashion(int you, int date) {
        if (you <= 2 || date <= 2) return 0;
        if (you >= 8 || date >= 8) return 2;
        return 1;
    }
    public boolean squirrelPlay(int temp, boolean isSummer) {
        return temp >= 60 && (isSummer || temp <= 90);
    }
    public int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) speed -= 5;
        if (speed <= 60) return 0;
        if (speed <= 80) return 1;
        return 2;
    }
    public int sortaSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 19) return 20;
        return sum;
    }
    public String alarmClock(int day, boolean vacation) {
        if (vacation) {
            if (day == 0 || day == 6) return "off";
            return "10:00";
        }
        if (day == 0 || day == 6) return "10:00";
        return "7:00";
    }
    public boolean love6(int a, int b) {
        if (a == 6 || b == 6) return true;
        return a + b == 6 || Math.abs(a - b) == 6;
    }
    public boolean in1To10(int n, boolean outsideMode) {
        if (outsideMode) {
            return n <= 1 || n >= 10;
        }
        return n >= 1 && n <= 10;
    }
    public boolean specialEleven(int n) {
        return n % 11 == 0 || n % 11 == 1;
    }
    public boolean more20(int n) {
        return n % 20 == 1 || n % 20 == 2;
    }
    public boolean old35(int n) {
        if (n % 3 == 0 && n % 5 == 0) return false;
        return n % 3 == 0 || n % 5 == 0;
    }
    public boolean less20(int n) {
        return n % 20 == 18 || n % 20 == 19;
    }
    public boolean nearTen(int num) {
        return num % 10 <= 2 || num % 10 >= 8;
    }
    public int teenSum(int a, int b) {
        if (a >= 13 && a <= 19 || b >= 13 && b <= 19) return 19;
        return a + b;
    }
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        if (isAsleep) return false;
        return !isMorning || isMom;
    }
    public int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) return 0;
        if (tea >= candy * 2 || candy >= tea * 2) return 2;
        return 1;
    }
    public String fizzString(String str) {
        if (str.startsWith("f") && str.endsWith("b")) return "FizzBuzz";
        if (str.startsWith("f")) return "Fizz";
        if (str.endsWith("b")) return "Buzz";
        return str;
    }
    public String fizzString2(int n) {
        if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz!";
        if (n % 3 == 0) return "Fizz!";
        if (n % 5 == 0) return "Buzz!";
        return n + "!";
    }
    public boolean twoAsOne(int a, int b, int c) {
        return a + b == c || a + c == b || b + c == a;
    }
    public boolean inOrder(int a, int b, int c, boolean bOk) {
        if (bOk) {
            return c > b;
        }
        return b > a && c > b;
    }
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        if (equalOk) {
            return c >= b && b >= a;
        }
        return c > b && b > a;
    }
    public boolean lastDigit(int a, int b, int c) {
        return a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10;
    }
    public int rollDice(int die1, int die2, boolean noDoubles) {
        if (noDoubles && die1 == die2) {
            if (die1 == 6) return 7;
            return die1 + die2 + 1;
        }
        return die1 + die2;
    }

}