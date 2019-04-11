import java.util.ArrayList;

/**
list of all the ships
@author Cici Bu and Nicholas Lorentzen
@version 20180116
*/

public class BattleList
{  
   /** a list of all the ships */
   private ArrayList<BattleShip> battlelist;
   
   /** this method is a default constructor*/
   public BattleList()
   {
      System.out.println("*** BattleList() called");
      battlelist = new ArrayList<BattleShip>();
   }
   
   /**
   This method adds a single ship to the list
   @param ship the ship added to the list
   */
   public void addShip(BattleShip ship)
   {
      System.out.println("*** BattleList.addShip called");
   
      battlelist.add(ship);
   }
   
   
   /**
   This method allows the player to shoot a ship 
   in the list with a given coord
   @param row the row of the Coord to shoot
   @param col the column of the Coord to shoot
   @return true if at least one ship is hit, else false
   */
   public boolean shootList(int row, int col)
   {
      System.out.println("*** BattleList.shootList called");
   
      for (int count = 0; count < battlelist.size(); count++)
      {
         BattleShip test = battlelist.get(count);
         if (test.shootShip(row, col) == true)
         {
            battlelist.remove(count);
            battlelist.add(test);
            return true;
         }	
      }
      return false;
   }
   
   
   /**
   This method checks if the whole list is destroyed (all Coords hit)
   @return true if all Coords hit, else false
   */
   public boolean isListDestroyed()
   {
      System.out.println("*** BattleList.isListDestroyed called");
      int numShipDead = 0;
      for (int count = 0; count < battlelist.size(); count++)
      {
         BattleShip test = battlelist.get(count);
         if (test.isShipDestroyed() == true)
         {
            numShipDead++;
         }
      }
      
      if (numShipDead == battlelist.size())
      {
         return true;
      }
      return false;
   }
   
   /**
   This method gets a specific ship by index number
   @param the index number of the ship
   @return battlelist.get(idx), or null if idx is invalid
   */
   public BattleShip getShip(int idx)
   {
      System.out.println("*** BattleList.getShip called");
      if (idx >= battlelist.size())
      {
         return null;
      }
      BattleShip test = battlelist.get(idx);
      return test;
   
   }
   
   
   /**
   This method returns string implementation
   @return battlelist as a string
   */
   public String toString()
   {
      System.out.println("*** BattleList.toString() called");
      String output = "List Contains: " + battlelist.size() + " Ships\n";
      for (int count = 0; count < battlelist.size(); count++)
      {
         BattleShip test = battlelist.get(count);
         output = output + test + "\n";
      }
      return output;
   
   }
   
   public static void main(String[] args)
   {
      BattleList theList = new BattleList();
      System.out.println(theList);
      
      // uncomment this code for testing
      BattleShip test = new BattleShip(4, 5);
      theList.addShip(test);
      System.out.println(theList);
   
      BattleShip test2 = new BattleShip(1, 4);
      theList.addShip(test2);
      System.out.println(theList);
            
      System.out.println(theList.shootList(0, 0));
            
      System.out.println(theList.shootList(4, 6));
      System.out.println(theList);
      
      System.out.println(theList.shootList(1, 6));
      System.out.println(theList);
         
      System.out.println(theList.isListDestroyed());
      System.out.println(theList.shootList(4, 5));
      System.out.println(theList.shootList(4, 7));
      System.out.println(theList.shootList(4, 8));
      System.out.println(theList.shootList(1, 4));
      System.out.println(theList.shootList(1, 5));
      System.out.println(theList.shootList(1, 7));
      System.out.println(theList.isListDestroyed());
      System.out.println(theList);
         
      System.out.println(theList.getShip(1));
      System.out.println(theList.getShip(2));
               
         
   }
}