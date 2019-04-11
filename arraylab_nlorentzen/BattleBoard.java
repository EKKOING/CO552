/**
contains the board
@author Cici Bu and Nicholas Lorentzen
@version January 24th,2018
*/
public class BattleBoard
{
   /** stores number of rows in board*/
   public static final int BOARD_ROWS = 8;
   
   /** stores number of columns in board*/
   public static final int BOARD_COLS = 8;
   
   /**the board array that stores all the x-coordinates and y-coordinates*/
   private Coord[][] myBoard;
   
   
   /** a constructor method that initializes 
   the values of all coordinates on myBoard to be EMPTY"_" */
   public BattleBoard()
   {
      System.out.println("*** BattleBoard() called");
   		
      myBoard = new Coord[BattleBoard.BOARD_ROWS][BattleBoard.BOARD_COLS];
      for(int row = 0; row < BattleBoard.BOARD_ROWS; row++)
      {
         for(int col = 0; col < BattleBoard.BOARD_COLS; col++)
         {
            Coord temp = new Coord();
            temp.row = row + 1;
            temp.col = col + 1;
            temp.val = Coord.EMPTY;
            
            myBoard[row][col] = temp;         }
      }
     
   }
   
   /**
   this method updates a square on the board
   @param row the row to update
   @param col the col to update
   @param val the val to assign
   @returns true if successful, else false
   */
   public boolean setSquare(int row, int col, int val)
   {
      System.out.println("*** BattleBoard.setSquare() called");
      if(myBoard.length > row && myBoard[row].length > col)
      {
         Coord s = myBoard[row][col];
         s.val = val;
         return true;
      }
   	
      return false;
   }
   
   
   /**
   This method gets the val of a board square
   @param row the row of the square
   @param col the column of the square
   @return myBoard[row][col].val which is the value of the square
      , or -1 if invalid coord
   */
   public int getSquare(int row, int col)
   {
      System.out.println("*** BattleBoard.getSquare() called");
   
      if(myBoard.length > row && myBoard[row].length > col)
      {
         return myBoard[row][col].val;
      }
      return -1;
       
   }
   
   
   /**
   This method prints the board
   */
   public void printBoard()
   {
      System.out.println("*** BattleBoard.printBoard() called");
   
      for(int row = 0; row < BOARD_ROWS; row++)
      {
         String print = "";
         for(int col = 0; col < BOARD_COLS; col++)
         {
            int temp = myBoard[row][col].val;
            if (temp == Coord.HIT)
            {
               print = print + "H";
            }
            else if (temp == Coord.MISS)
            {
               print = print + "M";
            }
            else if (temp == Coord.EMPTY)
            {
               print = print + "-";
            }
            print = print + " ";
         }
         System.out.println(print);
      }
   }

   public static void main(String[] args)
   {
      BattleBoard test = new BattleBoard();
   	
      test.printBoard();
   	
      System.out.println(test.getSquare(1, 10));
      System.out.println(test.getSquare(1, 1));
   	
      System.out.println(test.setSquare(1, 1, Coord.HIT));
      System.out.println(test.getSquare(1, 1));
      
   }
}