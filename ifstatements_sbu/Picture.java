   import javax.swing.*;
   import java.awt.*;
   import java.awt.geom.*;

	/**
	draws a house
	@author Roger Wistar
	@version 2012/09/28
	*/
   public class Picture extends JComponent
   {
   	/**
   	draws the picture
   	@param g the graphics handler
   	*/
      public void paintComponent(Graphics g)
      {
         Graphics2D g2 = (Graphics2D) g;
      	
      	
      	// 	all coordinates are given in (x, y) order
      	// 	with (0, 0) being the top left corner
      	// 	and values increasing down and to the right
      	
      	// 	note that draw() makes empty shapes
      	// 	and fill() makes solid shapes
      	
      	// number order for Rectangle2D = x, y, length, width
         Rectangle2D.Double floor = new Rectangle2D.Double(50, 100, 160, 100);
         g2.draw(floor);
      	
         g2.setColor(Color.BLUE);
      	// number order for Ellipse2D = x, y, length, width
         Ellipse2D.Double window_1 = new Ellipse2D.Double(70, 120, 20, 20);
         g2.fill(window_1);
      	
         Ellipse2D.Double window_2 = new Ellipse2D.Double(170, 120, 20, 20);
         g2.fill(window_2);
      	
         g2.setColor(Color.RED);
         Rectangle2D.Double door = new Rectangle2D.Double(110, 160, 40, 40);
         g2.fill(door);
      	
         g2.setColor(Color.BLACK);
         // number order for Line2D = x1, y1, x2, y2
         Line2D.Double roof_1 = new Line2D.Double(50, 100, 130, 50);
         g2.draw(roof_1);
         Line2D.Double roof_2 = new Line2D.Double(130, 50, 210, 100);
         g2.draw(roof_2);
         
         g2.setColor(Color.MAGENTA);
         // number order for drawString = x, y
         g2.drawString("Home Sweet Home!", 70, 220);
      }
   }