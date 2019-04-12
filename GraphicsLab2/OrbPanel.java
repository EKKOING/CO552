import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class OrbPanel extends JPanel
{
   private OrbApp myApp;

   private OrbCollection myCollection;
   
   public OrbPanel(OrbApp app, OrbCollection orbs)
   {
      super();
      myCollection = orbs;
      myApp = app;
      
      FieldUpdater updater = new FieldUpdater();
      updater.start();
   
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.clearRect(0, 0, getWidth(), getHeight());
      
      ArrayList<Orb> orbs = myCollection.getOrbs();
      for(int idx = 0; idx < orbs.size(); idx++)
      {
         Orb o = orbs.get(idx);
         o.updateMax(getWidth(), getHeight());
         o.drawMe(g2);
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
               sleep(1);
            }
            catch(InterruptedException ie)
            {
               
            }
         }  
      }
   }   
}   
