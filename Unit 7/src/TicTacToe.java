import javax.swing.*;

/**
 * Follow up to the TicTacToe program from Unit 6. This program allows two players to play TicTacToe against each other. It adds a new gui to the program.
 * @see "Unit 6/src/TicTacToe.java"
 * @author jacob5257
 * @version 1.0
 */
public class TicTacToe {
    public static void main(String[] args) { //skipcq: JAVA-R1000
        // Create a board with positions 1-9 for the players to choose
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        Object[] options = {"Single-player mode", "Multi-player mode", "Single-player with improved computer"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select a game mode: "));
        // Ask if they want to play against someone else or against the computer
        int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
        // If they select multiplayer mode, allow both players to take turns
        if (selection == 1) {
            // Keep going as long as nobody has won
            while (playerHasWon(board) == ' ') {
                // Asks the first player (x) where they want to go
                int nextPlace = printBoard(board);
                // If they enter an invalid number, they are told their input is invalid and their turn is skipped.
                if (nextPlace < 1 || nextPlace > 9) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    continue;
                }
                // Convert the number they entered into a row and column in the 2d array
                int row = (nextPlace - 1) / 3;
                int col = (nextPlace - 1) % 3;
                // If the position they selected is already occupied, they are told the position is already occupied and their turn is skipped.
                if (board[row][col] == 'x' || board[row][col] == 'o') {
                    JOptionPane.showMessageDialog(null, "Position already occupied!");
                    continue;
                }
                // Mark the new spot as x and check if anyone has won
                board[row][col] = 'x';
                if (playerHasWon(board) != ' ') break;
                // Repeat the same process but for o
                nextPlace = printBoard(board);
                if (nextPlace < 1 || nextPlace > 9) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    continue;
                }
                row = (nextPlace - 1) / 3;
                col = (nextPlace - 1) % 3;
                if (board[row][col] == 'x' || board[row][col] == 'o') {
                    JOptionPane.showMessageDialog(null, "Position already occupied!");
                    continue;
                }
                board[row][col] = 'o';
                if (playerHasWon(board) != ' ') break;
            }
        }
        else if (selection == 2) {
            while (playerHasWon(board) == ' ') {
                // Asks the first player (x) where they want to go
                int nextPlace = printBoard(board);
                // If they enter an invalid number, they are told their input is invalid and their turn is skipped.
                if (nextPlace < 1 || nextPlace > 9) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    continue;
                }
                // Convert the number they entered into a row and column in the 2d array
                int row = (nextPlace - 1) / 3;
                int col = (nextPlace - 1) % 3;
                // If the position they selected is already occupied, they are told the position is already occupied and their turn is skipped.
                if (board[row][col] == 'x' || board[row][col] == 'o') {
                    JOptionPane.showMessageDialog(null, "Position already occupied!");
                    continue;
                }
                // Mark the new spot as x and check if anyone has won
                board[row][col] = 'x';
                if (playerHasWon(board) != ' ') break;
                // Let the computer select a random place to go

                // Check if there are any row, column, or diagonal where two of the three spots are occupied by o and the third is empty. If there is, go there.
                boolean selected = false;
                // Check rows and columns
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] != 'x') {
                        board[i][2] = 'o';
                        selected = true;
                        break;
                    }
                    if (board[i][0] == 'o' && board[i][2] == 'o' && board[i][1] != 'x') {
                        board[i][1] = 'o';
                        selected = true;
                        break;
                    }
                    if (board[i][1] == 'o' && board[i][2] == 'o' && board[i][0] != 'x') {
                        board[i][0] = 'o';
                        selected = true;
                        break;
                    }
                    if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] != 'x') {
                        board[2][i] = 'o';
                        selected = true;
                        break;
                    }
                    if (board[0][i] == 'o' && board[2][i] == 'o' && board[1][i] != 'x') {
                        board[1][i] = 'o';
                        selected = true;
                        break;
                    }
                    if (board[1][i] == 'o' && board[2][i] == 'o' && board[0][i] != 'x') {
                        board[0][i] = 'o';
                        selected = true;
                        break;
                    }
                }
                // Check diagonals
                if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] != 'x') {
                    board[2][2] = 'o';
                    selected = true;
                }
                if (board[0][0] == 'o' && board[2][2] == 'o' && board[1][1] != 'x') {
                    board[1][1] = 'o';
                    selected = true;
                }
                if (board[1][1] == 'o' && board[2][2] == 'o' && board[0][0] != 'x') {
                    board[0][0] = 'o';
                    selected = true;
                }
                if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] != 'x') {
                    board[2][0] = 'o';
                    selected = true;
                }
                if (board[0][2] == 'o' && board[2][0] == 'o' && board[1][1] != 'x') {
                    board[1][1] = 'o';
                    selected = true;
                }
                if (board[1][1] == 'o' && board[2][0] == 'o' && board[0][2] != 'x') {
                    board[0][2] = 'o';
                    selected = true;
                }
                // Check if there are any row, column, or diagonal where two of the three spots are occupied by x and the third is empty. If there is, go there.
                if (!selected) {
                    // Check rows and columns
                    for (int i = 0; i < 3; i++) {
                        if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] != 'o') {
                            board[i][2] = 'o';
                            selected = true;
                            break;
                        }
                        if (board[i][0] == 'x' && board[i][2] == 'x' && board[i][1] != 'o') {
                            board[i][1] = 'o';
                            selected = true;
                            break;
                        }
                        if (board[i][1] == 'x' && board[i][2] == 'x' && board[i][0] != 'o') {
                            board[i][0] = 'o';
                            selected = true;
                            break;
                        }
                        if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] != 'o') {
                            board[2][i] = 'o';
                            selected = true;
                            break;
                        }
                        if (board[0][i] == 'x' && board[2][i] == 'x' && board[1][i] != 'o') {
                            board[1][i] = 'o';
                            selected = true;
                            break;
                        }
                        if (board[1][i] == 'x' && board[2][i] == 'x' && board[0][i] != 'o') {
                            board[0][i] = 'o';
                            selected = true;
                            break;
                        }
                    }
                    // Check diagonals
                    if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] != 'o') {
                        board[2][2] = 'o';
                        selected = true;
                    }
                    if (board[0][0] == 'x' && board[2][2] == 'x' && board[1][1] != 'o') {
                        board[1][1] = 'o';
                        selected = true;
                    }
                    if (board[1][1] == 'x' && board[2][2] == 'x' && board[0][0] != 'o') {
                        board[0][0] = 'o';
                        selected = true;
                    }
                }
                // If there are no spots for an instant win or to prevent loss, then it will randomly select a spot.
                if (!selected) {
                    nextPlace = (int) (Math.random() * 9) + 1;
                    row = (nextPlace - 1) / 3;
                    col = (nextPlace - 1) % 3;
                    // Checks that the randomly selected spot is not already occupied and if it is, it will select a new spot.
                    while (board[row][col] == 'x' || board[row][col] == 'o') {
                        nextPlace = (int) (Math.random() * 9) + 1;
                        row = (nextPlace - 1) / 3;
                        col = (nextPlace - 1) % 3;
                    }
                    // Sets the board to the randomly selected spot.
                    board[row][col] = 'o';
                }
                // Checks if a player has won/tied
                if (playerHasWon(board) != ' ') break;
            }
        }
        // If they select single player mode, allow them to play against the computer
        else if (selection == 0) {
            while (playerHasWon(board) == ' ') {
                // Asks the first player (x) where they want to go
                int nextPlace = printBoard(board);
                // If they enter an invalid number, they are told their input is invalid and their turn is skipped.
                if (nextPlace < 1 || nextPlace > 9) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    continue;
                }
                // Convert the number they entered into a row and column in the 2d array
                int row = (nextPlace - 1) / 3;
                int col = (nextPlace - 1) % 3;
                // If the position they selected is already occupied, they are told the position is already occupied and their turn is skipped.
                if (board[row][col] == 'x' || board[row][col] == 'o') {
                    JOptionPane.showMessageDialog(null, "Position already occupied!");
                    continue;
                }
                // Mark the new spot as x and check if anyone has won
                board[row][col] = 'x';
                if (playerHasWon(board) != ' ') break;
                // Let the computer select a random place to go
                nextPlace = (int) (Math.random() * 9) + 1;
                row = (nextPlace - 1) / 3;
                col = (nextPlace - 1) % 3;
                while (board[row][col] == 'x' || board[row][col] == 'o') {
                    nextPlace = (int) (Math.random() * 9) + 1;
                    row = (nextPlace - 1) / 3;
                    col = (nextPlace - 1) % 3;
                }
                board[row][col] = 'o';
                if (playerHasWon(board) != ' ') break;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid selection!");
            System.exit(0);
        }
        if (playerHasWon(board) == 't') JOptionPane.showMessageDialog(null, "It's a tie!");
        else JOptionPane.showMessageDialog(null, "<html>" + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "<br>---------<br>" + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "<br>---------<br>" + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "<br>Player " + playerHasWon(board) + " has won!</html>");

    }

    /**
     * Prints the board and asks the player where they want to go.
     * @param board The current board state to print
     * @return The position the player wants to go
     */
    public static int printBoard(char[][] board) {
        // Print out the board
        String nextPlace = JOptionPane.showInputDialog("<html>" + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "<br>---------<br>" + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "<br>---------<br>" + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "<br><br>Where do you want to go?</html>");
        // Try to convert their input into an integer and return it, throwing an error if it isn't.
        try {
            return Integer.parseInt(nextPlace);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Input is not a number!");
        }
    }

    /**
     * Checks if anyone has won the game.
     * @param board The current board state
     * @return The character of the winning player, t if it is a tie, or a space if nobody has won yet.
     */
    public static char playerHasWon(char[][] board) { //skipcq: JAVA-R1000
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return board[i][0];
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return board[0][i];
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
        // Check ties
        for (int i = 0; i < 3; i++) {
            for (char c : board[i]) {
                // Because there is no win, check if there are any empty spaces left. If there is, declare no winner.
                if (c != 'x' && c != 'o') return ' ';
            }
        }
        // If there are no empty spaces left, declare a tie.
        return 't';
    }
}
