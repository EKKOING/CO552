/**
A single ship for Battleship
@author Cici Bu and Nicholas Lorentzen
@version 01/09/2019
*/
public class BattleShip
{
   /** size of the ship */
   public static final int SHIP_SIZE = 4;

   /** coords of the ship */
   private Coord[] myCoords;
   
   /**
   This method serves as a default constructor
   */
   public BattleShip()
   {
      System.out.println("*** BattleShip() called");
      
   }
   
   /**
   creates new ship at a give loc
   @param row the row of the left-most square
   @param col the col of the left-most square
   */
   public BattleShip(int row, int col)
   {
      System.out.println("*** BattleShip(row, col) called");
   
      myCoords = new Coord[SHIP_SIZE];
      for(int count = 0; count < SHIP_SIZE; count++)
      {
         Coord temp = new Coord();
         temp.row = row;
         temp.col = col + count;
         temp.val = Coord.EMPTY;
         
         myCoords[count] = temp;
      }
      
   }
   /**
   Attempts to shoot given location and mark it as hit
   @param row the row of target
   @param col the col of target
   @return true if valid, false if failed
   */
   public boolean shootShip(int row, int col)
   {
      System.out.println("*** BattleShip.shootShip called");

			for(int count = 0; count < SHIP_SIZE; count++)
				{
					Coord coord = myCoords[count];
					if (coord.row == row && coord.col == col)
					{
						coord.val = 1;
						return true;
					}
				}
			return false;
   }
   /**
   Gets the value of a given target
   @param row the row of target
   @param col the col of target
   @return value of target or -1 if invalid
   */
   public int getVal(int row, int col)
   {
      System.out.println("*** BattleShip.getVal called");
			for(int count = 0; count < SHIP_SIZE; count++)
				{
					Coord coord = myCoords[count];
					if (coord.row == row && coord.col == col)
					{
						return coord.val;
					}
				}
			return -1;
   }
   
   /**
   Checks if the ship has been destroyed
   @return true for destroyed else false
   */   
   public boolean isShipDestroyed()
   {
      System.out.println("*** BattleShip.isShipDestroyed called");

			int hits = 0;
      for(int count = 0; count < SHIP_SIZE; count++)
			{
				Coord coord = myCoords[count];
				hits = hits + coord.val;
			}
			if (hits == SHIP_SIZE)
			{
				return true;
			}
			else
			{
      return false;
			}
   }
   
   /**
   Converts the object to a string
   @return the string value of the object
   */
   public String toString()
   {
      System.out.println("*** BattleShip.toString called");
      String output = "Battleship";
      for(int count = 0; count < SHIP_SIZE; count++)
      {
				Coord coord = myCoords[count];
				output = output + "[" + coord.row + ", " + coord.col + ", " + coord.val + "]";
      }
      return output;
   }

   public static void main(String[] args)
   {
      BattleShip test = new BattleShip();
      System.out.println(test);
      
      // uncomment this code when methods are implemented
      BattleShip test2 = new BattleShip(2, 4);
      System.out.println(test2);
      System.out.println(test2.isShipDestroyed());
      
      test2.shootShip(2, 5);
      System.out.println(test2);
      System.out.println(test2.isShipDestroyed());
      
      int val;
      val = test2.getVal(2, 4);
      System.out.println("val of (2, 4) = " + val);
      
      val = test2.getVal(3, 4);
      System.out.println("val of (3, 4) = " + val);
      
      test2.shootShip(2, 4);
      test2.shootShip(2, 6);
      test2.shootShip(2, 7);
      System.out.println(test2);
      System.out.println(test2.isShipDestroyed());
   }
}