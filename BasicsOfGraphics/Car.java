import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

/**
class to represent a simple car
@author Roger Wistar
@version 2019/03/01
*/
public class Car
{
   /** width of the car */
   public static final double WIDTH = 100;
   
   /** height of the car */
   public static final double HEIGHT = 50;
   
   /** amount to move with each key press */
   public static final double MOVE_AMT = 2;
   
   /** the x-coord of the car location */
   private double myXpos;
   
   /** the y-coord of the car location */
   private double myYpos;
   
   /**
   default constructor
   */
   public Car()
   {
      System.out.println("*** Car() called");
   
      myXpos = 200;
      myYpos = 200;
   }
   
   /**
   move car to a new location
   @param x the new x-coord
   @param y the new y-coord
   */
   public void moveTo(double x, double y)
   {
      System.out.println("*** Car.moveTo() called");
   
      myXpos = x;
      myYpos = y;
   }
   
   /**
   gets the x-coord
   @return value of myXpos
   */
   public double getX()
   {
      System.out.println("*** Car.getX() called");
   
      return myXpos;
   }
   
   /**
   gets the y-coord
   @return value of myYpos
   */
   public double getY()
   {
      System.out.println("*** Car.getY() called");
   
      return myYpos;
   }

   /**
   draws the car in the screen
   @param g2 the graphics handler
   */
   public void drawMe(Graphics2D g2)
   {
      System.out.println("*** Car.drawMe() called");
      
      g2.setColor(Color.blue);
   
      Rectangle2D.Double body = new Rectangle2D.Double(myXpos, myYpos, WIDTH, HEIGHT);
      g2.fill(body);
      
   }


}