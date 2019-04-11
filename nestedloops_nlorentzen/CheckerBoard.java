import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
Test Program for the nested loops lab
@author Nicholas Lorentzen and David Lloyd George
@version 11/15/2018
*/
public class CheckerBoard extends JComponent
{
   /** Size of square board in rows/columns */
   private static final int BOARD_SIZE = 8;
   /** Size of each square */
   private static final int SQUARE_SIZE = 50;
   /** Number of rows to put pieces on */
   private static final int ROWS_OF_PIECES = 2;
   /** Amount to offset pieces by */
   private static final int PIECE_OFFSET = 10;
   
	/**
	Creates a checker board with pieces in place
	*/
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (int yAxis = 0; yAxis < BOARD_SIZE; yAxis++)
      {
         for (int xAxis = 0; xAxis < BOARD_SIZE; xAxis++)
         {
            if (xAxis%2 == (yAxis+1)%2)
            {
               g2.setColor(Color.black);
            }
            else
            {
               g2.setColor(Color.red);
            }
            
            Rectangle2D.Double square = new Rectangle2D.Double(PIECE_OFFSET
               +xAxis*SQUARE_SIZE, 10+yAxis*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            g2.fill(square);
            
            if (xAxis%2 == (yAxis+1)%2 && (yAxis <= ROWS_OF_PIECES 
               - 1 || yAxis >= BOARD_SIZE - ROWS_OF_PIECES))
            {  
               if (yAxis >= 6)
               {
                  g2.setColor(Color.red);
               }
               else
               {
                  g2.setColor(Color.black);
               }
               
               Ellipse2D.Double checkerPiece = new Ellipse2D.Double(10+xAxis
                  *SQUARE_SIZE, 10+yAxis*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
               g2.fill(checkerPiece);
               g2.setColor(Color.white);
               g2.draw(checkerPiece);
            }
         }
      }
   }
}