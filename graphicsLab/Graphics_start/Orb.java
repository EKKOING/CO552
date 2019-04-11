import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;

public class Orb
{
   public static final double SIZE = 20.0;
   
   private double myX;
   private double myY;
   
   private double myXMax;
   private double myYMax;
   
   private double myXSpeed;
   private double myYSpeed;
   
   private int myID;
   private static int nextID = 1;
   
   private Color myColor;
   
   public Orb(double x, double y, 
      double Xspeed, double Yspeed)
   {
      myID = nextID;
      nextID++;
   
      myX = x;
      myY = y;
      
      myXMax = 1000;
      myYMax = 1000;
      
      myXSpeed = Xspeed;
      myYSpeed = Yspeed;
      
      int r = (int) (Math.random() * 256);
      int g = (int) (Math.random() * 256);
      int b = (int) (Math.random() * 256);
      myColor = new Color(r, g, b);
      
   }
   
   public double getX()
   {
      return myX;
   }
   
   public double getY()
   {
      return myY;
   }
   
   public int getID()
   {
      return myID;
   }
   
   public void bounceX()
   {
      myXSpeed = myXSpeed * -Math.random();
   }
   
   public void bounceY()
   {
      myYSpeed = myYSpeed * -Math.random();
   }
   
   public void checkForBounce()
   {
      if(myX <= 0)
      {
         myX = 0;
         bounceX();
      }
      if(myX >= myXMax)
      {
         myX = myXMax;
         bounceX();
      }
      if(myY <= 0)
      {
         myY = 0;
         bounceY();
      }
      if(myY >= myYMax)
      {
         myY = myYMax;
         bounceY();
      }
   }
   
   public void updatePosition()
   {
      myX = myX + myXSpeed;
      myY = myY + myYSpeed;      
   }
   
   public void updateMax(double XMax, double YMax)
   {
      myXMax = XMax;
      myYMax = YMax;
   }
   
   public void updateSpeed(double speed)
   {
      double xSpeed = 0;
      double ySpeed = 0;
      
      if(speed > 0)
      {
         int xRand = (int) (Math.random() * 5) - 2;
         int yRand = (int) (Math.random() * 5) - 2;
      
         xSpeed = speed + xRand;
         ySpeed = speed + yRand;
      }      
   
      if(myXSpeed < 0)
      {
         myXSpeed = xSpeed * -1;
      }
      else
      {
         myXSpeed = xSpeed;
      }
      
      if(myYSpeed < 0)
      {
         myYSpeed = ySpeed * -1;
      }
      else
      {
         myYSpeed = ySpeed;
      }
   }
   
   public void drawMe(Graphics2D g2)
   {
      double radius = SIZE / 2;
      
      double topX = myX - radius;
      double topY = myY - radius;
   
      Ellipse2D.Double spot = new Ellipse2D.Double(topX, topY, SIZE, SIZE);
      g2.setColor(myColor);
      g2.fill(spot);
   }
}