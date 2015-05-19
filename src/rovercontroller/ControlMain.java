//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    RoverController.java
//
// PURPOSE: Rover controller main class that contains the main state machine, 
//          sets up video player, overlays, and communications with the rover.
//
// AUTHOR:  S. Krauss
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
    public static Process videoReceiveProcess;
    public static Process audioReceiveProcess;
    
    // Gstreamer settings
    public static String gstreamerPath = "\"C:\\Users\\Stephen\\Google Drive\\Robo-Ops 2015 Programming\\Misc\\gstreamer\\1.0\\x86\\bin\\gst-launch-1.0.exe\"";
    public static int videoReceivePort = 1338;
    public static int audioReceivePort = 1339;
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
        videoReceiveProcess = startVideoReceive(0);
        audioReceiveProcess = startAudioReceive();
        
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
                stopGstreamerProcess(videoReceiveProcess);
                stopGstreamerProcess(audioReceiveProcess);

                System.out.println("Control software shut down.");
                System.out.println("------------------------------------------------------------------------------");
            } // run

        }); // addShutdownHook

    } // main

    //--------------------------------------------------------------------------
    // Name:        startVideoReceive
    // Description: Initializes gstreamer to receive a video stream over UDP
    // Arguments:   - int protocol, 0 for UDP and 1 for TCP video stream
    // Returns:     - Process, the gstreamer process
    //--------------------------------------------------------------------------
    public static Process startVideoReceive(int protocol)
    {

        // Stop the any currently running gstreamer process
        stopGstreamerProcess(videoReceiveProcess);
        
        // Form the command used to start gstreamer to receive the video stream
        String gstreamerCommand;
        if(protocol == 0)
        {
            gstreamerCommand = gstreamerPath + " udpsrc port=" + videoReceivePort + " ! h264parse ! avdec_h264 ! autovideosink sync=false";
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

    } // startVideoReceive
    
    //--------------------------------------------------------------------------
    // Name:        startAudioReceive
    // Description: Initializes gstreamer to receive an audio stream over UDP
    // Arguments:   N/A
    // Returns:     - Process, the gstreamer process
    //--------------------------------------------------------------------------
    public static Process startAudioReceive()
    {

        // Stop the any currently running gstreamer process
        stopGstreamerProcess(audioReceiveProcess);
        
        // Form the command used to start gstreamer to receive the audio stream
        String gstreamerCommand = gstreamerPath + "udpsrc port=" + audioReceivePort + " caps=\"application/x-rtp\" ! rtppcmadepay ! alawdec ! autoaudiosink";
        
        // Set up a variable for the gstreamer process that will be returned
        Process streamProcess = null;

        // Get the current runtime to execute the gstreamer command
        Runtime runtime = Runtime.getRuntime();

        try
        {

            // Execute the gstreamer command to start gstreamer
            streamProcess = runtime.exec(gstreamerCommand);
            System.out.println("Started receiving gstreamer audio stream.");

        } // try
        catch (Exception ex)
        {
            
            System.out.println(ex);
            
            System.out.println("ERROR: gstreamer failed to start.");

        } // catch

        return streamProcess;

    } // startAudioReceive

    //--------------------------------------------------------------------------
    // Name:        stopGstreamerProcess
    // Description: Stops the gstreamer stream process
    // Arguments:   - Process videoReceiveProcess, gstreamer process to stop
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public static void stopGstreamerProcess(Process gstreamerProcess)
    {
        if(gstreamerProcess != null)
        {
            // Kill the gstreamer process
            gstreamerProcess.destroy();
        }

    } // stopGstreamerProcess

} // ControlMain class
