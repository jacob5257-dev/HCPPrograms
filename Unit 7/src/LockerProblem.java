/**
 * Solves the locker problem.
 * @since 7/27/2023
 * @version 1.0
 * @author jacob5257
 */
public class LockerProblem {
    public static void main(String[] args) {
        // Create an array of 100 booleans representing each locker.
        boolean[] lockers = new boolean[100];
        // Loop through the array, with i being the student
        for (int i = 0; i < 100; i++) {
            // Loop through the array again, with j being the locker. When they match, it's a multiple of i + 1. i + 1 is used because the first locker is 0, and otherwise it won't increment the first time.
            for (int j = i; j < 100; j += i + 1) {
                // If the locker is open, close it. If it's closed, open it.
                lockers[j] = !lockers[j];
            }
        }
        // Loop through the array one last time, printing the locker number if it's open
        for (int i = 0; i < 100; i++) {
            if (lockers[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }

}
