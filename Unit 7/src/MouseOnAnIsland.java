import java.util.Arrays;
import java.util.Random;

public class MouseOnAnIsland {
    // The board the mouse is on
    private int[][] island;
    // The mouse's position
    private int mouseRow;
    private int mouseCol;
    private int moves = 0;
    public final int[][] originalIsland;

    /**
     * Creates a new simulation of a mouse on the island
     * @param percentBridges The chance that the cell will generate as a bridge (0 - 100).
     * @throws IllegalArgumentException If the percent of bridges is not between 0 and 100.
     */
    public MouseOnAnIsland(int percentBridges) {
        // Random class for generation later
        Random random = new Random();
        // Create the island
        this.island = new int[10][15];
        // Check if the percent of bridges is valid
        if (percentBridges < 0 || percentBridges > 100) throw new IllegalArgumentException("The percent of bridges must be between 0 and 100.");
        // Set the border to water (-1) if the randomly generated number is less than the percent of bridges for the "top" and "bottom" of the island
        for (int i = 0; i < this.island.length; i++) {
            this.island[i][0] = random.nextInt(100) < percentBridges ? 0 : -1;
            this.island[i][this.island[0].length - 1] = random.nextInt(100) < percentBridges ? 0 : -1;
        }
        // Repeats the process for the "left" and "right" of the this.island
        for (int i = 0; i < this.island[0].length; i++) {
            this.island[0][i] = random.nextInt(100) < percentBridges ? 0 : -1;
            this.island[this.island.length - 1][i] = random.nextInt(100) < percentBridges ? 0 : -1;
        }
        // Places the mouse in the middle and calls the function to move it there.
        this.mouseRow = this.island.length / 2;
        this.mouseCol = this.island[0].length / 2;
        setMouse();
        // Copies the island to a new array so we can see the end state
        this.originalIsland = new int[this.island.length][this.island[0].length];
        for (int i = 0; i < this.island.length; i++) {
            this.originalIsland[i] = Arrays.copyOf(this.island[i], this.island[i].length);
        }
    }

    /**
     * Moves the mouse to a new position. Modify the mouseRow and mouseCol variables first, and then call this method.
     * @throws IllegalArgumentException If the new position is not on the island.
     */
    public void setMouse() {
        // Check if the new position is on the island
        //if (mouseRow < 0 || mouseRow >= this.island.length || mouseCol < 0 || mouseCol >= this.island[0].length) throw new IllegalArgumentException("The new position must be on the island.");        this.island[this.mouseRow][this.mouseCol] = 1;
        // Find where there is a 1 on the island and store its position
        for (int i = 0; i < this.island.length; i++) {
            for (int j = 0; j < this.island[0].length; j++) {
                if (this.island[i][j] == 1) this.island[i][j] = 0;
            }
        }
        // Set the new position to 1
        this.island[this.mouseRow][this.mouseCol] = 1;
    }

    /**
     * Moves the mouse to a new position randomly.
     * @throws IllegalArgumentException If the new position is not on the island.
     */
    public void moveMouse() {
        moves++;
        Random random = new Random();
        int movement = random.nextInt(4) + 1;
        // 1 = up, 2 = right, 3 = down, 4 = left
        if (movement == 1) mouseCol--;
        else if (movement == 2) mouseRow++;
        else if (movement == 3) mouseCol++;
        else mouseRow--;
        setMouse();
    }

    /**
     * Checks if the mouse is on the edge of the island.
     * @return 1 is the mouse escaped the island on a bridge, -1 if the mouse drowned, and 0 if the mouse is still on the island.
     */
    public int isOnEdge() {
        // Checks if the mouse is on an edge, and check if the cell it is on is a bridge, water, or land.
        if (this.mouseRow == 0) {
            if (this.originalIsland[this.mouseRow][this.mouseCol] == -1) return -1;
            else if (this.originalIsland[this.mouseRow][this.mouseCol] == 0) return 1;
            //else return 0;
        }
        else if (this.mouseRow == 9) {
            if (this.originalIsland[this.mouseRow][this.mouseCol] == -1) return -1;
            else if (this.originalIsland[this.mouseRow][this.mouseCol] == 0) return 1;
            //else return 0;
        }
        else if (this.mouseCol == 0) {
            if (this.originalIsland[this.mouseRow][this.mouseCol] == -1) return -1;
            else if (this.originalIsland[this.mouseRow][this.mouseCol] == 0) return 1;
            //else return 0;
        }
        else if (this.mouseCol == 14) {
            if (this.originalIsland[this.mouseRow][this.mouseCol] == -1) return -1;
            else if (this.originalIsland[this.mouseRow][this.mouseCol] == 0) return 1;
            //else return 0;
        }
        return 0;
    }

    /**
     * Converts the board to a human-readable format.
     * @return The board as a string.
     */
    public String toString() {
        String result = "";
        for (int[] row : this.island) {
            for (int cell : row) {
               switch (cell) {
                   case -1 -> result += "W ";
                   case 0 -> result += "B ";
                   case 1 -> result += "M ";
               }
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Gets the number of moves the mouse has made.
     * @return The number of moves the mouse has made.
     */
    public int getMoves() {
        return moves;
    }
}
