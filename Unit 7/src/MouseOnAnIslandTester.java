import javax.swing.*;
import java.text.DecimalFormat;

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
                // if island.isOnEdge() is 0, continue. If it is 1, increment escaped. If it is -1, increment drowned.

                if (island.isOnEdge() == 1) { escaped++; System.out.println("The mouse escaped on turn " + island.getMoves()); break; }
                else if (island.isOnEdge() == -1) { drowned++; System.out.println("The mouse drowned on turn " + island.getMoves()); break; }
            }
            if (island.isOnEdge() == 0) { starved++; System.out.println("The mouse starved on turn " + island.getMoves());}
            System.out.println(i < 3 ? island : "");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        double escapedPercent = Double.parseDouble(df.format((double) escaped / TRIALS * 100));
        double drownedPercent = Double.parseDouble(df.format((double) drowned / TRIALS * 100));
        double starvedPercent = Double.parseDouble(df.format((double) starved / TRIALS * 100));
        System.out.println("Escaped: " + escaped + " (" + escapedPercent + "%)\nDrowned: " + drowned + " (" + drownedPercent + "%)\nStarved: " + starved + " (" + starvedPercent + "%)\nMath: " + (escaped + drowned + starved == TRIALS));
    }

    public static boolean isNotNumeric(String strNum) {
        for (int i = 0; i < strNum.length(); i++) {
            if (!Character.isDigit(strNum.charAt(i))) return true;
        }
        return false;
    }
}
