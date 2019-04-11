/**
Actor Interface in Wild Kingdom!
@author Manuel & Nick
@version 2/5/19
*/

public interface Actor
{
   /**
   sets location
   @param newRow the row for the actor
   @param newCol the col for the actor
   */
   public void setLocation(int newRow, int newCol);
   
   /** 
   moves 
   @return the success of the move
   */
   public boolean move();
   
   /** 
   gets symbol
   @return the symbol 
   */
   public String getSymbol();
   
   /** 
   gets location
   @return the coords of the actor 
   */
   public Coord getLocation();
   
}