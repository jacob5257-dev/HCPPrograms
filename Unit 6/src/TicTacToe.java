/*****************************
A 3 x 3 Tic-Tac-Toe board.
******************************/
public class TicTacToe
{
/*****************************
   Constructs an empty board.
******************************/
public TicTacToe( )
{
   board = new char[ROWS][COLUMNS];
   
   // fill with spaces
   for (int i = 0; i < ROWS; i++)
      for (int j = 0; j < COLUMNS; j++)
         board[i][j] = ' ';
}

/***********************************************************
   Sets a field in the board. The field must be unoccupied.
   @param i the row index
   @param j the column index
   @param player the player ('x' or 'o')
************************************************************/
public void set(int i, int j, char player)
{
   if (board[i][j] != ' ')
      throw new IllegalArgumentException("Position occupied");
   board[i][j] = player;
}

/********************************************************
   Creates a string representation of the board such as
   |x  o|
   |  x |
   |   o|
   @return the string representation
*********************************************************/
public String toString( )
{
   String r = "";
   for (int i = 0; i < ROWS; i++)
   {
      r = r + "|";
      for (int j = 0; j < COLUMNS; j++)
         r = r + board[i][j];
      r = r + "|\n";
   }
   return r;
}

private char[ ][ ] board;
private static final int ROWS = 3;
private static final int COLUMNS = 3;
}


