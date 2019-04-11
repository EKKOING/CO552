import java.util.Random;
import java.util.Scanner;

public class hitscan
{
   private boolean qShip = false;
   private boolean wShip = false;
   private boolean eShip = false;
   private boolean aShip = false;
   private boolean sShip = false;
   private boolean dShip = false;
   private boolean zShip = false;
   private boolean xShip = false;
   private boolean cShip = false;
   private boolean hit = false;
   
   private int guesses;
   
   public hitscan()
   {
      qShip = true;
      guesses = 0; 
   }
   
   public hitscan(int shipLocation)
   {
      if (shipLocation == 1)
      {
         qShip = true;
      }
      
      if (shipLocation == 2)
      {
         wShip = true;
      }
      if (shipLocation == 3)
      {
         eShip = true;
      }
      if (shipLocation == 4)
      {
         aShip = true;
      }
      if (shipLocation == 5)
      {
         sShip = true;
      }
      if (shipLocation == 6)
      {
         dShip = true;
      }
      if (shipLocation == 7)
      {
         zShip = true;
      }
      if (shipLocation == 8)
      {
         xShip = true;
      }
      if (shipLocation == 9)
      {
         cShip = true;
      }
   }
      
   public void guessLocation(int coordinate)
   {
      if (coordinate == 1)
      {
         if (qShip == true)
         {
            hit = true;
         }
      }
      {
         if (coordinate == 2)
         {
            if (wShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 3)
         {
            if (eShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 4)
         {
            if (aShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 5)
         {
            if (sShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 6)
         {
            if (dShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 7)
         {
            if (zShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 8)
         {
            if (xShip == true)
            {
               hit = true;
            }
         }
         if (coordinate == 9)
         {
            if (cShip == true)
            {
               hit = true;
            } 
         }
         
      
      
      
      
      
      
      }
   }
   public void changeLocation(int shipLocation)
   {
      if (shipLocation == 1)
      {
         qShip = true;
      }
      
      if (shipLocation == 2)
      {
         wShip = true;
      }
      if (shipLocation == 3)
      {
         eShip = true;
      }
      if (shipLocation == 4)
      {
         aShip = true;
      }
      if (shipLocation == 5)
      {
         sShip = true;
      }
      if (shipLocation == 6)
      {
         dShip = true;
      }
      if (shipLocation == 7)
      {
         zShip = true;
      }
      if (shipLocation == 8)
      {
         xShip = true;
      }
      if (shipLocation == 9)
      {
         cShip = true;
      }
      guesses = guesses + 1;
   }
   public boolean checkHit()
   {
      if (hit == true)
      {
         return true;
      }
      {
         return false;
      }
   }
   public int checkGuess()
   {
      return guesses;
   }
   public int whereShipAt(int shipLocation)
   {
      return shipLocation;
   }
}
