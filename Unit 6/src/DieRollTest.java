import java.util.List;
import java.util.Scanner;

public class DieRollTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rolls? ");
        int numRolls = scanner.nextInt();
        DieRoll dieRoll = new DieRoll(numRolls);
        List<Integer> rolls = dieRoll.getRolls();
        System.out.println("Rolls: " + rolls);
        int[] counts = new int[6];
        for (int i = 0; i < rolls.size(); i++) {
            int roll = rolls.get(i);
            counts[roll - 1]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("Proportion of " + (i + 1) + "s: " + (double) counts[i] / rolls.size() * 100.0 + "%");
        }
        scanner.close();
    }
}
