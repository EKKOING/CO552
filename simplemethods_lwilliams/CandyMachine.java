/**
Writing Simple Methods 
@version 10/11/18
@author Liz Williams and Nicholas Lorentzon 
*/

public class CandyMachine
{

   /** Constant for maximum amount of candy */ 
   public static final int MY_MAX = 100;
    
   /** amount of candy in machine */
   private int myAmt;
   	
   /** max amount of candy */
   private int myMax;
   
   /** keeps track of times candy took */
   private int myNumTimes;
   
   /** initializes candy machine*/	
   public CandyMachine()
   {
      myMax = MY_MAX;
      myNumTimes = 0;
   }
  
   /** Fills up candy machine */
   public void fillMeUp()
   {
      myAmt = myMax;
   } 
   
   /** removes one piece of candy */
   public void takeCandy() 
   {
      myAmt = myAmt - 1;
      myNumTimes = myNumTimes + 1;
   }
   
   /** empties the candy machine */
   public void emptyCandy()
   {
      myAmt = 0;
   }
   
   /**
   return string representation of object
   @return CandyMachine object as a string
   */
   public String toString()
   {
      return "CandyMachine[A:" + myAmt + " M:" + myMax + "]"
         + "Took candy " + myNumTimes + " times";
   }
}