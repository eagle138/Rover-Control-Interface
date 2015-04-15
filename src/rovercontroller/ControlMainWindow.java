//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlMainWindow.java
//
// PURPOSE: Handles the assembly and display of the of the rover control GUI. 
//          GUI is constructed with NetBeans IDE.
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for connection status label color
import java.awt.Color;

// Imported for GPS data number formatting
import java.text.DecimalFormat;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlMainWindow extends javax.swing.JFrame
{

    //--------------------------------------------------------------------------
    // ControlMainWindow Constructor
    //--------------------------------------------------------------------------
    public ControlMainWindow()
    {

        // Set the "Look and Feel" of the GUI to the windows default
        this.setLookAndFeel("Windows");

    } // ControlMainWindow constructor

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

        // Set the connection status to disconnected
        this.setDisconnected();

        // Make the GUI visible
        this.setVisible(true);

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
            System.out.println("ERROR: Couldn't set look and feel.");
        } // catch

    } // setLookAndFeel

    //--------------------------------------------------------------------------
    // Name:        setConnected
    // Description: Sets the rover connection status to Connected.
    // Arguments:   - String roverIpAddress, IP address of the rover
    // Returns:     N/A
    //--------------------------------------------------------------------------    
    public void setConnected(String roverIpAddress)
    {

        // Set the rover IP address label text
        roverIPDisplayLabel.setText(roverIpAddress);

        // Change the connection indicator to green and "Connected"
        roverConnectionStatusDisplayLabel.setText("Connected");
        roverConnectionStatusDisplayLabel.setBackground(Color.green);

        // Repaint the connection panel
        roverConnectionStatusPanel.repaint();

    } // setConnected

    //--------------------------------------------------------------------------
    // Name:        initializeGui
    // Description: Sets the rover connection status to Disconnected
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void setDisconnected()
    {

        // Change the connection indicator to red and "Disconnected"
        roverConnectionStatusDisplayLabel.setText("Disconnected");
        roverConnectionStatusDisplayLabel.setBackground(Color.red);

        // Repaint the connection panel
        roverConnectionStatusPanel.repaint();

    } // setDisconnected

    //--------------------------------------------------------------------------
    // Name:        setGpsData
    // Description: Sets the GPS data display to the given GPS data
    // Arguments:   - Double latitude, GPS latitude data
    //              - Double longitude, GPS longitude data
    //              - Double altitude, GPS altitude data    
    //              - Double speed, GPS speed data 
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void setGpsData(Double latitude, Double longitude, Double altitude, Double speed)
    {

        // Set up the formatting for the GPS data
        DecimalFormat coordFormat = new DecimalFormat("+#.0000000;-#.0000000");
        DecimalFormat altFormat = new DecimalFormat("0.00");
        DecimalFormat speedFormat = new DecimalFormat("0.000");

        if (latitude == 0.0 && longitude == 0.0)
        {

            latDisplayLabel.setText("No lock.");
            longDisplayLabel.setText("No lock.");
            altDisplayLabel.setText("No lock.");
            speedDisplayLabel.setText("No lock.");

        } // if
        else
        {

            // Convert the GPS data into strings using their formatting
            String lat = coordFormat.format(latitude);
            String lon = coordFormat.format(longitude);
            String alt = altFormat.format(altitude);
            String spd = speedFormat.format(speed);

            // Set the text on the display labels
            latDisplayLabel.setText(lat + " deg");
            longDisplayLabel.setText(lon + " deg");
            altDisplayLabel.setText(alt + " m");
            speedDisplayLabel.setText(spd + " m/s");

        } // else

    } // setGpsData

    //--------------------------------------------------------------------------
    // Name:        setCpuData
    // Description: Sets the cpu usage display data
    // Arguments:   - double cpu, CPU usage percentage
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void setCpuData(double cpu)
    {

        // Set the map URL
        cpuUsageDisplayLabel.setText(""+cpu);

    } // setMapUrl
    
    //--------------------------------------------------------------------------
    // Name:        setMapUrl
    // Description: Sets the google maps image URL for the map display
    // Arguments:   - String mapUrlString, string containing the map image URL
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void setMapUrl(String mapUrlString)
    {

        // Set the map URL
        mapPanel.setUrl(mapUrlString);
        mapPanel.repaint();
        mapPanel.revalidate();

    } // setMapUrl

    //--------------------------------------------------------------------------
    // Code generated by NetBeans. DO NOT MODIFY.
    //--------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        roverConnectionStatusPanel = new javax.swing.JPanel();
        roverConnectionStatusDisplayLabel = new javax.swing.JTextField();
        roverIPLabel = new javax.swing.JLabel();
        roverIPDisplayLabel = new javax.swing.JLabel();
        cpuUsageLabel = new javax.swing.JLabel();
        bwUsageLabel = new javax.swing.JLabel();
        batteryLabel = new javax.swing.JLabel();
        cpuUsageDisplayLabel = new javax.swing.JLabel();
        bwUsageDisplayLabel = new javax.swing.JLabel();
        batteryDisplayLabel = new javax.swing.JLabel();
        latLabel = new javax.swing.JLabel();
        latDisplayLabel = new javax.swing.JLabel();
        longDisplayLabel = new javax.swing.JLabel();
        longLabel = new javax.swing.JLabel();
        altLabel = new javax.swing.JLabel();
        altDisplayLabel = new javax.swing.JLabel();
        speedDisplayLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        mapPanel = new rovercontroller.MapPanel();
        roverImagePanel1 = new rovercontroller.RoverImagePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        windowsMenu = new javax.swing.JMenu();
        armControlWindowItem = new javax.swing.JMenuItem();
        videoControlWindowItem = new javax.swing.JMenuItem();
        utilityControlWindowItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rover Control GUI");

        roverConnectionStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Rover Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        roverConnectionStatusDisplayLabel.setBackground(new java.awt.Color(255, 0, 0));
        roverConnectionStatusDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        roverConnectionStatusDisplayLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roverConnectionStatusDisplayLabel.setText("Disconnected");
        roverConnectionStatusDisplayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        roverConnectionStatusDisplayLabel.setFocusable(false);

        roverIPLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        roverIPLabel.setText("Rover IP:");

        roverIPDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        roverIPDisplayLabel.setText("---------------");

        cpuUsageLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        cpuUsageLabel.setText("CPU Usage:");

        bwUsageLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bwUsageLabel.setText("BW Usage:");

        batteryLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        batteryLabel.setText("Battery:");

        cpuUsageDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        cpuUsageDisplayLabel.setText("---------------");

        bwUsageDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bwUsageDisplayLabel.setText("---------------");

        batteryDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        batteryDisplayLabel.setText("---------------");

        latLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        latLabel.setText("Latitude:");

        latDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        latDisplayLabel.setText("---------------");

        longDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        longDisplayLabel.setText("---------------");

        longLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        longLabel.setText("Longitude:");

        altLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        altLabel.setText("Altitude:");

        altDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        altDisplayLabel.setText("---------------");

        speedDisplayLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        speedDisplayLabel.setText("---------------");

        speedLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        speedLabel.setText("Speed:");

        javax.swing.GroupLayout roverConnectionStatusPanelLayout = new javax.swing.GroupLayout(roverConnectionStatusPanel);
        roverConnectionStatusPanel.setLayout(roverConnectionStatusPanelLayout);
        roverConnectionStatusPanelLayout.setHorizontalGroup(
            roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roverConnectionStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roverConnectionStatusPanelLayout.createSequentialGroup()
                        .addComponent(roverConnectionStatusDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roverConnectionStatusPanelLayout.createSequentialGroup()
                        .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(speedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(altLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(latLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roverConnectionStatusPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(batteryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roverIPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bwUsageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpuUsageLabel, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roverIPDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cpuUsageDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bwUsageDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(batteryDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(latDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(altDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speedDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roverConnectionStatusPanelLayout.setVerticalGroup(
            roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roverConnectionStatusPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roverConnectionStatusDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roverIPLabel)
                    .addComponent(roverIPDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpuUsageLabel)
                    .addComponent(cpuUsageDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bwUsageLabel)
                    .addComponent(bwUsageDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batteryLabel)
                    .addComponent(batteryDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(latLabel)
                    .addComponent(latDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longLabel)
                    .addComponent(longDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altLabel)
                    .addComponent(altDisplayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roverConnectionStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedLabel)
                    .addComponent(speedDisplayLabel)))
        );

        windowsMenu.setText("Open");

        armControlWindowItem.setText("Arm Control Window");
        armControlWindowItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                armControlWindowItemActionPerformed(evt);
            }
        });
        windowsMenu.add(armControlWindowItem);

        videoControlWindowItem.setText("Video Control Window");
        videoControlWindowItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                videoControlWindowItemActionPerformed(evt);
            }
        });
        windowsMenu.add(videoControlWindowItem);

        utilityControlWindowItem.setText("Utility Control Window");
        utilityControlWindowItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                utilityControlWindowItemActionPerformed(evt);
            }
        });
        windowsMenu.add(utilityControlWindowItem);

        jMenuBar1.add(windowsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roverConnectionStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roverImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roverConnectionStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roverImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void armControlWindowItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_armControlWindowItemActionPerformed
    {//GEN-HEADEREND:event_armControlWindowItemActionPerformed

        // Display the arm control window
        ControlMain.armWindow.setVisible(true);

    }//GEN-LAST:event_armControlWindowItemActionPerformed

    private void videoControlWindowItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_videoControlWindowItemActionPerformed
    {//GEN-HEADEREND:event_videoControlWindowItemActionPerformed

        // Display the video control window
        ControlMain.videoWindow.setVisible(true);

    }//GEN-LAST:event_videoControlWindowItemActionPerformed

    private void utilityControlWindowItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_utilityControlWindowItemActionPerformed
    {//GEN-HEADEREND:event_utilityControlWindowItemActionPerformed

        // Display the utility control window
        ControlMain.utilityWindow.setVisible(true);

    }//GEN-LAST:event_utilityControlWindowItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altDisplayLabel;
    private javax.swing.JLabel altLabel;
    private javax.swing.JMenuItem armControlWindowItem;
    private javax.swing.JLabel batteryDisplayLabel;
    private javax.swing.JLabel batteryLabel;
    private javax.swing.JLabel bwUsageDisplayLabel;
    private javax.swing.JLabel bwUsageLabel;
    private javax.swing.JLabel cpuUsageDisplayLabel;
    private javax.swing.JLabel cpuUsageLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel latDisplayLabel;
    private javax.swing.JLabel latLabel;
    private javax.swing.JLabel longDisplayLabel;
    private javax.swing.JLabel longLabel;
    private rovercontroller.MapPanel mapPanel;
    private javax.swing.JTextField roverConnectionStatusDisplayLabel;
    private javax.swing.JPanel roverConnectionStatusPanel;
    private javax.swing.JLabel roverIPDisplayLabel;
    private javax.swing.JLabel roverIPLabel;
    private rovercontroller.RoverImagePanel roverImagePanel1;
    private javax.swing.JLabel speedDisplayLabel;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JMenuItem utilityControlWindowItem;
    private javax.swing.JMenuItem videoControlWindowItem;
    private javax.swing.JMenu windowsMenu;
    // End of variables declaration//GEN-END:variables

} // ControlMainWindow class
