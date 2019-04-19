import java.awt.*;
import javax.swing.*;

public class OrbApp
{
   public static final int APP_WIDTH = 800;
   public static final int APP_HEIGHT = 600;

   public static final int XMAX = 400;
   public static final int YMAX = 600;
   
   public static final double SPEED_MIN = 0.0;
   public static final double SPEED_MAX = 20.0;
   
   public static final int ORB_MIN = 5;
   public static final int ORB_MAX = 25;
   
   public static final String TITLE = "Title";
   public static final String ORB = "Orb";

   private JFrame myApp;
   private OrbScreen myOrbPanel;
   private JPanel myAppPanel;
   
   private OrbTitleScreen myTitlePanel;
   
   private OrbCollection myCollection;
   
   private boolean isPaused;
   
   public static void main(String[] args)
   {
      OrbApp app = new OrbApp();
      app.run();
   }
   
   public boolean isPaused()
   {
      return isPaused;
   }
   
   public void setPaused(boolean flag)
   {
      isPaused = flag;
   }
   
   public void run()
   {
      myCollection = new OrbCollection(this);
      isPaused = true;
      setupFrame();
   }
   
   private void setupFrame()
   {
      myApp = new JFrame();
      myApp.setSize(APP_WIDTH, APP_HEIGHT);
      
      myTitlePanel = new OrbTitleScreen(this);
      
      myOrbPanel = new OrbScreen(this, myCollection);
      myOrbPanel.setFocusable(true);
      
      myAppPanel = new JPanel(new CardLayout());
      myAppPanel.add(myTitlePanel, TITLE);
      myAppPanel.add(myOrbPanel, ORB);
      
      myApp.add(myAppPanel);
      myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myApp.setVisible(true);
   }   
   
   public void switchScreen(String whichScreen)
   {
      CardLayout layout = (CardLayout) myAppPanel.getLayout();
      layout.show(myAppPanel, whichScreen);
      
      if(whichScreen == ORB)
      {
         myOrbPanel.requestFocusInWindow();
      }
   }

}