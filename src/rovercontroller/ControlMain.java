//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    RoverController.java
//
// PURPOSE: Rover controller main class that contains the main state machine, 
//          sets up video player, overlays, and communications with the rover.
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for event dispatch thread GUI drawing
import javax.swing.SwingUtilities;

// Imported for determination of local IP address
import java.net.Inet4Address;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlMain
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Interface window declarations
    public static ControlMainWindow controlGui;
    public static ControlArmWindow armWindow;
    public static ControlVideoWindow videoWindow;
    public static ControlUtilityWindow utilityWindow;

    // Process declarations
    public static ControlSendProcess sendProcess;
    public static ControlReceiveProcess receiveProcess;
    public static Process gstreamerProcess;
    
    // Gstreamer settings
    public static String gstreamerPath = "\"C:\\Users\\Stephen\\Google Drive\\Robo-Ops 2015 Programming\\Misc\\gstreamer\\1.0\\x86\\bin\\gst-launch-1.0.exe\"";
    public static int udpReceivePort = 1338;
    public static int tcpConnectPort = 5001;
    
    //--------------------------------------------------------------------------
    // Main Path
    //--------------------------------------------------------------------------
    public static void main(final String[] args)
    {

        System.out.println("Rover Control Software -------------------------------------------------------");
        System.out.println("Robo-Ops 2015 - Virginia Tech - Team Vertex");
        System.out.println("Initiating control software startup sequence..");
        try
        {
            System.out.println("Local IP Address: " + Inet4Address.getLocalHost().getHostAddress());
            System.out.println("Rover IP Address: Waiting for connection...");
        } // try
        catch (Exception ex)
        {
            System.out.println("Local IP Address: ERROR: unknown!");
            System.out.println("Rover IP Address: Waiting for connection...");
        } // catch

        // Set up the GUI and process instances
        controlGui = new ControlMainWindow();
        armWindow = new ControlArmWindow();
        videoWindow = new ControlVideoWindow();
        utilityWindow = new ControlUtilityWindow();
        sendProcess = new ControlSendProcess();
        receiveProcess = new ControlReceiveProcess();
        gstreamerProcess = startGstreamer(0);
        
        // Build and display the main display GUI by adding it to the event 
        // dispatch thread
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // Initialize the control GUI
                controlGui.initializeGui();
            } // run       
        }); // invokeLater
        
        // Build and display the various extra control GUIs by adding them to 
        // the event dispatch thread
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // Initialize the GUIs
                armWindow.initializeGui();
                videoWindow.initializeGui();
                utilityWindow.initializeGui();
            } // run       
        }); // invokeLater
                
        // Start the send and receive processes
        sendProcess.start();
        receiveProcess.start();

        // Add a shutdown hook thread that is called when the control software
        // is closed in order to clean up processes that were started.
        Runtime.getRuntime().addShutdownHook(new Thread()
        {

            @Override
            public void run()
            {
                // Kill the gstreamer stream process
                stopGstreamer(gstreamerProcess);

                System.out.println("Control software shut down.");
                System.out.println("------------------------------------------------------------------------------");
            } // run

        }); // addShutdownHook

    } // main

    //--------------------------------------------------------------------------
    // Name:        startGstreamer
    // Description: Initializes gstreamer to receive a video stream over UDP
    // Arguments:   - String gstreamerPath, path to gst-launch-1.0.exe
    //              - int streamPort, port on which to recieve UDP video stream
    // Returns:     - Process, the gstreamer process
    //--------------------------------------------------------------------------
    public static Process startGstreamer(int protocol)
    {

        // Stop the any currently running gstreamer process
        stopGstreamer(gstreamerProcess);
        
        // Form the command used to start gstreamer to receive the video stream
        String gstreamerCommand;
        if(protocol == 0)
        {
            gstreamerCommand = gstreamerPath + " udpsrc port=" + udpReceivePort + " ! application/x-rtp, payload=96 ! rtph264depay ! h264parse ! avdec_h264 ! autovideosink sync=false";
        }
        else
        {
            gstreamerCommand = gstreamerPath + " tcpclientsrc host = " + ControlCommunicator.roverIpAddress + " port=" + tcpConnectPort + " ! gdpdepay ! application/x-rtp, payload=96 ! rtph264depay ! h264parse ! avdec_h264 ! autovideosink sync=false";
        }
        
        // Set up a variable for the gstreamer process that will be returned
        Process streamProcess = null;

        // Get the current runtime to execute the gstreamer command
        Runtime runtime = Runtime.getRuntime();

        try
        {

            // Execute the gstreamer command to start gstreamer
            streamProcess = runtime.exec(gstreamerCommand);
            System.out.println("Started receiving gstreamer video stream.");

        } // try
        catch (Exception ex)
        {
            
            System.out.println(ex);
            
            System.out.println("ERROR: gstreamer failed to start.");

        } // catch

        return streamProcess;

    } // startGstreamer

    //--------------------------------------------------------------------------
    // Name:        stopGstreamer
    // Description: Stops the gstreamer video stream process
    // Arguments:   - Process gstreamerProcess, gstreamer process to stop
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public static void stopGstreamer(Process gstreamerProcess)
    {
        if(gstreamerProcess != null)
        {
            // Kill the gstreamer process
            gstreamerProcess.destroy();
        }

    } // stopGstreamer

} // ControlMain class
