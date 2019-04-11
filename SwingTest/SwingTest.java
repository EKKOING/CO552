import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class SwingTest
{
   private JFrame myWindow;
   private JLabel myLabel;
   private JPanel myPicture;
   private JPanel myApp;
   private JButton myButton;
   private Color myColor;
   
   public void SwingTest()
   {
      myColor = Color.BLACK;
      myWindow = new JFrame("SwingTest");
      myWindow.setSize(320, 240);
      myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myWindow.setVisible(true);
      
      myLabel = new JLabel("The color is: " + myColor);
      myPicture = new JPanel();
      myButton = new JButton("Change Color"); 
      myButton.addActionListener(new ButtonHandler());
         
      myApp = new JPanel();
      myApp.setLayout(new BorderLayout());
      myApp.add(myLabel, BorderLayout.NORTH);
      myApp.add(myButton, BorderLayout.SOUTH);
      myApp.add(myPicture, BorderLayout.CENTER);
   
         
      myWindow.add(myApp);
      myWindow.validate();
   }
   
   
   private class ButtonHandler implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         myColor = JColorChooser.showDialog(null, "Choose new Color", myColor);
         myLabel.setText("Color = " + myColor);
      }
   }
   
   private class Painter implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
         Graphics g = myPicture.getGraphics();
         Graphics2D g2 = (Graphics2D) g;
      
         int x = e.getX();
         int y = e.getY();
      
         Rectangle2D.Double p = new Rectangle2D.Double(x, y, 3, 3);
         g2.setColor(myColor);
         g2.fill(p);
      }
      
      public void mouseMoved(MouseEvent e)
      {
      //myX = -1;
      //myY = -1;
      }
   }
   
   public static void main(String[] args)
   {
      SwingTest test = new SwingTest();
      test.SwingTest();
   }
}