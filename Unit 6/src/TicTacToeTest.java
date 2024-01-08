import javax.swing.JOptionPane;

/***************************************************************
   This program tests the TicTacToe class by prompting the user
   to set positions on the board and printing out the result.
****************************************************************/
//skipcq: JAVA-W1088
public class TicTacToeTest {
   public static void main(String[] args) {
      char player = 'x';                  // X gets the first move
      
      TicTacToe game = new TicTacToe( );
      while (true) {
         System.out.println(game);                     // calls game.toString( )
         
         String input = JOptionPane.showInputDialog("Row for " + player + " (Cancel to exit)");
         
         if (input == null)               // quit the game?
            break;
         int row = Integer.parseInt(input);
         
         input = JOptionPane.showInputDialog("Column for " + player);
         int column = Integer.parseInt(input);
         
         game.set(row, column, player);   // make a move
         char winner = game.playerHasWon();
         if (winner != ' ' || game.isFull())
         {
            System.out.println(game);
            if (game.isFull()) JOptionPane.showMessageDialog(null, "It was a tie!");
            else JOptionPane.showMessageDialog(null, winner + " has won");
            //Ask player if they want to play again
            int playAgain = JOptionPane.showConfirmDialog(null, "Play again?", "Play again?", JOptionPane.YES_NO_OPTION);
            if (playAgain == JOptionPane.YES_OPTION) {
                game = new TicTacToe();
                player = 'x';
            } else break;
         }

 
         if (player == 'x')               // toggle the player
            player = 'o';
         else
            player = 'x';
      }
   }
}

