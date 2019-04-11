import java.util.Scanner;

/**
runs the game
@author Cici Bu and Nicholas Lorentzen
@version January 24th,2018
*/
public class BattleGame
{
   /** my game board */
   private BattleBoard myBoard;
   
   /** my list of ships */
   private BattleList myList;
   
   /** single ship for one-ship game */
   private BattleShip myShip;
   
   /** number of moves in the game */
   private int myNumMoves;

   public void run()
   {
      System.out.println("*** BattleGame.run called");
      
      this.resetGame();
      
      while(this.isGameOver() == false)
      {
         System.out.println(myList);
         myBoard.printBoard();
      
         myNumMoves++;
         this.takeShot();
      }
      
      System.out.println();
      myBoard.printBoard();
      System.out.println("Congratulations, you win!");
      System.out.println("It took you " + myNumMoves + " moves.");
   }
   
   /**
   starts a new game
   */
   public void resetGame()
   {
      System.out.println("*** BattleGame.resetGame called");
      
      myNumMoves = 0;
      this.placeShips();
      
   }
   
   /**
   places the ships in random spots
   */
   public void placeShips()
   {
      System.out.println("*** BattleGame.placeShips called");
      
      myList = new BattleList();
      myBoard = new BattleBoard();
      
      
      int maxRow = (BattleBoard.BOARD_ROWS);
      int maxCol = (BattleBoard.BOARD_COLS - BattleShip.SHIP_SIZE);   
   	
      int row = (int) (Math.random() * maxRow + 1);
      int col = (int) (Math.random() * maxCol + 1);
   	
      BattleShip shipOne = new BattleShip(row, col);
      myList.addShip(shipOne);
   	
      int row2 = (int) (Math.random() * maxRow + 1);
   	
      int col2 = (int) (Math.random() * maxCol + 1);
      while(col2 == col)
      {
         col2 = (int) (Math.random() * maxCol + 1);
      }
   	
      BattleShip shipTwo = new BattleShip(row2, col2);
      myList.addShip(shipTwo);
      
   }
   
   /**
   checks to see if the game is over
   @return true if game over, else false
   */
   public boolean isGameOver()
   {
      System.out.println("*** BattleGame.isGameOver called");
      return myList.isListDestroyed();
   }
   
   /**
   makes a shot in an empty square
   */
   public void takeShot()
   {
      System.out.println("*** BattleGame.takeShot called");
      
      Scanner reader = new Scanner(System.in);
      
      boolean done = false;
      while(done == false)
      {
         System.out.print("Enter row: ");
         int row = new Integer(reader.nextLine());
         System.out.print("Enter col: ");
         int col = new Integer(reader.nextLine());
         
         System.out.println("Move at (" + row + "," + col + ")");
         
         if(this.isLegalMove(row, col) == true)
         {
            System.out.println("Move is legal");
            this.makeMove(row, col);
            done = true;
         }
         else
         {
            System.out.println("Move is not legal");
         }
      }
   }
   
   /**
   checks to see if a move is legal
   @param row the row of the move
   @param col the col of the move
   @return true if square is empty, else false
   */
   public boolean isLegalMove(int row, int col)
   {
      System.out.println("*** BattleGame.isLegalMove called");
      
      if (col < 8 && row < 8)
      {
         return true;
      }
      return false;
   }
   
   /**
   makes a move at a given empty square
   (updates both board and ship list)
   @param row the row of the move
   @param col the col of the move
   */
   public void makeMove(int row, int col)
   {
      System.out.println("*** BattleGame.makeMove called");
      
      if(myList.shootList(row, col) == true)
      {
         myBoard.setSquare(row, col, Coord.HIT);
      }
      else
      {
         myBoard.setSquare(row, col, Coord.MISS);
      }
   }
}