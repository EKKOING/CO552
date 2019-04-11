import javax.swing.*;
import java.awt.*;

public class PictureViewer
{
   public static final int WINDOW_WIDTH = 640;
   public static final int WINDOW_HEIGHT = 480;

   public static void main(String[] args)
   {
   	// set up the app
      JFrame frame = new JFrame(); 
      frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
      frame.setTitle("My picture"); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   	// add the picture
      TargetPractice artwork = new TargetPractice(); 
      frame.add(artwork);					
   	
   	// show the app
      frame.setVisible(true);			
   }
}









