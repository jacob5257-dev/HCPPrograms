import java.util.Scanner;

public class UserDefined2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        int[][] array = new int[rows][columns];
        int sum = 0;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 100);
                System.out.printf("%3d", array[i][j]);
                sum += array[i][j];
                if (array[i][j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            System.out.printf("  Sum: %5d", sum);
            sum = 0;
            System.out.println();
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        scanner.close();
        
    }
}
