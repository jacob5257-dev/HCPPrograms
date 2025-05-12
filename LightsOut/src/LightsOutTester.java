/**
 * Class to test the LightsOutGame methods.
 * If your code does not pass these tests, it is broken.
 *
 * It is possible that your code is broken even if it passes these
 * tests, so make sure the game plays properly, too.
 */
public class LightsOutTester {
    private static int correctTests = 0;
    private static int totalTests = 0;

    /** Clear test count variables */
    private static void clearCounts() {
        correctTests = 0;
        totalTests = 0;
    }

    /**
     * Update test count variables depending on if test passed.
     * @param correct True if test counts as correct.
     */
    private static boolean countTest(boolean correct) {
        if(correct) {
            correctTests++;
        } else {
            // Uncomment next line of code to see which test(s) are failing,
            // but don't do it unless you are only failing a few
            new Exception().printStackTrace(System.out);
            System.exit(0);
        }
        totalTests++;

        // return the test result so we can use it in branches
        return correct;
    }

    /**
     * Print the testing results.
     * @param name The name of the method(s) tested.
     */
    private static void printResults(String name) {
        String msg = "";
        if(correctTests < totalTests) {
            // I want failed tests to really jump out at you.
            msg = " INCORRECT!";
        }
        System.out.println("testing " + name + ": passes " +
                correctTests + " of " + totalTests + " tests" + msg);
    }

    /**
     * Test that gridToString gives expected result for given lights out game.
     * @param grid Game state
     * @param expected The expected result of gridToString
     */
    public static void testGridToString(boolean[][] grid, String expected) {
        String s = LightsOutGame.gridToString(grid);
        countTest(s != null && s.equals(expected));
    }

    /**
     * Test that numRows and numCols give expected values
     * @param grid Game state
     * @param rows Expected number of rows
     * @param cols Expected number of columns
     */
    public static void testSize(boolean[][] grid, int rows, int cols) {
        countTest(LightsOutGame.numRows(grid) == rows);
        countTest(LightsOutGame.numCols(grid) == cols);
    }

    /**
     * Test several methods at once for basic game state
     * (rows, cols, gridToString, solved state)
     * @param grid Game state
     * @param rows Expected number of rows
     * @param cols Expected number of columns
     * @param solved Expected solved status
     * @param expectedStr Expected string representation
     */
    public static void testStatus(boolean[][] grid, int rows, int cols,
                                  boolean solved, String expectedStr) {
        if(countTest(grid != null)) {
            testSize(grid, rows, cols);
            testGridToString(grid, expectedStr);
            countTest(LightsOutGame.isPuzzleSolved(grid) == solved);
        }
    }

    /**
     * Make some empty grids to make sure the status methods perform as expected.
     */
    public static void testEmptyPuzzles() {

        boolean[][] g34 = LightsOutGame.createEmptyPuzzle(3, 4);
        testStatus(g34, 3, 4, true,
                "----\n----\n----\n");

        boolean[][] g52 = LightsOutGame.createEmptyPuzzle(5, 2);
        testStatus(g52, 5, 2, true,
                "--\n--\n--\n--\n--\n");

        boolean[][] g22 = LightsOutGame.createEmptyPuzzle(2, 2);
        testStatus(g22, 2, 2, true,"--\n--\n");

        boolean[][] g55 = LightsOutGame.createEmptyPuzzle(5, 5);
        testStatus(g55, 5, 5, true,
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n");

    }

    /**
     * Try toggling one light at a time
     */
    public static void testSingleToggle() {
        boolean[][] g34 = LightsOutGame.createEmptyPuzzle(3, 4);
        countTest(!LightsOutGame.toggleSingleLight(-1, 0, g34));
        countTest(!LightsOutGame.toggleSingleLight(0, -3, g34));
        countTest(!LightsOutGame.toggleSingleLight(3, 0, g34));
        countTest(!LightsOutGame.toggleSingleLight(0, 4, g34));
        testStatus(g34, 3, 4, true,
                "----\n----\n----\n");
        countTest(LightsOutGame.toggleSingleLight(0, 3, g34));
        testStatus(g34, 3, 4, false,
                "---*\n----\n----\n");
        countTest(LightsOutGame.toggleSingleLight(0, 3, g34));
        testStatus(g34, 3, 4, true,
                "----\n----\n----\n");
        countTest(LightsOutGame.toggleSingleLight(2, 1, g34));
        testStatus(g34, 3, 4, false,
                "----\n----\n-*--\n");

        boolean[][] g55 = LightsOutGame.createEmptyPuzzle(5, 5);
        countTest(!LightsOutGame.toggleSingleLight(-1, 0, g55));
        countTest(!LightsOutGame.toggleSingleLight(0, -3, g55));
        countTest(!LightsOutGame.toggleSingleLight(5, 0, g55));
        countTest(!LightsOutGame.toggleSingleLight(0, 6, g55));
        testStatus(g55, 5, 5, true,
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleSingleLight(0, 3, g55));
        testStatus(g55, 5, 5, false,
                   "---*-\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleSingleLight(2, 1, g55));
        testStatus(g55, 5, 5, false,
                   "---*-\n" +
                   "-----\n" +
                   "-*---\n" +
                   "-----\n" +
                   "-----\n");

    }

    /**
     * Test toggling a light with neighbors
     */
    public static void testToggleWithNeighbors() {
        boolean[][] g34 = LightsOutGame.createEmptyPuzzle(3, 4);
        countTest(LightsOutGame.toggleLightWithNeighbors(-1, 0, g34) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(0, -3, g34) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(3, 0, g34) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(0, 4, g34) == 0);
        testStatus(g34, 3, 4, true,
                "----\n----\n----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(0, 3, g34) == 3);
        testStatus(g34, 3, 4, false,
                "--**\n---*\n----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(0, 3, g34) == 3);
        testStatus(g34, 3, 4, true,
                "----\n----\n----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(2, 1, g34) == 4);
        testStatus(g34, 3, 4, false,
                "----\n-*--\n***-\n");

        boolean[][] g55 = LightsOutGame.createEmptyPuzzle(5, 5);
        countTest(LightsOutGame.toggleLightWithNeighbors(-1, 0, g55) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(0, -3, g55) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(5, 0, g55) == 0);
        countTest(LightsOutGame.toggleLightWithNeighbors(0, 6, g55) == 0);
        testStatus(g55, 5, 5, true,
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(0, 3, g55) == 4);
        testStatus(g55, 5, 5, false,
                   "--***\n" +
                   "---*-\n" +
                   "-----\n" +
                   "-----\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(2, 1, g55) == 5);
        testStatus(g55, 5, 5, false,
                   "--***\n" +
                   "-*-*-\n" +
                   "***--\n" +
                   "-*---\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(1, 2, g55) == 5);
        testStatus(g55, 5, 5, false,
                   "---**\n" +
                   "--*--\n" +
                   "**---\n" +
                   "-*---\n" +
                   "-----\n");
        countTest(LightsOutGame.toggleLightWithNeighbors(2, 0, g55) == 4);
        testStatus(g55, 5, 5, false,
                   "---**\n" +
                   "*-*--\n" +
                   "-----\n" +
                   "**---\n" +
                   "-----\n");

    }

    /**
     * Try randomly toggling single location with neighbors
     */
    public static void testRandomLocation() {
        // only one possible result on tiny puzzles
        boolean[][] g1 = LightsOutGame.createEmptyPuzzle(1, 1);
        testStatus(g1, 1, 1, true, "-\n");
        int n1 = LightsOutGame.toggleRandomLocationWithNeighbors(g1);
        testStatus(g1, 1, 1, false, "*\n");
        countTest(n1 == 1);

        boolean[][] g2 = LightsOutGame.createEmptyPuzzle(1, 2);
        testStatus(g2, 1, 2, true, "--\n");
        int n2 = LightsOutGame.toggleRandomLocationWithNeighbors(g2);
        testStatus(g2, 1, 2, false, "**\n");
        countTest(n2 == 2);

        // 2x2 grid always toggles 3 lights
        boolean[][] g3 = LightsOutGame.createEmptyPuzzle(2,2);
        testStatus(g3, 2, 2, true, "--\n--\n");
        int n3 = LightsOutGame.toggleRandomLocationWithNeighbors(g3);
        countTest(!LightsOutGame.isPuzzleSolved(g3));
        countTest(n3 == 3);

        int[] rowsToTest = {2, 5, 9};
        int[] colsToTest = {3, 5, 8};
        int n = 1000;
        for(int rows : rowsToTest) {
            for (int cols : colsToTest) {
                java.util.Set<String> configs = new java.util.HashSet<>();
                for (int i = 0; i < n; i++) {
                    boolean[][] g = LightsOutGame.createEmptyPuzzle(rows, cols);
                    countTest(LightsOutGame.isPuzzleSolved(g));
                    if (countTest(g != null)) {
                        LightsOutGame.toggleRandomLocationWithNeighbors(g);
                        countTest(!LightsOutGame.isPuzzleSolved(g));
                        String s = LightsOutGame.gridToString(g);
                        if (countTest(s != null)) {
                            configs.add(s);
                        }
                    }
                }
                int expectedConfigs = rows * cols;
                countTest(configs.size() == expectedConfigs);
            }
        }
    }

    /**
     * Recursively solve puzzle, assuming all lights have been toggled as
     * necessary up to given position.
     * @param grid Partially solved puzzle
     * @param row Row of next position
     * @param col Column of next position
     * @return Number of lights needed to toggle to solve the puzzle,
     *         or -1 if not solvable.
     */
    private static int solveCount(boolean[][] grid, int row, int col) {
        int rows = LightsOutGame.numRows(grid);
        int cols = LightsOutGame.numCols(grid);
        if(LightsOutGame.isPuzzleSolved(grid)) {
            return 0;
        }
        if(row > 0 && col > 0 && grid[row - 1][col - 1]) return -1;
        if(row > 1 && grid[row - 2][cols - 1]) return -1;
        if(row == rows) return -1;
        if(col == cols) return solveCount(grid, row + 1, 0);

        int toggled = solveCount(grid, row, col + 1);
        if(toggled < 0) {
            LightsOutGame.toggleLightWithNeighbors(row, col, grid);
            toggled = solveCount(grid, row, col + 1);
            LightsOutGame.toggleLightWithNeighbors(row, col, grid);
            if(toggled >= 0) {
                toggled++;
            }
        }

        return toggled;
    }

    /**
     * Test that a randomly generated puzzle is the correct size and solvable
     * @param rows Number of rows
     * @param cols Number of columns
     * @return Number of toggles needed to solve the random puzzle or -1 if not solvable
     */
    public static int testRandomPuzzle(int rows, int cols) {
        boolean[][] puzzle = LightsOutGame.createRandomPuzzle(rows, cols);
        if(countTest(puzzle != null)) {
            testSize(puzzle, rows, cols);
            int n = solveCount(puzzle, 0, 0);
            countTest(n >= 0);
            return n;
        }
        return -1;
    }

    public static void testRandomPuzzles() {
        // Make sure an empty puzzle is trivially solved first
        boolean[][] empty = LightsOutGame.createEmptyPuzzle(9, 5);
        if(countTest(empty != null)) {
            int toggles = solveCount(empty, 0, 0);
            countTest(toggles == 0);
        }

        // Verify that some random puzzles are solvable with expected
        // number of lights toggled
        int[] rowsToTest = {2, 5, 9};
        int[] colsToTest = {3, 5, 8};
        int n = 1000;
        for(int rows : rowsToTest) {
            for(int cols : colsToTest) {
                int total = 0;
                for(int i = 0; i < n; i++){
                    total += testRandomPuzzle(rows, cols);
                }
                // we expect to toggle roughly half the lights each time, so
                // after many trials the actual total should be close to that
                double expectedTotal = rows*cols/2.0*n;
                countTest(total >= expectedTotal*0.5);
                countTest(total <= expectedTotal*1.5);
            }
        }

    }
    

    /**
     * Test various LightsOut methods
     * @param args Ignored
     */
    public static void main(String[] args) {
        // Note: each of these test methods tests multiple methods from
        // LightsOutGame, so look at the testing code to see what methods
        // are being called and might be causing something to fail.
        
        clearCounts();
        testEmptyPuzzles();
        printResults("empty puzzles");

        clearCounts();
        testSingleToggle();
        printResults("single toggle");

        clearCounts();
        testToggleWithNeighbors();
        printResults("toggle with neighbors");

        clearCounts();
        testRandomLocation();
        printResults("toggle random location");

        clearCounts();
        testRandomPuzzles();
        printResults("random solvable puzzles");
    }
}
