import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
a simple graphics app
@author Nicholas Lorentzen
@version 2019/03/04
*/
public class GraphicsScreen extends JPanel
{
   private Car myCar;
   
   public GraphicsScreen()
   {
      myCar = new Car();
      
      
      
      //MouseHandler mouse = new MouseHandler();
      //this.addMouseListener(mouse);
      
      KeyHandler kh = new KeyHandler();
      this.addKeyListener(kh);
      this.setFocusable(true);
      this.requestFocusInWindow();
      
      repaint();
      
   }
   
   public void paintComponent(Graphics g)
   {
      System.out.println("Paint Component Called");
      Graphics2D g2 = (Graphics2D) g;
      myCar.drawMe(g2);
   }
   
   /*private class MouseHandler implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         System.out.println("Called MousePressed");
      
         double x = e.getX();
         double y = e.getY();
      }
   }
   */
   private class KeyHandler implements KeyListener
   {
      public void keyPressed(KeyEvent e)
      {
         double x = myCar.getX();
         double y = myCar.getY();
         
         int code = e.getKeyCode();
         
         System.out.println(code);
      }
      
      public void keyReleased(KeyEvent e)
      {
         //nothing
      }
      
      public void keyTyped(KeyEvent e)
      {
         //nothing
      }
   }
}