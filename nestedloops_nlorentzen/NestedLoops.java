import javax.swing.*;
import java.awt.*;
/**
Test Program for the nested loops lab
@author Nicholas Lorentzen & David Lloyd George
@version 11/15/2018
*/
public class NestedLoops
{
   // no comments needed here
   public static void main(String[] args)
   {
   	// set up the app
      JFrame frame = new JFrame(); 
      frame.setSize(640, 640);		
      frame.setTitle("My picture"); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
   	// add the picture
      CheckerBoard artwork = new CheckerBoard(); 
      frame.add(artwork);					
   	
   	// show the app
      frame.setVisible(true);			
   }
}









