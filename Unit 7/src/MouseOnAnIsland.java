import java.util.Random;

public class MouseOnAnIsland {
    // The board the mouse is on
    private int[][] island;
    // The mouse's position
    private int mouseRow;
    private int mouseCol;

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
        setMouse(this.island.length / 2, this.island[0].length / 2);
    }

    /**
     * Moves the mouse to a new position.
     * @param newMouseRow The row to move the mouse to.
     * @param newMouseCol The column to move the mouse to.
     * @throws IllegalArgumentException If the new position is not on the island.
     */
    public void setMouse(int newMouseRow, int newMouseCol) {
        // Check if the new position is on the island
        if (newMouseRow < 0 || newMouseRow >= this.island.length || newMouseCol < 0 || newMouseCol >= this.island[0].length) throw new IllegalArgumentException("The new position must be on the island.");
        // Change the old position to 0
        this.island[mouseRow][mouseCol] = 0;
        // Change the new position to 1
        mouseRow = newMouseRow;
        mouseCol = newMouseCol;
        this.island[mouseRow][mouseCol] = 1;
    }

    /**
     * Moves the mouse to a new position randomly.
     * @throws IllegalArgumentException If the new position is not on the island.
     */
    public void moveMouse() {
        Random random = new Random();
        int movement = random.nextInt(4) + 1;
        // 1 = up, 2 = right, 3 = down, 4 = left
        if (movement == 1) setMouse(mouseRow, mouseCol--);
        else if (movement == 2) setMouse(mouseRow++, mouseCol);
        else if (movement == 3) setMouse(mouseRow, mouseCol++);
        else setMouse(mouseRow--, mouseCol);
    }

    /**
     * Checks if the mouse is on the edge of the island.
     * @return 1 is the mouse escaped the island on a bridge, -1 if the mouse drowned, and 0 if the mouse is still on the island.
     */
    public int isOnEdge() {
        // Checks if the mouse is on an edge, and check if the cell it is on is a bridge, water, or land.
        if (mouseRow == 0) {
            if (this.island[mouseRow][mouseCol] == -1) return -1;
            else if (this.island[mouseRow][mouseCol] == 0) return 1;
            else return 0;
        }
        else if (mouseRow == this.island.length - 1) {
            if (this.island[mouseRow][mouseCol] == -1) return -1;
            else if (this.island[mouseRow][mouseCol] == 0) return 1;
            else return 0;
        }
        else if (mouseCol == 0) {
            if (this.island[mouseRow][mouseCol] == -1) return -1;
            else if (this.island[mouseRow][mouseCol] == 0) return 1;
            else return 0;
        }
        else if (mouseCol == this.island[0].length - 1) {
            if (this.island[mouseRow][mouseCol] == -1) return -1;
            else if (this.island[mouseRow][mouseCol] == 0) return 1;
            else return 0;
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
                result += cell == -1 ? cell + " " : cell + "  ";
            }
            result += "\n";
        }
        return result;
    }
}
