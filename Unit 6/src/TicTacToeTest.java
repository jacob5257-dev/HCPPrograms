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
         System.out.println(game);                     // calls game.toString( )
         
         String input = JOptionPane.showInputDialog("Row for " + player + " (Cancel to exit)");
         
         if (input == null)               // quit the game?
            System.exit(0);
         int row = Integer.parseInt(input);
         
         input = JOptionPane.showInputDialog("Column for " + player);
         int column = Integer.parseInt(input);
         
         game.set(row, column, player);   // make a move
         
 
         if (player == 'x')               // toggle the player
            player = 'o';
         else
            player = 'x';
      }
   }
}

