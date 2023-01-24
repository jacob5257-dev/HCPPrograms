import javax.swing.JOptionPane;

/***************************************************************
   This program tests the TicTacToe class by prompting the user
   to set positions on the board and printing out the result.
****************************************************************/
public class TicTacToeTest
{
   public static void main(String[] args)
   {
      char player = 'x';                  // X gets the first move
      
      TicTacToe game = new TicTacToe( );
      while (true)
      {
         /* 
         System.out.println(game);                     // calls game.toString( )
         
         String input = JOptionPane.showInputDialog("Row for " + player + " (Cancel to exit)");
         
         if (input == null)               // quit the game?
            System.exit(0);
         int row = Integer.parseInt(input);
         
         input = JOptionPane.showInputDialog("Column for " + player);
         int column = Integer.parseInt(input);
         */
        // Create a JOptionPane with buttons corresponding to the 3x3 grid. If a player is occupying that cell in the 3x3 grid, the button will be disabled. Allow the user to click on a button to make a move.
         Object[] options = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
         int n = JOptionPane.showOptionDialog(null, "Choose a cell", "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         int row = n / 3;
         int column = n % 3;
         game.set(row, column, player);   // make a move
         char winner = game.playerHasWon();
         if (winner != ' ')
         {
            System.out.println(game);
            JOptionPane.showMessageDialog(null, winner + " has won");
            //Ask player if they want to play again
            int playAgain = JOptionPane.showConfirmDialog(null, "Play again?", "Play again?", JOptionPane.YES_NO_OPTION);
            if (playAgain == JOptionPane.YES_OPTION) {
                game = new TicTacToe();
                player = 'x';
            } else System.exit(0);
         }

 
         if (player == 'x')               // toggle the player
            player = 'o';
         else
            player = 'x';
      }
   }
}

