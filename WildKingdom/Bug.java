/**
Bug class Wild Kingdom
@author Manuel & Nick
@version 2/5/19
*/
public class Bug implements Actor
{
   private Coord myLocation;
   private static char ourID = 'a';
	private char myID;


   /**
   default constructor
   */
   public Bug()
   {
      this(-1, -1);
      
      System.out.println("*** Bug() called");
   }
   
   /**
   constructor w/ params
   @param row the starting row
   @param col the starting col
   */
   public Bug(int row, int col)
   {
      System.out.println("*** Bug(row, col) called");
      myID = ourID;
      ourID++;
      myLocation = new Coord();
      myLocation.row = row;
      myLocation.col = col;     
   }
   
   /**
   updates the location with new values
   @param newRow the new row
   @param newCol the new col
   */
   public void setLocation(int newRow, int newCol)
   {
      System.out.println("*** Bug.updateLoc() called");
   
      myLocation.row = newRow;
      myLocation.col = newCol;
   }
   
   /**
   move to a new location
   @return true if successful, else false
   */
   public boolean move()
   {
      System.out.println("*** Bug.move() called");
      
      int rowChg = (int)(Math.random() * 3) - 1;
      int colChg = (int)(Math.random() * 3) - 1;
      
      int newRow = myLocation.row + rowChg;
      int newCol = myLocation.col + colChg;
         
      Coord newLoc = new Coord();
      newLoc.row = newRow;
      newLoc.col = newCol;
      
      return this.updateBoard(newLoc);
   }
   
   /**
   updates the board with my new position
   @param newLoc the new location
   @return true if successful update, else false
   */
   public boolean updateBoard(Coord newLoc)
   {
      WildBoard board = WildApp.getBoard();
      
      if(board == null)
      {
         return false;
      }
      else if(board.moveTo(this, newLoc) == true)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   
   /**
   gets the symbol for this actor
   @return a one-letter unique symbol
   */
   public String getSymbol()
   {
      // System.out.println("*** Bug.getSymbol() called");
      return "" + myID;
   }
   
   /**
   gets a copy of the location of this actor
   @return myLocation
   */
   public Coord getLocation()
   {
      System.out.println("*** Bug.getLocation() called");
      
      Coord loc = new Coord();
      loc.row = myLocation.row;
      loc.col = myLocation.col;
      
      return loc;
   }
   
   /**
   returns string containing object vars
   @return a string containing myLocation
   */
   public String toString()
   {
      System.out.println("*** Bug.toString() called");
   
      String out = this.getSymbol() + "("
         + myLocation.row + ","
         + myLocation.col + ")";
   
      return out;
   }   

   public static void main(String[] args)
   {
      WildApp app = new WildApp();
   
      Bug test = new Bug();
      System.out.println(test);
      
      Bug test2 = new Bug(3, 4);
      System.out.println(test2);   
   
      test.setLocation(4, 6);      
      System.out.println(test);
      System.out.println(test.getLocation());
      
      System.out.println(test.getSymbol());
      
      WildBoard board = WildApp.getBoard();
      board.add(test);
      test.move();
      System.out.println(test);
      
   }
}