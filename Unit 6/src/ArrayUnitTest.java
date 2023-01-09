import java.util.Random;
import java.util.Scanner;

public class ArrayUnitTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers do you want to generate: ");
        String input = scanner.nextLine();
        System.out.print("Number of array elements: ");
        String arrayElements = scanner.nextLine();
        int numbers;
        int elements;
        try {
            numbers = Integer.parseInt(input);
            elements = Integer.parseInt(arrayElements);
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid input provided! Try putting in positive whole numbers for the values above.");
        }
        if (numbers <= 0 || elements <= 0) throw new RuntimeException("Positive whole numbers please!");
        int[] numberOfCalls = new int[elements];
        for (int i = 0; i < elements; i++) {
            numberOfCalls[i] = 0;
        }
        for (int i = 0; i < numbers; i++) {
            Random random = new Random();
            numberOfCalls[random.nextInt(elements)]++;
        }
        for (int i = 0; i < elements; i++) {
            System.out.println(i + " was called " + numberOfCalls[i] + " times (" + (numberOfCalls[i] * 1.0 / numbers * 100.0) + "%).");
        }
    }
}
