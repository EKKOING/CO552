import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.geom.*;

public class OrbCollection
{
   public static final double SPEED = 1.0;
   public static final int NUM_ORBS = 10;
   public static final int UPDATE_DELAY = 10;
   public static final double BOUNCE_AMT = (Orb.SIZE / 2);

   private ArrayList<Orb> myOrbs;
   private int myNumOrbs;
   private double mySpeed;
   
   private Timer myTimer;
   private OrbApp myApp;

   public OrbCollection(OrbApp app)
   {
      myApp = app;
      
      myOrbs = new ArrayList<Orb>();
      myNumOrbs = NUM_ORBS;
      mySpeed = SPEED;
      setupOrbs();
   
      myTimer = new Timer();
      myTimer.scheduleAtFixedRate(new UpdateTask(), 0, UPDATE_DELAY);
   }
   
   public int getNumOrbs()
   {
      return myNumOrbs;
   }
   
   public double getSpeed()
   {
      return mySpeed;
   }
   
   public ArrayList<Orb> getOrbs()
   {
      return myOrbs;
   }
   
   public void setNumOrbs(int num)
   {
      myNumOrbs = num;
      setupOrbs();
   }
   
   public void setSpeed(double speed)
   {
      mySpeed = speed;
      
      for(int idx = 0; idx < myOrbs.size(); idx++)
      {
         Orb o = myOrbs.get(idx);
         o.updateSpeed(mySpeed);
      }
   }
   
   public void setupOrbs()
   {
      myOrbs.clear();
      
      for(int idx = 0; idx < myNumOrbs; idx++)
      {
         int xVal = (int) (Math.random() * OrbApp.XMAX);
         int yVal = (int) (Math.random() * OrbApp.YMAX);
      
         myOrbs.add(new Orb(xVal, yVal, mySpeed, mySpeed));
      }
   }
   
   private class UpdateTask extends TimerTask
   {
      public void run()
      {
         if(!myApp.isPaused())
         {
            for(int idx = 0; idx < myOrbs.size(); idx++)
            {
               Orb o = myOrbs.get(idx);
               checkForCollision(o);
               o.checkForBounce();
               o.updatePosition();
            } 
         }
      }
      public void checkForCollision(Orb o)
      {
         double thisX = o.getX();
         double thisY = o.getY();
         Rectangle2D.Double oBox = new Rectangle2D.Double(thisX, thisY,
            Orb.SIZE, Orb.SIZE);
         for(int idx = 0; idx < myOrbs.size(); idx++)
         {
            Orb oth = myOrbs.get(idx);
         
            double othX = oth.getX();
            double othY = oth.getY();
            
            if(o.getID() != oth.getID())
            {    
               if(oBox.intersects(othX, othY, Orb.SIZE + 0.5, Orb.SIZE + 0.5))
               {
                  o.bounceX();
                  o.bounceY();
               }
            }
         }
      
      }
   
   }
}