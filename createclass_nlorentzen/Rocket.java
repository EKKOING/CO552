/**
Creating Classes Lab
@author Nicholas Lorentzen and Nate Harris
@version 2018/10/12
*/
public class Rocket
{
   /** What kind of rocket it is */
   private String myName;
   
   /** Rocket explosion state */
   private boolean myKaboom;
   
   /** Rocket engine state */
   private boolean myEngineOn;
   
   /**
   Creates a rocket with default values.
   */
   public Rocket()
   {
      myKaboom = false;
   
      myEngineOn = true;
   
      myName = "Jebediah Kerman MKII";
   }
   
   /**
   Take the variables of the rocket and turn them into a string for printing.
   @return Returns the values of the variables the Rocket created.
   */
   public String toString()
   {
      String output;
      output = "Rocket: ";
   
      output = output + myName + ", has the rocket exploded = " + myKaboom 
         + ", \nis the engine running = " + myEngineOn;
   	// repeat for all the other class variables
   
      return output;
   }

   
   



}
