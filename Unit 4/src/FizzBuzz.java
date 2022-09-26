public class FizzBuzz {
    public static void main(String[] args) {
        String answer = "";
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0) answer += "Fizz";
            if (i % 5 == 0) answer += "Buzz";
            if (i % 3 != 0 && i % 5 != 0) answer += i;
            answer += " ";
            if (i % 10 == 0) {
                answer += "\n";
            }
        }
        System.out.println(answer);
    }
}