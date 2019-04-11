import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class OrbScreen extends JPanel
{
   private OrbApp myApp;
   
   private OrbPanel myFieldPanel;
   
   private JPanel myControlPanel;
   
   private JLabel myNumOrbsLabel;
   private JLabel mySpeedValLabel;
   
   private JSlider myOrbsSlider;
   private JSpinner mySpeedSpinner;
   
   private JButton myPauseButton;
   private JButton myRunButton;
   private JButton myResetButton;

   
   public OrbScreen(OrbApp app)
   {
   
      myApp = app;
      
      //setLayout(new BorderLayout());
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      
      myFieldPanel = new OrbPanel(myApp);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.weightx = 0.9;
      gbc.weighty = 0.9;
      gbc.fill = GridBagConstraints.BOTH;
      add(myFieldPanel, gbc);
      //add(myFieldPanel, BorderLayout.CENTER);
      
      JLabel myTitle = new JLabel("Bounce Orb!");
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 3;
      gbc.weighty = 0.1;
      gbc.fill = GridBagConstraints.BOTH;
      add(myTitle, gbc);
      //add(myTitle, BorderLayout.NORTH);
      
      myControlPanel = new JPanel();
      JLabel control = new JLabel("");
      myControlPanel.add(control);
      myControlPanel.setBackground(Color.YELLOW);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.weightx = 0.1;
      gbc.weighty = 0.9;
      gbc.fill = GridBagConstraints.BOTH;
      //add(myControlPanel, BorderLayout.WEST);
      add(myControlPanel, gbc); 
      
      
   }
   
   public void setupControlPanel()
   {
      myControlPanel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
         
      JLabel numLabel = new JLabel("Number of Orbs: ");
      addControlComp(numLabel, 
         0, 0, 2, GridBagConstraints.BOTH, 0.33, 0.1);
      
      myNumOrbsLabel = new JLabel("" + myFieldPanel.getNumOrbs());
      addControlComp(myNumOrbsLabel,
         2, 0, 1, GridBagConstraints.NONE, 0.33, 0.1);
      
      myOrbsSlider = new JSlider(OrbApp.ORB_MIN, OrbApp.ORB_MAX, 
         myFieldPanel.getNumOrbs());
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
      SpinnerModel sm = new SpinnerNumberModel(myFieldPanel.getSpeed(), 
         OrbApp.SPEED_MIN, OrbApp.SPEED_MAX, 1.0);
      mySpeedSpinner.setModel(sm);
      addControlComp(mySpeedSpinner,
         2, 2, 1, GridBagConstraints.HORIZONTAL, 0.33, 0.1);
      mySpeedSpinner.addChangeListener(new SpinnerListener());
         
      JLabel gap = new JLabel("");
      addControlComp(gap,
         0, 3, 3, GridBagConstraints.BOTH, 0.33, 0.1);
      
      JLabel spacer = new JLabel("");
      addControlComp(spacer,
         0, 4, 1, GridBagConstraints.BOTH, 0.33, 0.1);
   
      myPauseButton = new JButton("Pause");
      addControlComp(myPauseButton,
         1, 4, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      myPauseButton.addActionListener(new PauseListener());
         
      JLabel gap2 = new JLabel("");
      addControlComp(gap2,
         0, 5, 3, GridBagConstraints.BOTH, 0.33, 0.1);
   
      myRunButton = new JButton("Run");
      addControlComp(myRunButton,
         1, 6, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      myRunButton.addActionListener(new RunListener());
         
      JLabel gap3 = new JLabel("");
      addControlComp(gap3,
         0, 7, 3, GridBagConstraints.BOTH, 0.33, 0.1);
   
      myResetButton = new JButton("Reset");
      addControlComp(myResetButton,
         1, 8, 1, GridBagConstraints.BOTH, 0.33, 0.1);
      myResetButton.addActionListener(new ResetListener());
         
      JLabel gap4 = new JLabel("");
      addControlComp(gap4,
            0, 9, 3, GridBagConstraints.BOTH, 0.33, 0.1);
   }

   private void addControlComp(JComponent comp, int gridx, int gridy, 
                                 int gridwidth, int fill, double weightx, 
                                 double weighty)
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
   
   private class PauseListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myApp.setPaused(true);
      }
   }
   
   private class RunListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myApp.setPaused(false);
      }
   }
   
   private class ResetListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myFieldPanel.setupOrbs();
      }
   }
   
   private class SpinnerListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         double speed = (Double) mySpeedSpinner.getValue();
         myFieldPanel.setSpeed(speed);
      }
   }
   
   private class SliderListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         myFieldPanel.setNumOrbs(myOrbsSlider.getValue());
         myNumOrbsLabel.setText("" + myFieldPanel.getNumOrbs());
      }
   }

}