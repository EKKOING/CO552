/**
Coord Class in Wild Kingdom!
@author Manuel & Nick
@version 2/5/19
*/
public class Coord
{
   /** Coord is empty */
   public static final int EMPTY = 0;
   
   /** Coord has been shot for a hit */
   public static final int HIT = 1;
   
   /** Coord has been shot for a miss */
   public static final int MISS = 2;
   
   /** 
   handy array for printing the board 
   (note that symbol index corresponds to EMPTY, HIT, or MISS)
   */
   public static final String[] SYMBOL = { "-", "H", "M" };

   /** row of the coord */
   public int row;
   
   /** col of the coord */
   public int col;
   
   /** val of the coord (a */
   public int val;
   
   /**
   returns the coord as a string
   @return values of row, col, val
   */
   public String toString()
   {
      return "[" + row + "," + col + "," + val + "]";
   }
}