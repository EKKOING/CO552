import java.awt.*;
import javax.swing.*;

/**
a simple graphics app
@author Roger Wistar
@version 2019/03/01
*/
public class GraphicsApp
{
   /** width of the screen */
   public static final int WIDTH = 640;
   
   /** height of the screen */
   public static final int HEIGHT = 480;

   /** the window of the app */
   private JFrame myWindow;
   
   /** the screen of the app */
   private GraphicsScreen myScreen;

   /**
   default constructor
   */
   public GraphicsApp()
   {
      System.out.println("*** GraphicsApp() called");
   
      myScreen = new GraphicsScreen();
      
      myWindow = new JFrame();
      myWindow.setSize(WIDTH, HEIGHT);
      myWindow.setTitle("My app"); 
      myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      myWindow.add(myScreen);
   
      myWindow.setVisible(true);
      
   }  
   
   public static void main(String[] args)
   {
      GraphicsApp test = new GraphicsApp();
   }
}