import java.util.Random;

/**
 * Class for playing with Lights Out puzzles.
 */
public class LightsOutGame {

    /** Default number of rows in a puzzle. */
    public static final int DEFAULT_ROWS = 5;

    /** Default number of columns in a puzzle. */
    public static final int DEFAULT_COLS = 5;

    /** Character for light on in string representation. */
    public static final char LIGHT_ON = '*';

    /** Character for light off in string representation. */
    public static final char LIGHT_OFF = '-';

    /**
     * Create a lights out puzzle grid of given dimensions with all lights off.
     * @param rows Number of rows
     * @param cols Number of columns
     * @return 2D array of booleans with all values set to false.
     */
    public static boolean[][] createEmptyPuzzle(int rows, int cols) {
        return new boolean[rows][cols];
    }

    /**
     * Given a 2D array of booleans, how many rows does it have?
     * @param arr The array in question
     * @return The number of rows in the array.
     */
    public static int numRows(boolean[][] arr) {
        return arr.length;
    }

    /**
     * Given a 2D array of booleans, how many columns does it have?
     * @param arr The array in question
     * @return The number of columns in the array.
     */
    public static int numCols(boolean[][] arr) {
        return arr[0].length;
    }

    /**
     * Creates a string representation of the game board.
     * Rows end with a newline character.
     * @param grid The grid of lights
     * @return String representation of the board
     */
    public static String gridToString(boolean[][] grid) {
        String res = "";
        for (boolean[] row : grid) {
            for (boolean b : row) {
                res += (b ? LIGHT_ON : LIGHT_OFF);
            }
            res += "\n";
        }
        return res;
    }

    /**
     * Is this puzzle solved?
     * In other words, are all the lights off?
     * @param puzzle The puzzle grid
     * @return True if all lights are off, false if any are on.
     */
    public static boolean isPuzzleSolved(boolean[][] puzzle) {
        for (boolean[] row : puzzle) {
            for (boolean b : row) {
                if (b) { return false; }
            }
        }
        return true;
    }

    /**
     * Toggle the status of a single light, if possible.
     *
     * @param row  The row of the light location
     * @param col  The column of the light location
     * @param grid The game board
     * @return Turns light at location on if it was off and off it was on and
     *         returns true. Returns false without changing the board if the
     *         location was invalid.
     */
    public static boolean toggleSingleLight(int row, int col, boolean[][] grid) {
        // check if the cell is valid
        if (row < 0 || row >= numRows(grid) || col < 0 || col >= numCols(grid)) return false;
        grid[row][col] = !grid[row][col];
        return true;
    }

    /**
     * Toggle the status of a light and its neighbors, if possible, and
     * return how many lights were toggled.
     *
     * @param row  The row of the light location
     * @param col  The column of the light location
     * @param puzzle The game board
     * @return Toggles on/off status of light and its vertical and horizontal
     *         neighbors and returns number of lights toggled. Returns 0 without
     *         changing the board if the location was invalid.
     */
    public static int toggleLightWithNeighbors(int row, int col, boolean[][] puzzle) {
        // check if the cell is valid
        if (row < 0 || row >= numRows(puzzle) || col < 0 || col >= numCols(puzzle)) return 0;

        // check which neighbors are valid
        // if the row is not 0, then north should be true
        // in the col is not the last one, then east should be true 
        // if the row is not the last one, then south should be true
        // if the col is not 0, then west should be true
        boolean[] validDirs = new boolean[]{row != 0, col != (numCols(puzzle) - 1), row != (numRows(puzzle) - 1), col != 0};

        toggleSingleLight(row, col, puzzle);
        if (validDirs[0]) toggleSingleLight(row - 1, col, puzzle);
        if (validDirs[1]) toggleSingleLight(row, col + 1, puzzle);
        if (validDirs[2]) toggleSingleLight(row + 1, col, puzzle);
        if (validDirs[3]) toggleSingleLight(row, col - 1, puzzle);

        int res = 1;
        for (boolean b : validDirs) {
            if (b) res++;
        }
        return res;
    }

    /**
     * Selects a random location on the board and toggles it with its neighbors.
     * @param board The game board.
     * @return Number of lights toggled
     */
    public static int toggleRandomLocationWithNeighbors(boolean[][] board) {
        Random random = new Random();
        int row = random.nextInt(0, numRows(board));
        int col = random.nextInt(0, numCols(board));

        return toggleLightWithNeighbors(row, col, board);
    }

    /**
     * Create a random solvable puzzle of desired size.
     *
     * To make a solvable puzzle, turn on lights by toggling a random location
     * with its neighbors. (The solution will be to toggle those same positions.)
     * Toggle roughly half the locations. (It's okay if you toggle the same place
     * more than once, undoing your earlier random toggle.)
     *
     * @param rows Number of rows
     * @param cols Number of columns
     * @return Game board with some lights turned on.
     */
    public static boolean[][] createRandomPuzzle(int rows, int cols) {
        boolean[][] game = createEmptyPuzzle(rows, cols);
        int numCellsToSwitch = (rows * cols) / 2;
        for (int i = 0; i < numCellsToSwitch; i++) {
            toggleRandomLocationWithNeighbors(game);
        }

        return game;
    }

    /** Creates puzzle array and starts game GUI. */
    public static void main(String[] args) {
        boolean[][] b = createRandomPuzzle(DEFAULT_ROWS, DEFAULT_COLS);
        LightsOutGUI.showGUI(b);
    }
}
