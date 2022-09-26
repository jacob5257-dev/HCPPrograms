public class CountByFives {
    public static void main(String[] args) {
        String output = "";
        for (int i = 5; i <= 500; i += 5) {
            output += i + " ";
            if (i % 50 == 0) {
                System.out.println(output);
                output = "";
            }
        }
    }
}
