import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * This is the graphical user interface for the Lights Out game.
 *
 * The code in this class assumes that methods in LightsOutGame.java
 * are working.
 */
public class LightsOutGUI {

    private static final Color LIGHT_OFF = Color.BLACK;
    private static final Color LIGHT_ON = Color.YELLOW.brighter();

    /**
     * Construct and display GUI for a Lights Out game.
     * @param gameBoard The initial game board
     */
    public static void showGUI(boolean[][] gameBoard) {
        // For thread safety, invoke GUI code on event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LightsOutGUI gui =
                        new LightsOutGUI(gameBoard);
            }
        });
    }

    /**
     * Class used to draw the game board.
     */
    private class BoardPanel extends JPanel {

        public int getRowHeight() {
            int rows = LightsOutGame.numRows(board);
            return rows != 0 ? getHeight() / rows : 0;
        }

        public int getColumnWidth() {
            int cols = LightsOutGame.numCols(board);
            return cols != 0 ? getWidth() / cols : 0;
        }

        @Override
        public void paintComponent( Graphics g ) {
            super.paintComponent(g);

            int rowHeight = getRowHeight();
            int colWidth = getColumnWidth();
            int rowOffset = Math.min(5, rowHeight/10);
            int colOffset = Math.min(5, colWidth/10);

            for(int row = 0; row < LightsOutGame.numRows(board); row++) {
                for (int col = 0; col < LightsOutGame.numCols(board); col++) {
                    boolean b = board[row][col];
                    Color color = b ? LIGHT_ON : LIGHT_OFF;
                    g.setColor(color);
                    g.fillRect( col * colWidth + colOffset,
                            row * rowHeight + rowOffset,
                            colWidth - 2*colOffset,
                            rowHeight - 2*rowOffset);
                }
            }
        }
    }

    /** Array for the game board. */
    private boolean[][] board;
    private int moves = 0;

    // GUI components
    private final JFrame boardFrame;
    private final BoardPanel boardPanel;
    private final JLabel statusLabel;

    /**
     * Handles a mouse click on the board.
     * @param x X position of the click
     * @param y Y position of the click
     */
    private void doMouseClick(int x, int y) {
        int row = y / boardPanel.getRowHeight();
        int column = x / boardPanel.getColumnWidth();

        int toggled = LightsOutGame.toggleLightWithNeighbors(row, column, board);
        if (toggled > 0) {
            moves++;
        } else {
            System.out.println("failed move at row + " + row + " column " + column);
        }
        boardFrame.repaint();

        updateStatusLabel();
    }


    /** Update label under board. */
    private void updateStatusLabel() {
        String solveMsg = LightsOutGame.isPuzzleSolved(board) ? "SOLVED! " : "";
        statusLabel.setText("<html><h3>" + solveMsg + "Number of moves: " + moves + "</h3>");
    }

    private void newGame(boolean[][] board) {
        this.board = board;
        boardPanel.repaint();
        moves = 0;
        updateStatusLabel();
    }

    private void newGame(int rows, int cols, boolean empty) {
        boolean[][] grid = empty ?
                LightsOutGame.createEmptyPuzzle(rows, cols) :
                LightsOutGame.createRandomPuzzle(rows, cols);
        newGame(grid);
    }

    /**
     * Constructor for the GUI.
     */
    private LightsOutGUI() {
        this(LightsOutGame.DEFAULT_ROWS, LightsOutGame.DEFAULT_COLS);
    }

    private LightsOutGUI(int numRows, int numCols) {
        this(LightsOutGame.createRandomPuzzle(numRows, numCols));
    }

    private LightsOutGUI(boolean[][] gameBoard) {


        boardFrame = new JFrame();
        boardFrame.setTitle("Lights Out");

        int numRows = LightsOutGame.numRows(gameBoard);
        int numCols = LightsOutGame.numCols(gameBoard);
        int maxDim = Collections.max(Arrays.asList(9, numRows, numCols));

        JPanel controlPanel = new JPanel();
        JComboBox<Integer> rows = new JComboBox<>(IntStream.rangeClosed(2,maxDim).boxed().toArray(Integer[]::new));
        rows.setSelectedItem(numRows);
        controlPanel.add(rows);
        JComboBox<Integer> cols = new JComboBox<>(IntStream.rangeClosed(2,maxDim).boxed().toArray(Integer[]::new));
        cols.setSelectedItem(numCols);
        controlPanel.add(cols);
        JButton newGameButton = new JButton("New Puzzle");
        newGameButton.addActionListener(event -> newGame((Integer)rows.getSelectedItem(),
                (Integer)cols.getSelectedItem(), false));
        controlPanel.add(newGameButton);
        JButton emptyGameButton = new JButton("Empty Board");
        emptyGameButton.addActionListener(event -> newGame((Integer)rows.getSelectedItem(),
                (Integer)cols.getSelectedItem(), true));
        controlPanel.add(emptyGameButton);

        boardPanel = new BoardPanel();
        boardPanel.setPreferredSize( new Dimension(500, 500) );
        boardPanel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed( MouseEvent e ) {
                int x = e.getX();
                int y = e.getY();
                doMouseClick(x, y);
            }
        });

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel();
        statusPanel.add(statusLabel);

        boardFrame.add(controlPanel, BorderLayout.PAGE_START);
        boardFrame.add(boardPanel, BorderLayout.CENTER);
        boardFrame.add(statusPanel, BorderLayout.PAGE_END);

        newGame(gameBoard);

        boardFrame.pack();
        boardFrame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        boardFrame.setLocationRelativeTo ( null );
        //boardFrame.setResizable ( false );
        boardFrame.setVisible ( true );
    }

    public static void main(String[] args) {
        showGUI(LightsOutGame.createRandomPuzzle(LightsOutGame.DEFAULT_ROWS, LightsOutGame.DEFAULT_COLS));
    }
}
