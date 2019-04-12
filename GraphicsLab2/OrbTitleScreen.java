import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class OrbTitleScreen extends JPanel
{
   public static final int BUTTON_WIDTH = 200;
   public static final int BUTTON_HEIGHT = 50;

   private OrbApp myApp;

   private JButton myStartButton;
   
   private Rectangle2D.Double myButton;
   
   public OrbTitleScreen(OrbApp app)
   {
      myApp = app;
      
      addMouseListener(new MyButtonListener());
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      setBackground(Color.CYAN);
      
      
      int buttonX = (OrbApp.APP_WIDTH / 2) - (BUTTON_WIDTH / 2);
      int buttonY = (OrbApp.APP_HEIGHT / 2) - (BUTTON_HEIGHT / 2);
      
      myButton = new Rectangle2D.Double(buttonX, buttonY, 
         BUTTON_WIDTH, BUTTON_HEIGHT);
      g2.draw(myButton);
      g2.setFont(new Font("Arial", Font.BOLD, 18));
      g2.drawString("Begin!", buttonX + 75, buttonY + 30);
      
      g2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 36));
      g2.drawString("Orb Bounce!", buttonX, buttonY - 25);
   }

   private class MyButtonListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
      
      }
      
      public void mouseReleased(MouseEvent e)
      {
      
      }
      
      public void mouseClicked(MouseEvent e)
      {
      
      }
      
      public void mouseEntered(MouseEvent e)
      {
      
      }
      
      public void mouseExited(MouseEvent e)
      {
      
      }
   
   }
}