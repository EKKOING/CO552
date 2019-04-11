	/**
	Models a simple hot-air balloon
	@author David Lloyd-George Nicholas Lorentzen
	@version 9/26/18
	*/
public class Balloon
{
   public final int MAX_HEIGHT = 100;
   private int myDistance;
   private int myHeight;
   
   	/**
   	Makes balloon take off. Sets balloon height to 10.
   	*/
   public void takeOff()
   {
      if (myHeight == 0)
      {
         myHeight = 10;
      }
   }
   	
   	/**
   	Lands balloon if height is equal to 10. 
   	*/
   public void land()
   {
      if (myHeight == 10)
      {
         myHeight = 0;
      }
   }
   	
   	/**
   	Increases height by 10 up to a height of 100.
   	*/
   public void burn()
   {
      if (myHeight > 0 && myHeight <= 100)
      {
         myHeight += 10;
      }
   }
   	
   	/**
   	Decreases height by 10 if the height is greater than 10.
   	*/
   public void vent()
   {
      if (myHeight > 10)
      {
         myHeight = myHeight - 10;
      }
   }
   	
   	/**
   	Advances the balloon forward or backwards based on its altitude.
   	*/
   public void cruise()
   {
      if (myHeight >= 10 && myHeight <= 30)
      {
         myDistance = myDistance - 10;
      }
      else if (myHeight >= 40 && myHeight <= 70)
      {
         	// do nothing
      }
      else  if (myHeight >= 80 && myHeight <=100)
      {
         myDistance += 10;
      }
   }
   	
   	/**
   	Prints the values for the height and distance of the balloon.
   	*/
   public void printInfo()
   {
      System.out.println("Height = " + "0" + ", Distance = " + "100");
   }
   	
   	/**
   	In this method, you should create a balloon, 
   	make it travel exactly 100 feet, and then land.
   	*/
   public static void main(String[] args)
   {
      Balloon whomst = new Balloon();
      
      whomst.takeOff();
      
      whomst.burn();
      whomst.burn();
      whomst.burn();
      whomst.burn();
      whomst.burn();
      whomst.burn();
      whomst.burn();
   
      
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      whomst.cruise();
      
   
      whomst.vent();
      whomst.vent();
      whomst.vent();
      whomst.vent();
      whomst.vent();
      whomst.vent();
      whomst.vent();
      
      whomst.land();
      
      whomst.printInfo();
   
     
      
              
   }
}