   import javax.swing.*;
   import java.awt.*;
   import java.awt.geom.*;
   import java.awt.event.*;

   public class TargetPractice extends JComponent implements MouseListener
   {
      public static final double RADIUS = 25.0;
      public static final double GREEN_RADIUS = 10.0;
      
      private double centerX;

      private double centerY;
   
      public TargetPractice()
      {
         addMouseListener(this);
      }
   
   	/**
   	draws the picture
   	@param g the graphics handler
   	*/
      public void paintComponent(Graphics g)
      {
         Graphics2D g2 = (Graphics2D) g;
      	
      	drawRandomCircle(g2);
      }
      
      public void drawRandomCircle(Graphics g)
      {
         Graphics2D g2 = (Graphics2D) g;
      
         g2.setColor(Color.WHITE);
         Rectangle2D.Double clear = new Rectangle2D.Double(0, 0,
            PictureViewer.WINDOW_WIDTH, PictureViewer.WINDOW_HEIGHT);
         g2.fill(clear);
      
         double minX = RADIUS;
         double maxX = PictureViewer.WINDOW_WIDTH - RADIUS;
         double minY = RADIUS;
         double maxY = PictureViewer.WINDOW_HEIGHT - RADIUS;
         
         centerX = Math.random() * maxX + minX;
         centerY = Math.random() * maxY + minY;
         
         Ellipse2D.Double circle = new Ellipse2D.Double(
            centerX - RADIUS, centerY - RADIUS,
            RADIUS * 2, RADIUS * 2);
         
         g2.setColor(Color.RED);
         g2.fill(circle);
      }
      
      /** 
      
      */    
		public void mousePressed(MouseEvent e)
		{
			double mouseX = e.getX();
         double mouseY = e.getY();
         
         System.out.println("Clicked (" + mouseX + "," + mouseY + ")");
         
         
         double distance = Math.sqrt(Math.pow(mouseX - centerX, 2)
            + Math.pow(mouseY - centerY, 2));
         
         if(distance > RADIUS)
         {
            System.out.println("MISS!");
            Ellipse2D.Double greenDot = new Ellipse2D.Double(mouseX - GREEN_RADIUS, 
               mouseY - GREEN_RADIUS,GREEN_RADIUS * 2, GREEN_RADIUS * 2 );
            
            Graphics2D g2 = (Graphics2D) getGraphics();
            g2.setColor(Color.GREEN);
            g2.fill(greenDot);

         }
         else
         {
            System.out.println("HIT!");
            drawRandomCircle(getGraphics());

         }
		}

      /**
      runs when user clicks mouse button quickly
      @param e the details of the mouse event
      */
      public void mouseClicked(MouseEvent e)
		{
		
		}

      /**
      runs when user lets go of mouse button 
      @param e the details of the mouse event
      */
		public void mouseReleased(MouseEvent e)
		{
		
		}

      /**
      runs when mouse cursor enters this screen
      @param e the details of the mouse event
      */
		public void mouseEntered(MouseEvent e)
		{
		
		}

      /**
      runs when mouse cursor exits this screen
      @param e the details of the mouse event
      */
		public void mouseExited(MouseEvent e)
		{
		
		}
   }