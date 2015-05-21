//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlVideoWindow.java
//
// PURPOSE: Handles the assembly and display of the of the rover video control 
//          window. Window is constructed with NetBeans IDE.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlVideoWindow extends javax.swing.JFrame
{
   
    //--------------------------------------------------------------------------
    // ControlGui Constructor
    //--------------------------------------------------------------------------
    public ControlVideoWindow()
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

        videoStreamControlPanel = new javax.swing.JPanel();
        startStreamButton = new javax.swing.JButton();
        bitrateField = new javax.swing.JTextField();
        bitrateLabel = new javax.swing.JLabel();
        framerateLabel = new javax.swing.JLabel();
        stopStreamButton = new javax.swing.JButton();
        cameraLabel = new javax.swing.JLabel();
        resolutionDropdown = new javax.swing.JComboBox();
        protocolLabel = new javax.swing.JLabel();
        protocolDropdown = new javax.swing.JComboBox();
        switchCameraButton = new javax.swing.JButton();
        iframeLabel = new javax.swing.JLabel();
        iframeField = new javax.swing.JTextField();
        cameraDropdown = new javax.swing.JComboBox();
        resolutionLabel = new javax.swing.JLabel();
        framerateDropdown = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rover Video Control");
        setResizable(false);

        videoStreamControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Video Stream Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        startStreamButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        startStreamButton.setText("Start Stream");
        startStreamButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startStreamButtonActionPerformed(evt);
            }
        });

        bitrateField.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bitrateField.setText("500000");

        bitrateLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bitrateLabel.setText("Bitrate:");

        framerateLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        framerateLabel.setText("Framerate:");

        stopStreamButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        stopStreamButton.setText("Stop Stream");
        stopStreamButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                stopStreamButtonActionPerformed(evt);
            }
        });

        cameraLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        cameraLabel.setText("Camera:");

        resolutionDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "160x90", "160x120", "176x144", "320x180", "320x240", "352x288", "432x240", "640x360", "640x480", "800x448", "800x600", "864x480", "960x720", "1024x576", "1280x720", "1600x896", "1920x1080" }));

        protocolLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        protocolLabel.setText("Protocol:");

        protocolDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UDP", "TCP" }));

        switchCameraButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        switchCameraButton.setText("Switch Camera");
        switchCameraButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                switchCameraButtonActionPerformed(evt);
            }
        });

        iframeLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        iframeLabel.setText("Iframe:");

        iframeField.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        iframeField.setText("1000");

        cameraDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Camera 0", "Camera 1" }));

        resolutionLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        resolutionLabel.setText("Resolution:");

        framerateDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30", "24", "20", "15", "10", "7", "5", " " }));

        javax.swing.GroupLayout videoStreamControlPanelLayout = new javax.swing.GroupLayout(videoStreamControlPanel);
        videoStreamControlPanel.setLayout(videoStreamControlPanelLayout);
        videoStreamControlPanelLayout.setHorizontalGroup(
            videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoStreamControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(stopStreamButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startStreamButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(videoStreamControlPanelLayout.createSequentialGroup()
                                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cameraLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(protocolLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(protocolDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cameraDropdown, 0, 98, Short.MAX_VALUE)))
                            .addGroup(videoStreamControlPanelLayout.createSequentialGroup()
                                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(iframeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bitrateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(framerateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resolutionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(framerateDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resolutionDropdown, 0, 98, Short.MAX_VALUE)
                                    .addComponent(bitrateField)))
                            .addComponent(iframeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(switchCameraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        videoStreamControlPanelLayout.setVerticalGroup(
            videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoStreamControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cameraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cameraDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(protocolLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(protocolDropdown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resolutionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resolutionDropdown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(framerateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(framerateDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitrateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bitrateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(videoStreamControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iframeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iframeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startStreamButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopStreamButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(switchCameraButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(videoStreamControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(videoStreamControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startStreamButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startStreamButtonActionPerformed
    {//GEN-HEADEREND:event_startStreamButtonActionPerformed

        // Get the video stream parameters from the text fields and dropdowns
        int cameraNum = cameraDropdown.getSelectedIndex();
        int protocol = protocolDropdown.getSelectedIndex();
        String resolution = (String) resolutionDropdown.getSelectedItem();
        int framerate = Integer.parseInt((String) framerateDropdown.getSelectedItem());
        int bitrate = Integer.parseInt(bitrateField.getText());
        int iframe = Integer.parseInt(iframeField.getText());
        
        // Parse the width and height from the resolution
        String[] resolutionParts = resolution.split("x");
        int width = Integer.parseInt(resolutionParts[0]);
        int height = Integer.parseInt(resolutionParts[1]);
        
        // Send the JSON formatted camera command
        ControlCommunicator.sendCommand(ControlCommunicator.getCameraCommandString(cameraNum, protocol, width, height, framerate, bitrate, iframe));
        
        // Start receiving video
        ControlStreamInterface.startVideoReceive();
        
    }//GEN-LAST:event_startStreamButtonActionPerformed

    private void stopStreamButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stopStreamButtonActionPerformed
    {//GEN-HEADEREND:event_stopStreamButtonActionPerformed

        // Send the JSON formatted camera stop command
        ControlCommunicator.sendCommand("{\"command\":\"videostop\"}");
        
    }//GEN-LAST:event_stopStreamButtonActionPerformed

    private void switchCameraButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_switchCameraButtonActionPerformed
    {//GEN-HEADEREND:event_switchCameraButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_switchCameraButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bitrateField;
    private javax.swing.JLabel bitrateLabel;
    private javax.swing.JComboBox cameraDropdown;
    private javax.swing.JLabel cameraLabel;
    private javax.swing.JComboBox framerateDropdown;
    private javax.swing.JLabel framerateLabel;
    private javax.swing.JTextField iframeField;
    private javax.swing.JLabel iframeLabel;
    private javax.swing.JComboBox protocolDropdown;
    private javax.swing.JLabel protocolLabel;
    private javax.swing.JComboBox resolutionDropdown;
    private javax.swing.JLabel resolutionLabel;
    private javax.swing.JButton startStreamButton;
    private javax.swing.JButton stopStreamButton;
    private javax.swing.JButton switchCameraButton;
    private javax.swing.JPanel videoStreamControlPanel;
    // End of variables declaration//GEN-END:variables
}
