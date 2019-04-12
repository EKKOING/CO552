import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class OrbScreen extends JPanel
{
   private OrbApp myApp;
   private OrbCollection myCollection;
   
   private JPanel myControlPanel;
   private OrbPanel myFieldPanel;
   
   private JLabel myNumOrbsLabel;
   private JLabel mySpeedValLabel;
   
   private JSlider myOrbsSlider;
   private JSpinner mySpeedSpinner;
   
   private JButton myPauseButton;
   private JButton myRunButton;
   private JButton myResetButton;

   public OrbScreen(OrbApp app, OrbCollection collection)
   {
      myApp = app;
      myCollection = collection;
   
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      
      JLabel myTitle = new JLabel("Bounce Orb!");
      myTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 3;
      gbc.weighty = 0.1;
      add(myTitle, gbc);   
      
      myControlPanel = new JPanel();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.weightx = 0.1;
      gbc.weighty = 0.9;
      gbc.fill = GridBagConstraints.BOTH;
      add(myControlPanel, gbc);
      
      setupControlPanel(); 
      
      myFieldPanel = new OrbPanel(myApp, myCollection);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.weightx = 0.9;
      gbc.weighty = 0.9;
      gbc.fill = GridBagConstraints.BOTH;
      add(myFieldPanel, gbc);
      
      addKeyListener(new MyKeyListener());
      requestFocusInWindow();
   }
   
   private void setupControlPanel()
   {
      myControlPanel.setBackground(Color.YELLOW);
      
      myControlPanel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      
      JLabel numLabel = new JLabel("Number of Orbs: ");
      addControlComp(numLabel, 
         0, 0, 2, GridBagConstraints.BOTH, 0.33, 0.1);
      
      myNumOrbsLabel = new JLabel("" + myCollection.getNumOrbs());
      addControlComp(myNumOrbsLabel,
         2, 0, 1, GridBagConstraints.NONE, 0.33, 0.1);
      
      myOrbsSlider = new JSlider(OrbApp.ORB_MIN, OrbApp.ORB_MAX, 
         myCollection.getNumOrbs());
      myOrbsSlider.setMajorTickSpacing(1);
      myOrbsSlider.setPaintTicks(true);
      myOrbsSlider.setSnapToTicks(true);
      myOrbsSlider.setLabelTable(myOrbsSlider.createStandardLabels(5));
      myOrbsSlider.setPaintLabels(true);
      myOrbsSlider.addChangeListener(new SliderListener());
      addControlComp(myOrbsSlider,
         0, 1, 3, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel speedLabel = new JLabel("Speed of Orbs: ");
      addControlComp(speedLabel,
         0, 2, 2, GridBagConstraints.BOTH, 0.33, 0.1);
      
      mySpeedSpinner = new JSpinner();
      SpinnerModel sm = new SpinnerNumberModel(myCollection.getSpeed(), 
         OrbApp.SPEED_MIN, OrbApp.SPEED_MAX, 1.0);
      mySpeedSpinner.setModel(sm);
      mySpeedSpinner.addChangeListener(new SpinnerListener());
      addControlComp(mySpeedSpinner,
         2, 2, 1, GridBagConstraints.HORIZONTAL, 0.33, 0.1);
      
      JLabel gap = new JLabel("");
      addControlComp(gap,
         0, 3, 3, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel spacer = new JLabel("");
      addControlComp(spacer,
         0, 4, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      
      myPauseButton = new JButton("Pause");
      myPauseButton.addActionListener(new PauseListener());
      addControlComp(myPauseButton,
         1, 4, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel gap2 = new JLabel("");
      addControlComp(gap2,
         0, 5, 3, GridBagConstraints.BOTH, 0.33, 0.1);
      
      myRunButton = new JButton("Run");
      myRunButton.addActionListener(new RunListener());
      addControlComp(myRunButton,
         1, 6, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel gap3 = new JLabel("");
      addControlComp(gap3,
         0, 7, 3, GridBagConstraints.BOTH, 0.33, 0.1);
      
      myResetButton = new JButton("Reset");
      myResetButton.addActionListener(new ResetListener());
      addControlComp(myResetButton,
         1, 8, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel gap4 = new JLabel("");
      addControlComp(gap4,
         0, 9, 3, GridBagConstraints.BOTH, 0.33, 0.1);  
   }

   private void addControlComp(JComponent comp, 
                                 int gridx, int gridy, 
                                 int gridwidth, int fill, 
                                 double weightx, double weighty)
   {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = gridx;
      gbc.gridy = gridy;
      gbc.gridwidth = gridwidth;
      gbc.fill = fill;
      gbc.weightx = weightx;
      gbc.weighty = weighty;
      myControlPanel.add(comp, gbc);
   }

   private void modifySpeed(double delta)
   {
      double oldSpeed = myCollection.getSpeed();
      double newSpeed = oldSpeed + delta;
         
      if(newSpeed >= OrbApp.SPEED_MIN && newSpeed <= OrbApp.SPEED_MAX)
      {
         myCollection.setSpeed(newSpeed);
         mySpeedSpinner.setValue(new Double(newSpeed));
         myApp.setPaused(false);
      }
   }
         
   private void modifyNumOrbs(int delta)
   {
      int oldNum = myCollection.getNumOrbs();
      int newNum = oldNum + delta;
         
      if(newNum >= OrbApp.ORB_MIN && newNum <= OrbApp.ORB_MAX)
      {
         myCollection.setNumOrbs(newNum);
         myOrbsSlider.setValue(newNum);
         myApp.setPaused(false);
      }
   }
            
   private class SliderListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         myCollection.setNumOrbs(myOrbsSlider.getValue());
         myNumOrbsLabel.setText("" + myCollection.getNumOrbs());
         OrbScreen.this.requestFocusInWindow();
      }
   }
   
   private class SpinnerListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         double speed = (Double) mySpeedSpinner.getValue();
         myCollection.setSpeed(speed);
         OrbScreen.this.requestFocusInWindow();
      }
   }
   
   private class PauseListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myApp.setPaused(true);
         OrbScreen.this.requestFocusInWindow();
      }
   }
   
   private class RunListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myApp.setPaused(false);
         OrbScreen.this.requestFocusInWindow();
      }
   }
   
   private class ResetListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myCollection.setupOrbs();
         myApp.setPaused(false);
         OrbScreen.this.requestFocusInWindow();
      }
   }
   
   private class MyKeyListener implements KeyListener
   {
      public void keyPressed(KeyEvent e)
      {
         int code = e.getKeyCode();
         System.out.println(code);
         
         
         if(code == KeyEvent.VK_P)
         {
            if(myApp.isPaused())
            {
               myApp.setPaused(false);
            }
            else
            {
               myApp.setPaused(true);
            }
         }
         else if(code == KeyEvent.VK_UP)
         {
            modifySpeed(1.0);
         }
         else if(code == KeyEvent.VK_DOWN)
         {
            modifySpeed(-1.0);
         }
         else if(code == KeyEvent.VK_LEFT)
         {
            modifyNumOrbs(-1);
         }
         else if(code == KeyEvent.VK_RIGHT)
         {
            modifyNumOrbs(1);
         }
      }
   
      public void keyReleased(KeyEvent e)
      {
      
      }
      
      public void keyTyped(KeyEvent e)
      {
      
      } 
   }

}