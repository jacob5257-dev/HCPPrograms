import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int[] reverse = new int[10];
        for (int i = 0; i < 10; i++) {
            reverse[i] = array[9 - i];
        }
        System.out.println(Arrays.toString(reverse));
    }
}
