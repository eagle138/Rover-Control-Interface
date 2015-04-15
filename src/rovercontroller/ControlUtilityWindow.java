//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlUtilityWindow.java
//
// PURPOSE: Handles the assembly and display of the of the rover utility 
//          window. Window is constructed with NetBeans IDE.
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

import javax.swing.JOptionPane;



//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlUtilityWindow extends javax.swing.JFrame
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Rover arm servo numbers
    private static final int SERVO_WHEEL_FRONT_RIGHT   = 0;
    private static final int SERVO_WHEEL_FRONT_LEFT    = 1;
    private static final int SERVO_WHEEL_BACK_RIGHT    = 2;
    private static final int SERVO_WHEEL_BACK_LEFT     = 3;
    
    //--------------------------------------------------------------------------
    // ControlGui Constructor
    //--------------------------------------------------------------------------
    public ControlUtilityWindow()
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

        // Initialize the GUI components
        initComponents();
        
        // Set the window to the middle of the screen
        this.setLocationRelativeTo(null);

        // Set the window to hide itself on close
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

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

        roverUtilitiesPanel = new javax.swing.JPanel();
        rebootButton = new javax.swing.JButton();
        killButton = new javax.swing.JButton();
        servoControlPanel = new javax.swing.JPanel();
        servoControlSlider = new javax.swing.JSlider();
        servoControlDropdown = new javax.swing.JComboBox();
        pulseWidthLabel = new javax.swing.JLabel();
        motorControlPanel = new javax.swing.JPanel();
        motorControlSlider = new javax.swing.JSlider();
        toggleBrakesButton = new javax.swing.JToggleButton();
        steeringTrimPanel = new javax.swing.JPanel();
        saveTrimButton = new javax.swing.JButton();
        frontRightWheelSpinner = new javax.swing.JSpinner();
        frontRightWheelLabel = new javax.swing.JLabel();
        frontLeftWheelLabel = new javax.swing.JLabel();
        backRightWheelLabel = new javax.swing.JLabel();
        backLeftWheelLabel = new javax.swing.JLabel();
        frontLeftWheelSpinner = new javax.swing.JSpinner();
        backRightWheelSpinner = new javax.swing.JSpinner();
        backLeftWheelSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roverUtilitiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Rover Utilities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        rebootButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        rebootButton.setText("Reboot Rover");
        rebootButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rebootButtonActionPerformed(evt);
            }
        });

        killButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        killButton.setText("Kill Rover Control Code");
        killButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                killButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roverUtilitiesPanelLayout = new javax.swing.GroupLayout(roverUtilitiesPanel);
        roverUtilitiesPanel.setLayout(roverUtilitiesPanelLayout);
        roverUtilitiesPanelLayout.setHorizontalGroup(
            roverUtilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roverUtilitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roverUtilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rebootButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(killButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roverUtilitiesPanelLayout.setVerticalGroup(
            roverUtilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roverUtilitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rebootButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(killButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        servoControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Servo Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        servoControlSlider.setMajorTickSpacing(5);
        servoControlSlider.setMaximum(5000);
        servoControlSlider.setMinorTickSpacing(10);
        servoControlSlider.setSnapToTicks(true);
        servoControlSlider.setValue(1500);
        servoControlSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                servoControlSliderStateChanged(evt);
            }
        });

        servoControlDropdown.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        servoControlDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servo 0", "Servo 1", "Servo 2", "Servo 3", "Servo 4", "Servo 5", "Servo 6", "Servo 7", "Servo 8", "Servo 9", "Servo 10", "Servo 11", "Servo 12", "Servo 13", "Servo 14", "Servo 15" }));

        pulseWidthLabel.setText("0.0");

        javax.swing.GroupLayout servoControlPanelLayout = new javax.swing.GroupLayout(servoControlPanel);
        servoControlPanel.setLayout(servoControlPanelLayout);
        servoControlPanelLayout.setHorizontalGroup(
            servoControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servoControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(servoControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servoControlDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(servoControlPanelLayout.createSequentialGroup()
                        .addComponent(servoControlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulseWidthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        servoControlPanelLayout.setVerticalGroup(
            servoControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servoControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(servoControlDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(servoControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(servoControlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pulseWidthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        motorControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Motor Speed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        motorControlSlider.setMajorTickSpacing(1000);
        motorControlSlider.setMaximum(1000);
        motorControlSlider.setMinimum(-1000);
        motorControlSlider.setMinorTickSpacing(1);
        motorControlSlider.setSnapToTicks(true);
        motorControlSlider.setValue(0);
        motorControlSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                motorControlSliderStateChanged(evt);
            }
        });

        toggleBrakesButton.setText("Toggle Brakes");
        toggleBrakesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                toggleBrakesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout motorControlPanelLayout = new javax.swing.GroupLayout(motorControlPanel);
        motorControlPanel.setLayout(motorControlPanelLayout);
        motorControlPanelLayout.setHorizontalGroup(
            motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleBrakesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motorControlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        motorControlPanelLayout.setVerticalGroup(
            motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(motorControlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleBrakesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        steeringTrimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Steering Trim", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        saveTrimButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        saveTrimButton.setText("Save Trim");
        saveTrimButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveTrimButtonActionPerformed(evt);
            }
        });

        frontRightWheelSpinner.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                frontRightWheelSpinnerStateChanged(evt);
            }
        });

        frontRightWheelLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        frontRightWheelLabel.setText("Front Right Wheel:");

        frontLeftWheelLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        frontLeftWheelLabel.setText("Front Left Wheel:");

        backRightWheelLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        backRightWheelLabel.setText("Back Right Wheel:");

        backLeftWheelLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        backLeftWheelLabel.setText("Back Left Wheel:");

        frontLeftWheelSpinner.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                frontLeftWheelSpinnerStateChanged(evt);
            }
        });

        backRightWheelSpinner.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                backRightWheelSpinnerStateChanged(evt);
            }
        });

        backLeftWheelSpinner.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                backLeftWheelSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout steeringTrimPanelLayout = new javax.swing.GroupLayout(steeringTrimPanel);
        steeringTrimPanel.setLayout(steeringTrimPanelLayout);
        steeringTrimPanelLayout.setHorizontalGroup(
            steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveTrimButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                        .addComponent(frontRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frontRightWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                        .addComponent(frontLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frontLeftWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                        .addComponent(backRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backRightWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                        .addComponent(backLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backLeftWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        steeringTrimPanelLayout.setVerticalGroup(
            steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(frontRightWheelSpinner)
                    .addComponent(frontRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frontLeftWheelSpinner)
                    .addComponent(frontLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(backRightWheelSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backLeftWheelSpinner)
                    .addComponent(backLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveTrimButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motorControlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roverUtilitiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(servoControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(steeringTrimPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roverUtilitiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servoControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motorControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(steeringTrimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rebootButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rebootButtonActionPerformed
    {//GEN-HEADEREND:event_rebootButtonActionPerformed

        // Show a reboot confirmation dialog
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reboot the rover?", "Alert", JOptionPane.YES_NO_OPTION);
        
        // If the user pressed yes
        if (reply == JOptionPane.YES_OPTION)
        {
            
            // Send the JSON formatted reboot command
            ControlCommunicator.sendCommand("{\"command\":\"reboot\"}");
            
        } // if

    }//GEN-LAST:event_rebootButtonActionPerformed

    private void killButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_killButtonActionPerformed
    {//GEN-HEADEREND:event_killButtonActionPerformed

        // Show a reboot confirmation dialog
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to kill the rover control code?", "Alert", JOptionPane.YES_NO_OPTION);
        
        // If the user pressed yes
        if (reply == JOptionPane.YES_OPTION)
        {
            
            // Send the JSON formatted reboot command
            ControlCommunicator.sendCommand("{\"command\":\"kill\"}");
            
        } // if

    }//GEN-LAST:event_killButtonActionPerformed

    private void servoControlSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_servoControlSliderStateChanged
    {//GEN-HEADEREND:event_servoControlSliderStateChanged

        // Get the servo number and angle from the dropdown menu and slider
        int selectedServo = servoControlDropdown.getSelectedIndex();
        double servoState = ((double)servoControlSlider.getValue())/1000.0;
        pulseWidthLabel.setText(Double.toString(servoState));
        
        // Send the JSON formatted servo command
        ControlCommunicator.sendCommand("{\"command\":\"pwm\", \"servonum\":" + (selectedServo) + ", \"pw\":" + (servoState) + "}");
    }//GEN-LAST:event_servoControlSliderStateChanged

    private void motorControlSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_motorControlSliderStateChanged
    {//GEN-HEADEREND:event_motorControlSliderStateChanged

        // Get the motor speed from the slider
        int motorState = motorControlSlider.getValue();

        // Send the JSON formatted motor speed command
        ControlCommunicator.sendCommand("{\"command\":\"motorspeed\", \"speed\":" + ((double) motorState / 1000) + "}");

    }//GEN-LAST:event_motorControlSliderStateChanged

    private void toggleBrakesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_toggleBrakesButtonActionPerformed
    {//GEN-HEADEREND:event_toggleBrakesButtonActionPerformed

        // If the button was pressed down, send brake on command
        if(toggleBrakesButton.isSelected())
        {
            ControlCommunicator.sendCommand("{\"command\":\"brakeon\"}");
        } // if

        // Otherwise, send brake off command
        else
        {
            ControlCommunicator.sendCommand("{\"command\":\"brakeoff\"}");
        } // else

    }//GEN-LAST:event_toggleBrakesButtonActionPerformed

    private void saveTrimButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveTrimButtonActionPerformed
    {//GEN-HEADEREND:event_saveTrimButtonActionPerformed
        
        // Send the JSON formatted trim command
        ControlCommunicator.sendCommand("{\"command\":\"trim\"}");
        
    }//GEN-LAST:event_saveTrimButtonActionPerformed

    private void frontRightWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_frontRightWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_frontRightWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) frontRightWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_FRONT_RIGHT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_frontRightWheelSpinnerStateChanged

    private void frontLeftWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_frontLeftWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_frontLeftWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) frontLeftWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_FRONT_LEFT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_frontLeftWheelSpinnerStateChanged

    private void backRightWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_backRightWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_backRightWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) backRightWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_BACK_RIGHT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_backRightWheelSpinnerStateChanged

    private void backLeftWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_backLeftWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_backLeftWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) backLeftWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        ControlCommunicator.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_BACK_LEFT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_backLeftWheelSpinnerStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLeftWheelLabel;
    private javax.swing.JSpinner backLeftWheelSpinner;
    private javax.swing.JLabel backRightWheelLabel;
    private javax.swing.JSpinner backRightWheelSpinner;
    private javax.swing.JLabel frontLeftWheelLabel;
    private javax.swing.JSpinner frontLeftWheelSpinner;
    private javax.swing.JLabel frontRightWheelLabel;
    private javax.swing.JSpinner frontRightWheelSpinner;
    private javax.swing.JButton killButton;
    private javax.swing.JPanel motorControlPanel;
    private javax.swing.JSlider motorControlSlider;
    private javax.swing.JLabel pulseWidthLabel;
    private javax.swing.JButton rebootButton;
    private javax.swing.JPanel roverUtilitiesPanel;
    private javax.swing.JButton saveTrimButton;
    private javax.swing.JComboBox servoControlDropdown;
    private javax.swing.JPanel servoControlPanel;
    private javax.swing.JSlider servoControlSlider;
    private javax.swing.JPanel steeringTrimPanel;
    private javax.swing.JToggleButton toggleBrakesButton;
    // End of variables declaration//GEN-END:variables
}
