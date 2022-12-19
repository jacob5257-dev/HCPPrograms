public class OddNumbers {
    public static void main(String[] args) {
        String numbers = "";
        int times_added = 0;

        for (int i = 0; i < 101; i++) {
            if (i % 2 != 0) {
                numbers += i;
                numbers += " ";
                times_added++;
                if (times_added == 10) {
                    System.out.printf("%s%n", numbers);
                    numbers = "";
                    times_added = 0;
                }
            }
        }
    }
}
