//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlArmWindow.java
//
// PURPOSE: Handles the assembly and display of the of the rover arm control 
//          window. Window is constructed with NetBeans IDE.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for button icons
import javax.swing.ImageIcon;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlArmWindow extends javax.swing.JFrame
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Rover arm servo numbers
    private static final int SERVO_ARM_BASE_AZIMUTH    = 4;
    private static final int SERVO_ARM_BASE_ELEVATION  = 5;
    private static final int SERVO_ARM_ELBOW           = 6;
    private static final int SERVO_ARM_WRIST_ELEVATION = 7;
    private static final int SERVO_ARM_WRIST_ROTATION  = 8;
    private static final int SERVO_ARM_CLAW            = 9;
    
    //--------------------------------------------------------------------------
    // ControlGui Constructor
    //--------------------------------------------------------------------------
    public ControlArmWindow()
    {
        
        // Set the "Look and Feel" of the GUI to the windows default
        this.setLookAndFeel("Windows");
        
    }
    
    //--------------------------------------------------------------------------
    // Name:        initializeGui
    // Description: Builds the GUI components and displays the GUI
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void initializeGui()
    {
        
        // Initialize the GUI components created by NetBeans
        initComponents();
        
        // Set the window to hide itself on close
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        
        // Set the window to the middle of the screen
        this.setLocationRelativeTo(null);
        
        // Load the button icon images and scale them
        ImageIcon homePositionIcon = new ImageIcon(((new ImageIcon(getClass().getResource("/homePositionIcon.png"))).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        ImageIcon deployPositionIcon = new ImageIcon(((new ImageIcon(getClass().getResource("/deployPositionIcon.png"))).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        ImageIcon basketPositionIcon = new ImageIcon(((new ImageIcon(getClass().getResource("/basketPositionIcon.png"))).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        ImageIcon openPositionIcon = new ImageIcon(((new ImageIcon(getClass().getResource("/openPositionIcon.png"))).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        ImageIcon closePositionIcon = new ImageIcon(((new ImageIcon(getClass().getResource("/closePositionIcon.png"))).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        
        // Set the icons to the buttons
        homeButton.setIcon(homePositionIcon);
        deployButton.setIcon(deployPositionIcon);
        basketButton.setIcon(basketPositionIcon);
        openButton.setIcon(openPositionIcon);
        closeButton.setIcon(closePositionIcon);
        
    } // initializeGui
      
    //--------------------------------------------------------------------------
    // Name:        setLookAndFeel
    // Description: Sets the "look and feel" of the GUI, meaning the style of
    //              the windows and buttons
    // Arguments:   - String lookAndFeel, name of the style to set
    // Returns:     N/A
    //--------------------------------------------------------------------------
    private void setLookAndFeel(String lookAndFeel)
    {

        // Loop through the look and feel options until the correct one is found
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if (lookAndFeel.equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } // if
            } // for
        } // try
        catch (Exception ex)
        {
            System.out.println("ERROR: Couldn't set look and feel!");
        } // catch

    } // setLookAndFeel

    //--------------------------------------------------------------------------
    // Code generated by NetBeans. DO NOT MODIFY.
    //--------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        positionsPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        deployButton = new javax.swing.JButton();
        basketButton = new javax.swing.JButton();
        armControlPanel = new javax.swing.JPanel();
        baseAzLabel = new javax.swing.JLabel();
        baseAzSlider = new javax.swing.JSlider();
        baseEleLabel = new javax.swing.JLabel();
        baseEleSlider = new javax.swing.JSlider();
        elbowLabel = new javax.swing.JLabel();
        elbowSlider = new javax.swing.JSlider();
        wristEleLabel = new javax.swing.JLabel();
        wristEleSlider = new javax.swing.JSlider();
        wristRotLabel = new javax.swing.JLabel();
        wristRotSlider = new javax.swing.JSlider();
        clawLabel = new javax.swing.JLabel();
        clawSlider = new javax.swing.JSlider();
        baseAzValueLabel = new javax.swing.JLabel();
        baseEleValueLabel = new javax.swing.JLabel();
        elbowValueLabel = new javax.swing.JLabel();
        wristEleValueLabel = new javax.swing.JLabel();
        wristRotValueLabel = new javax.swing.JLabel();
        clawValueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rover Arm Control");

        positionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Positions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        closeButton.setToolTipText("Close claw");
        closeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeButtonActionPerformed(evt);
            }
        });

        openButton.setToolTipText("Open claw");
        openButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openButtonActionPerformed(evt);
            }
        });

        homeButton.setToolTipText("Return to home position");
        homeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                homeButtonActionPerformed(evt);
            }
        });

        deployButton.setToolTipText("Move to deployed position");
        deployButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deployButtonActionPerformed(evt);
            }
        });

        basketButton.setToolTipText("Move to basket position");
        basketButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                basketButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout positionsPanelLayout = new javax.swing.GroupLayout(positionsPanel);
        positionsPanel.setLayout(positionsPanelLayout);
        positionsPanelLayout.setHorizontalGroup(
            positionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(positionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(deployButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(basketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        positionsPanelLayout.setVerticalGroup(
            positionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(positionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(positionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deployButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        armControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Arm Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        baseAzLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        baseAzLabel.setText("Base Azimuth:");

        baseAzSlider.setMajorTickSpacing(1);
        baseAzSlider.setMaximum(90);
        baseAzSlider.setMinimum(-90);
        baseAzSlider.setMinorTickSpacing(1);
        baseAzSlider.setSnapToTicks(true);
        baseAzSlider.setToolTipText("0"); // NOI18N
        baseAzSlider.setValue(0);
        baseAzSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                baseAzSliderStateChanged(evt);
            }
        });

        baseEleLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        baseEleLabel.setText("Base Elevation:");

        baseEleSlider.setMajorTickSpacing(1);
        baseEleSlider.setMaximum(90);
        baseEleSlider.setMinimum(-90);
        baseEleSlider.setMinorTickSpacing(1);
        baseEleSlider.setSnapToTicks(true);
        baseEleSlider.setValue(0);
        baseEleSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                baseEleSliderStateChanged(evt);
            }
        });

        elbowLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        elbowLabel.setText("Elbow:");

        elbowSlider.setMajorTickSpacing(1);
        elbowSlider.setMaximum(90);
        elbowSlider.setMinimum(-90);
        elbowSlider.setMinorTickSpacing(1);
        elbowSlider.setSnapToTicks(true);
        elbowSlider.setValue(0);
        elbowSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                elbowSliderStateChanged(evt);
            }
        });

        wristEleLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        wristEleLabel.setText("Wrist Elevation:");

        wristEleSlider.setMajorTickSpacing(1);
        wristEleSlider.setMaximum(90);
        wristEleSlider.setMinimum(-90);
        wristEleSlider.setMinorTickSpacing(1);
        wristEleSlider.setSnapToTicks(true);
        wristEleSlider.setValue(0);
        wristEleSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                wristEleSliderStateChanged(evt);
            }
        });

        wristRotLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        wristRotLabel.setText("Wrist Rotation:");

        wristRotSlider.setMajorTickSpacing(1);
        wristRotSlider.setMaximum(90);
        wristRotSlider.setMinimum(-90);
        wristRotSlider.setMinorTickSpacing(1);
        wristRotSlider.setSnapToTicks(true);
        wristRotSlider.setValue(0);
        wristRotSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                wristRotSliderStateChanged(evt);
            }
        });

        clawLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        clawLabel.setText("Claw:");

        clawSlider.setMajorTickSpacing(1);
        clawSlider.setMaximum(90);
        clawSlider.setMinimum(-90);
        clawSlider.setMinorTickSpacing(1);
        clawSlider.setSnapToTicks(true);
        clawSlider.setValue(0);
        clawSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                clawSliderStateChanged(evt);
            }
        });

        baseAzValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        baseAzValueLabel.setText("0");

        baseEleValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        baseEleValueLabel.setText("0");

        elbowValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        elbowValueLabel.setText("0");

        wristEleValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        wristEleValueLabel.setText("0");

        wristRotValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        wristRotValueLabel.setText("0");

        clawValueLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        clawValueLabel.setText("0");

        javax.swing.GroupLayout armControlPanelLayout = new javax.swing.GroupLayout(armControlPanel);
        armControlPanel.setLayout(armControlPanelLayout);
        armControlPanelLayout.setHorizontalGroup(
            armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(armControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(wristRotLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseAzLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseEleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elbowLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wristEleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clawLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(baseAzSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(baseEleSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elbowSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wristEleSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wristRotSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clawSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(wristRotValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(wristEleValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elbowValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseEleValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseAzValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clawValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        armControlPanelLayout.setVerticalGroup(
            armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(armControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(baseAzSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseAzLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseAzValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(baseEleSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baseEleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baseEleValueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(elbowSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elbowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elbowValueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wristEleSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wristEleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wristEleValueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wristRotSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wristRotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wristRotValueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(armControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clawSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clawLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clawValueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(armControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(positionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(armControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baseAzSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_baseAzSliderStateChanged
    {//GEN-HEADEREND:event_baseAzSliderStateChanged
        
        // Get the current slider value
        int sliderValue = baseAzSlider.getValue();
        
        // Set the slider value label to the current value
        baseAzValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_AZIMUTH) + ", \"angle\":" + (sliderValue) + "}");
       
    }//GEN-LAST:event_baseAzSliderStateChanged

    private void baseEleSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_baseEleSliderStateChanged
    {//GEN-HEADEREND:event_baseEleSliderStateChanged
        
        // Get the current slider value
        int sliderValue = baseEleSlider.getValue();
        
        // Set the slider value label to the current value
        baseEleValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_ELEVATION) + ", \"angle\":" + (sliderValue) + "}");
        
    }//GEN-LAST:event_baseEleSliderStateChanged

    private void elbowSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_elbowSliderStateChanged
    {//GEN-HEADEREND:event_elbowSliderStateChanged
        
        // Get the current slider value
        int sliderValue = elbowSlider.getValue();
        
        // Set the slider value label to the current value
        elbowValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_ELBOW) + ", \"angle\":" + (sliderValue) + "}");
        
    }//GEN-LAST:event_elbowSliderStateChanged

    private void wristEleSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_wristEleSliderStateChanged
    {//GEN-HEADEREND:event_wristEleSliderStateChanged
        
        // Get the current slider value
        int sliderValue = wristEleSlider.getValue();
        
        // Set the slider value label to the current value
        wristEleValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ELEVATION) + ", \"angle\":" + (sliderValue) + "}");
        
    }//GEN-LAST:event_wristEleSliderStateChanged

    private void wristRotSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_wristRotSliderStateChanged
    {//GEN-HEADEREND:event_wristRotSliderStateChanged
        
        // Get the current slider value
        int sliderValue = wristRotSlider.getValue();
        
        // Set the slider value label to the current value
        wristRotValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ROTATION) + ", \"angle\":" + (sliderValue) + "}");
        
    }//GEN-LAST:event_wristRotSliderStateChanged

    private void clawSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_clawSliderStateChanged
    {//GEN-HEADEREND:event_clawSliderStateChanged
        
        // Get the current slider value
        int sliderValue = clawSlider.getValue();
        
        // Set the slider value label to the current value
        clawValueLabel.setText(Integer.toString(sliderValue));
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_CLAW) + ", \"angle\":" + (sliderValue) + "}");
        
    }//GEN-LAST:event_clawSliderStateChanged

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_homeButtonActionPerformed
    {//GEN-HEADEREND:event_homeButtonActionPerformed
                
//        // Home position values
//        int baseAzValue =   0;
//        int baseEleValue =  0;
//        int elbowValue =    0;
//        int wristEleValue = 0;
//        int wristRotValue = 0;
//        
//        // Send the JSON formatted servo move commands
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_AZIMUTH) + ", \"angle\":" + (baseAzValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_ELEVATION) + ", \"angle\":" + (baseEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_ELBOW) + ", \"angle\":" + (elbowValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ELEVATION) + ", \"angle\":" + (wristEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ROTATION) + ", \"angle\":" + (wristRotValue) + "}");
        //ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_AZIMUTH) + ", \"angle\":" + (0.0) + "}");
       //ControlCommunicator.sendCommand("{\"command\":\"clawinc\", \"dx\":" + (-1.0) + ", \"dy\":" + (0.0) + ", \"dz\":" + (0.0) + "}");
        
    //ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (6) + ", \"angle\":" + (0.0) + "}");
    ControlCommunicator.sendCommand("{\"command\":\"gpiotog\", \"pin\":" + (12) + "}");
        
    }//GEN-LAST:event_homeButtonActionPerformed

    private void deployButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deployButtonActionPerformed
    {//GEN-HEADEREND:event_deployButtonActionPerformed
                
        // Deploy position values
//        int baseAzValue =   25;
//        int baseEleValue =  -50;
//        int elbowValue =    -55;
//        int wristEleValue = 30;
//        int wristRotValue = 45;
//        
//        // Send the JSON formatted servo move commands
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_AZIMUTH) + ", \"angle\":" + (baseAzValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_ELEVATION) + ", \"angle\":" + (baseEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_ELBOW) + ", \"angle\":" + (elbowValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ELEVATION) + ", \"angle\":" + (wristEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ROTATION) + ", \"angle\":" + (wristRotValue) + "}");
//        
    }//GEN-LAST:event_deployButtonActionPerformed

    private void basketButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_basketButtonActionPerformed
    {//GEN-HEADEREND:event_basketButtonActionPerformed
                
//        // Basket position values
//        int baseAzValue =   25;
//        int baseEleValue =  -50;
//        int elbowValue =    -55;
//        int wristEleValue = 30;
//        int wristRotValue = 45;
//        
//        // Send the JSON formatted servo move commands
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_AZIMUTH) + ", \"angle\":" + (baseAzValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_BASE_ELEVATION) + ", \"angle\":" + (baseEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_ELBOW) + ", \"angle\":" + (elbowValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ELEVATION) + ", \"angle\":" + (wristEleValue) + "}");
//        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_WRIST_ROTATION) + ", \"angle\":" + (wristRotValue) + "}");
//        
    }//GEN-LAST:event_basketButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeButtonActionPerformed
    {//GEN-HEADEREND:event_closeButtonActionPerformed
                
        // Close position values
        int clawValue =   0;
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_CLAW) + ", \"angle\":" + (clawValue) + "}");
        
    }//GEN-LAST:event_closeButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openButtonActionPerformed
    {//GEN-HEADEREND:event_openButtonActionPerformed
                
        // Open position values
        int clawValue =   90;
        
        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_ARM_CLAW) + ", \"angle\":" + (clawValue) + "}");
        
    }//GEN-LAST:event_openButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel armControlPanel;
    private javax.swing.JLabel baseAzLabel;
    private javax.swing.JSlider baseAzSlider;
    private javax.swing.JLabel baseAzValueLabel;
    private javax.swing.JLabel baseEleLabel;
    private javax.swing.JSlider baseEleSlider;
    private javax.swing.JLabel baseEleValueLabel;
    private javax.swing.JButton basketButton;
    private javax.swing.JLabel clawLabel;
    private javax.swing.JSlider clawSlider;
    private javax.swing.JLabel clawValueLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deployButton;
    private javax.swing.JLabel elbowLabel;
    private javax.swing.JSlider elbowSlider;
    private javax.swing.JLabel elbowValueLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton openButton;
    private javax.swing.JPanel positionsPanel;
    private javax.swing.JLabel wristEleLabel;
    private javax.swing.JSlider wristEleSlider;
    private javax.swing.JLabel wristEleValueLabel;
    private javax.swing.JLabel wristRotLabel;
    private javax.swing.JSlider wristRotSlider;
    private javax.swing.JLabel wristRotValueLabel;
    // End of variables declaration//GEN-END:variables

} // ControlArmWindow class
