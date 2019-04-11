import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class OrbPanel extends JPanel
{
   public static final double SPEED = 1.0;
   public static final int NUM_ORBS = 10;
   public static final int UPDATE_DELAY = 41;
   public static final double BOUNCE_AMT = (Orb.SIZE / 2);

   private ArrayList<Orb> myOrbs;
   private int myNumOrbs;
   private double mySpeed;
   
   private OrbApp myApp;
   private Timer myTimer;

   public OrbPanel(OrbApp app)
   {
      super();
      
      myApp = app;
      
      myOrbs = new ArrayList<Orb>();
      myNumOrbs = NUM_ORBS;
      mySpeed = SPEED;
      setupOrbs();
      
      myTimer = new Timer();
      myTimer.scheduleAtFixedRate(new UpdateTask(), 0, UPDATE_DELAY);
      
      FieldUpdater newUpdater = new FieldUpdater();
      newUpdater.start();
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
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.clearRect(0, 0, getWidth(), getHeight());
      
      ArrayList<Orb> orbs = getOrbs();
      for(int idx = 0; idx < orbs.size(); idx++)
      {
         Orb o = orbs.get(idx);
         o.updateMax(getWidth(), getHeight());
         o.drawMe(g2);
      }
   }
   
   private class UpdateTask extends TimerTask
   {
      public void run()
      {
         if(!myApp.isPaused())
         {
            for(int counter = 0; counter < myOrbs.size(); counter++)
            {
               Orb y = myOrbs.get(counter);
               y.checkForBounce();
               y.updatePosition();
           
            } 
         }
      }
   }
   
   private class FieldUpdater extends Thread
   {
      public void run()
      {
         while(true)
         {
            if(!myApp.isPaused())
            {
               repaint();
            }
            
            try 
            {
               sleep(10);
            }
            catch(InterruptedException ie)
            {
               
            }
         }  
      }
   }

}   
