//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlUtilityWindow.java
//
// PURPOSE: Handles the assembly and display of the of the rover utility 
//          window. Window is constructed with NetBeans IDE.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

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
    
    // Turn mode variable. True for radial turn, false for normal steering
    private boolean radialTurnEnabled = false;
    
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

        motorControlPanel = new javax.swing.JPanel();
        enableRcControlButton = new javax.swing.JToggleButton();
        toggleRadialTurnButton = new javax.swing.JToggleButton();
        virtualDrivingPanel = new javax.swing.JPanel();
        drivingJoystick = new rovercontroller.VirtualJoystick();
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
        servoControlPanel2 = new javax.swing.JPanel();
        servoControlSlider = new javax.swing.JSlider();
        servoControlDropdown = new javax.swing.JComboBox();
        servoControlLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        motorControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Motor Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        enableRcControlButton.setText("Enable RC Control");
        enableRcControlButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                enableRcControlButtonActionPerformed(evt);
            }
        });

        toggleRadialTurnButton.setText("Toggle Radial Turn");
        toggleRadialTurnButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                toggleRadialTurnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout motorControlPanelLayout = new javax.swing.GroupLayout(motorControlPanel);
        motorControlPanel.setLayout(motorControlPanelLayout);
        motorControlPanelLayout.setHorizontalGroup(
            motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleRadialTurnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enableRcControlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        motorControlPanelLayout.setVerticalGroup(
            motorControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enableRcControlButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleRadialTurnButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        virtualDrivingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Virtual Driving", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        drivingJoystick.addChangeListener(new javax.swing.event.ChangeListener()
            {
                public void stateChanged(javax.swing.event.ChangeEvent evt)
                {
                    drivingJoystickStateChanged(evt);
                }
            });

            drivingJoystick.setReturnToCenter(true);
            drivingJoystick.setJoystickKnobSize(120);

            javax.swing.GroupLayout virtualDrivingPanelLayout = new javax.swing.GroupLayout(virtualDrivingPanel);
            virtualDrivingPanel.setLayout(virtualDrivingPanelLayout);
            virtualDrivingPanelLayout.setHorizontalGroup(
                virtualDrivingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(virtualDrivingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(drivingJoystick, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addContainerGap())
            );
            virtualDrivingPanelLayout.setVerticalGroup(
                virtualDrivingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(virtualDrivingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(drivingJoystick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
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
                    .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(saveTrimButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                            .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(backLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(frontRightWheelLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(frontLeftWheelLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(backLeftWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backRightWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frontLeftWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frontRightWheelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            steeringTrimPanelLayout.setVerticalGroup(
                steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(steeringTrimPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(frontRightWheelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(frontRightWheelSpinner))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(frontLeftWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(frontLeftWheelSpinner))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backRightWheelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(backRightWheelSpinner))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(steeringTrimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backLeftWheelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backLeftWheelSpinner))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveTrimButton)
                    .addContainerGap())
            );

            servoControlPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Servo Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

            servoControlSlider.setMajorTickSpacing(5);
            servoControlSlider.setMaximum(90);
            servoControlSlider.setMinimum(-90);
            servoControlSlider.setMinorTickSpacing(1);
            servoControlSlider.setSnapToTicks(true);
            servoControlSlider.setToolTipText("");
            servoControlSlider.setValue(0);
            servoControlSlider.addChangeListener(new javax.swing.event.ChangeListener()
            {
                public void stateChanged(javax.swing.event.ChangeEvent evt)
                {
                    servoControlSliderStateChanged(evt);
                }
            });

            servoControlDropdown.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
            servoControlDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servo 0", "Servo 1", "Servo 2", "Servo 3", "Servo 4", "Servo 5", "Servo 6", "Servo 7", "Servo 8", "Servo 9", "Servo 10", "Servo 11", "Servo 12", "Servo 13", "Servo 14", "Servo 15" }));

            servoControlLabel.setText("0.0");

            javax.swing.GroupLayout servoControlPanel2Layout = new javax.swing.GroupLayout(servoControlPanel2);
            servoControlPanel2.setLayout(servoControlPanel2Layout);
            servoControlPanel2Layout.setHorizontalGroup(
                servoControlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(servoControlPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(servoControlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(servoControlDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(servoControlPanel2Layout.createSequentialGroup()
                            .addComponent(servoControlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(servoControlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            servoControlPanel2Layout.setVerticalGroup(
                servoControlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(servoControlPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(servoControlDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(servoControlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(servoControlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servoControlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(steeringTrimPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servoControlPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(motorControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(virtualDrivingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(virtualDrivingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(motorControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(servoControlPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(steeringTrimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

private void drivingJoystickStateChanged(javax.swing.event.ChangeEvent evt)                                                
{                                       

    // Motor speed and driving angle maximum value
    double maxMotorSpeed = 1.0;
    double maxSteeringAngle = 35;
    double maxRadialTurnSpeed = 1.0;

    // Get the joystick axes values
    double xAxisValue = drivingJoystick.joyXAxis;
    double yAxisValue = drivingJoystick.joyYAxis;

    if(radialTurnEnabled == true)
    {
     
        // Convert the x axis value into radial turn speed
        double radialTurnSpeed = xAxisValue * maxRadialTurnSpeed;
        
        // Send the radial turn command
        RoverInterface.sendCommand("{\"command\":\"place\", \"speed\":" + radialTurnSpeed + "}");
        
    } // if
    else
    {
        
        // Convert the axis values into steering angle and motor speed
        double motorSpeed = yAxisValue * maxMotorSpeed * -1.0;
        int steeringAngle = (int)(xAxisValue * maxSteeringAngle);
        
        // Send the steering and motor speed commands
        RoverInterface.sendCommand("{\"command\":\"steer\", \"angle\":" + steeringAngle + "}");
        RoverInterface.sendCommand("{\"command\":\"motorspeed\", \"speed\":" + motorSpeed + "}");
        
    } // else
 
}  
    
    private void enableRcControlButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_enableRcControlButtonActionPerformed
    {//GEN-HEADEREND:event_enableRcControlButtonActionPerformed

        // If the button was pressed down, send brake on command
        if(enableRcControlButton.isSelected())
        {
            RoverInterface.sendCommand("{\"command\":\"rcmode\"}");
        } // if

        // Otherwise, send brake off command
        else
        {
            RoverInterface.sendCommand("{\"command\":\"wifimode\"}");
        } // else

    }//GEN-LAST:event_enableRcControlButtonActionPerformed

    private void saveTrimButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveTrimButtonActionPerformed
    {//GEN-HEADEREND:event_saveTrimButtonActionPerformed
        
        // Send the JSON formatted trim command
        RoverInterface.sendCommand("{\"command\":\"trim\"}");
        
    }//GEN-LAST:event_saveTrimButtonActionPerformed

    private void frontRightWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_frontRightWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_frontRightWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) frontRightWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        RoverInterface.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_FRONT_RIGHT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_frontRightWheelSpinnerStateChanged

    private void frontLeftWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_frontLeftWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_frontLeftWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) frontLeftWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        RoverInterface.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_FRONT_LEFT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_frontLeftWheelSpinnerStateChanged

    private void backRightWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_backRightWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_backRightWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) backRightWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        RoverInterface.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_BACK_RIGHT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_backRightWheelSpinnerStateChanged

    private void backLeftWheelSpinnerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_backLeftWheelSpinnerStateChanged
    {//GEN-HEADEREND:event_backLeftWheelSpinnerStateChanged
        
        // Get the value of the angle spinner
        int servoAngle = (int) backLeftWheelSpinner.getValue();

        // Send the JSON formatted servo move command
        RoverInterface.sendCommand("{\"command\":\"servo\", \"servonum\":" + (SERVO_WHEEL_BACK_LEFT) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_backLeftWheelSpinnerStateChanged

    private void servoControlSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_servoControlSliderStateChanged
    {//GEN-HEADEREND:event_servoControlSliderStateChanged
                
        // Get the value of the angle spinner
        int servoAngle = (int) servoControlSlider.getValue();
        
        // Get the selected servo number form the dropdown
        int selectedServo = servoControlDropdown.getSelectedIndex();

        // Change the label to display the angle value
        servoControlLabel.setText("" + servoAngle);
        
        // Send the JSON formatted servo move command
        RoverInterface.sendCommand("{\"command\":\"servo\", \"servonum\":" + (selectedServo) + ", \"angle\":" + (servoAngle) + "}");
        
    }//GEN-LAST:event_servoControlSliderStateChanged

    private void toggleRadialTurnButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_toggleRadialTurnButtonActionPerformed
    {//GEN-HEADEREND:event_toggleRadialTurnButtonActionPerformed
               
        if(toggleRadialTurnButton.isSelected())
        {
            
            radialTurnEnabled = true;
                    
        } // if

        // Otherwise, send brake off command
        else
        {
            
            radialTurnEnabled = false;
            
        } // else
        
    }//GEN-LAST:event_toggleRadialTurnButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLeftWheelLabel;
    private javax.swing.JSpinner backLeftWheelSpinner;
    private javax.swing.JLabel backRightWheelLabel;
    private javax.swing.JSpinner backRightWheelSpinner;
    private rovercontroller.VirtualJoystick drivingJoystick;
    private javax.swing.JToggleButton enableRcControlButton;
    private javax.swing.JLabel frontLeftWheelLabel;
    private javax.swing.JSpinner frontLeftWheelSpinner;
    private javax.swing.JLabel frontRightWheelLabel;
    private javax.swing.JSpinner frontRightWheelSpinner;
    private javax.swing.JPanel motorControlPanel;
    private javax.swing.JButton saveTrimButton;
    private javax.swing.JComboBox servoControlDropdown;
    private javax.swing.JLabel servoControlLabel;
    private javax.swing.JPanel servoControlPanel2;
    private javax.swing.JSlider servoControlSlider;
    private javax.swing.JPanel steeringTrimPanel;
    private javax.swing.JToggleButton toggleRadialTurnButton;
    private javax.swing.JPanel virtualDrivingPanel;
    // End of variables declaration//GEN-END:variables
}
