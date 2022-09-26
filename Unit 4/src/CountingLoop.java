public class CountingLoop {
    public static void main(String[] args) {
        String output = "";
        int iterations = 0;

        for (int i = 212; i < 377; i++) {
            String add = i + " ";
            output += add;
            iterations++;
            if (iterations == 15) {
                System.out.printf("%s%n", output);
                output = "";
                iterations = 0;
            }
        }
    }
}
