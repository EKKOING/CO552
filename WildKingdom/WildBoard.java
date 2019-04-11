/**
contains the board for Wild Kingdom!
@author Manuel & Nick
@version 2/5/19
*/
public class WildBoard
{
   /** num of rows in board */
   public static final int BOARD_ROWS = 10;
   
   /** num of cols in board */
   public static final int BOARD_COLS = 10;
   
   /** symbol for an empty square */
   public static final String EMPTY = "-";
   
   // CREATE YOUR BOARD VARIABLE HERE
   /** the board array */
   private Actor[][] myBoard;

   /**
   default constructor
   */
   public WildBoard()
   {
      System.out.println("*** BattleBoard() called");
   
      myBoard = new Actor[BOARD_ROWS][BOARD_COLS];
   }
   
   /**
   adds an actor to the board
   @param theBug the actor to add
   @return true if successful (target square empty), else false
   */
   public boolean add(Actor theBug)
   {
      System.out.println("*** WildBoard.addBug() called");
   
      Coord loc = theBug.getLocation();
      
      if(myBoard[loc.row][loc.col] != null)
      {
         return false;
      }
      else
      {
         myBoard[loc.row][loc.col] = theBug;
         return true;
      }
   }
   
   /**
   moves an actor from one location to another
   @param act the actor to move
   @param newLoc the new location
   @return true if a successful move, else false
   */
   public boolean moveTo(Actor act, Coord newLoc)
   {
      System.out.println("*** WildBoard.moveTo() called");
   
      if(this.isLegal(newLoc.row, newLoc.col) == false)
      {
         return false;
      }
      else 
      {
         Coord oldLoc = act.getLocation();
         Actor whatsInOldLoc = myBoard[oldLoc.row][oldLoc.col];
         Actor whatsInNewLoc = myBoard[newLoc.row][newLoc.col];
      
         if(whatsInOldLoc == null)
         {
            return false;
         }
         else if(whatsInNewLoc != null)
         {
            return false;
         }
         else
         {
            myBoard[newLoc.row][newLoc.col] = act;
            myBoard[oldLoc.row][oldLoc.col] = null;
            act.setLocation(newLoc.row, newLoc.col);
            return true;
         }        
      }
   
   
   }
   
   /**
   gets the actor in a board square
   @param row the row of the square
   @param col the col of the square
   @return myBoard[row][col], or null if coord is invalid or empty
   */
   public Actor getSquare(int row, int col)
   {
      System.out.println("*** WildBoard.getSquare() called");
   
      if(this.isLegal(row, col))
      {
         return myBoard[row][col];
      }
      else 
      {
         return null;
      }      
   }
   
   /**
   checks to see if a given coord is in bounds
   @param row the row of the coord
   @param col the col of the coord
   @return true if in bounds, else false
   */
   public boolean isLegal(int row, int col)
   {
      System.out.println("*** WildBoard.isLegal() called");
   
      if(0 <= row && row < BOARD_ROWS
         && 0 <= col && col < BOARD_COLS)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
   prints the board
   */
   public void printBoard()
   {
      System.out.println("*** WildBoard.printBoard() called");
   
      for(int row = 0; row < BOARD_ROWS; row++)
      {
         for(int col = 0; col < BOARD_COLS; col++)
         {
            if(myBoard[row][col] != null)
            {
               System.out.print(myBoard[row][col].getSymbol() + " ");
            }
            else
            {
               System.out.print(WildBoard.EMPTY + " ");
            }
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args)
   {
      WildApp app = new WildApp();
      
      Bug act = new Bug(3, 5);
      System.out.println(act);
      
      WildBoard test = WildApp.getBoard();
      test.printBoard();
      
      test.add(act);
      test.printBoard();
      
      for(int count = 1; count <= 20; count++)
      {
      
         act.move();
         System.out.println(act);
         test.printBoard();
      }
   }
}