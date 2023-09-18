import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(6) + " " + random.nextInt(6));
    }
}