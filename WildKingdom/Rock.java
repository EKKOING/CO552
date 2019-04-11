/**
Rock in Wild Kingdom!
@author Manuel & Nick
@version 2/5/19
*/

public class Rock implements Actor
{
   private Coord myLocation;
   
   /**
   default constructor
   */
   public Rock()
   {
      this(-1, -1);
      
      System.out.println("*** Rock() called");
   }
   
   /**
   constructor w/ params
   @param row the starting row
   @param col the starting col
   */
   public Rock(int row, int col)
   {
      myLocation = new Coord();
      myLocation.row = row;
      myLocation.col = col; 
   
      System.out.println("*** Rock(row, col) called");        
   }
   
   /**
   updates the location with new values
   @param newRow the new row
   @param newCol the new col
   */
   public void setLocation(int newRow, int newCol)
   {
      System.out.println("*** Rock.updateLoc() called");
   
      myLocation.row = newRow;
      myLocation.col = newCol;
   }
   
   /**
   move to a new location
   @return true if successful, else false
   */
   public boolean move()
   {
      System.out.println("*** Rock.move() called");
      
      return true;
   }
   
   /**
   gets a copy of the location of this actor
   @return myLocation
   */
   public Coord getLocation()
   {
      System.out.println("*** Rock.getLocation() called");
      
      Coord loc = new Coord();
      loc.row = myLocation.row;
      loc.col = myLocation.col;
      
      return loc;
   }
   
   /**
   gets the symbol for this actor
   @return a one-letter unique symbol
   */
   public String getSymbol()
   {
      // System.out.println("*** Bug.getSymbol() called");
   
      return "*";
   }
   
   /**
   returns string containing object vars
   @return a string containing myLocation
   */
   public String toString()
   {
      System.out.println("*** Rock.toString() called");
   
      String out = this.getSymbol() + "("
         + myLocation.row + ","
         + myLocation.col + ")";
   
      return out;
   }

   public static void main(String[] args)
   {
      WildApp app = new WildApp();
   
      Rock test = new Rock();
      System.out.println(test);
      
      Rock test2 = new Rock(3, 4);
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