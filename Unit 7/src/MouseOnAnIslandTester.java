import javax.swing.*;

public class MouseOnAnIslandTester {
    public static void main(String[] args) {
        int escaped = 0, drowned = 0, starved = 0;
        // Ask the user how many trials and what the chance of bridges should be
        String input = JOptionPane.showInputDialog("How many trials?");
        if (input == null) {JOptionPane.showMessageDialog(null, "Invalid input."); System.exit(0); }
        if (isNotNumeric(input)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            System.exit(0);
        }
        final int TRIALS = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("What should the chance of bridges be?");
        if (input == null) {JOptionPane.showMessageDialog(null, "Invalid input."); System.exit(0); }
        if (isNotNumeric(input)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            System.exit(0);
        }
        final int PERCENT_BRIDGES = Integer.parseInt(input);
        // Run the simulation
        for (int i = 0; i < TRIALS; i++) {
            MouseOnAnIsland island = new MouseOnAnIsland(PERCENT_BRIDGES);
            for (int j = 0; j < 50; j++) {
                island.moveMouse();
                if (island.isOnEdge() != 0) {
                    if (island.isOnEdge() == 1) escaped++;
                    else if (island.isOnEdge() == -1) drowned++;
                }
            }
            if (island.isOnEdge() == 0) starved++;
        }
        System.out.println("Escaped: " + escaped + "\nDrowned: " + drowned + "\nStarved: " + starved + "\nMath: " + (escaped + drowned + starved == TRIALS));

        MouseOnAnIsland island = new MouseOnAnIsland(30);
        System.out.println(island);
        island.moveMouse();
        System.out.println(island);
    }

    public static boolean isNotNumeric(String strNum) {
        for (int i = 0; i < strNum.length(); i++) {
            if (!Character.isDigit(strNum.charAt(i))) return true;
        }
        return false;
    }
}
