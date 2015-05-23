//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlMain.java
//
// PURPOSE: Rover controller main class that sets up all of the command
//          processes, interface windows, and video/audio streams.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for event dispatch thread GUI drawing
import javax.swing.SwingUtilities;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlMain
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Interface window declarations
    public static ControlMainWindow mainWindow;
    public static ControlArmWindow armWindow;
    public static ControlVideoWindow videoWindow;
    public static ControlUtilityWindow utilityWindow;

    // Command send and receive process declarations
    public static ControlSendProcess sendProcess;
    public static ControlReceiveProcess receiveProcess;
    
    //--------------------------------------------------------------------------
    // Main Path
    //--------------------------------------------------------------------------
    public static void main(final String[] args)
    {

        System.out.println("Rover Control Software -------------------------------------------------------");
        System.out.println("Robo-Ops 2015 - Virginia Tech - Team Vertex");
        System.out.println("Initiating control software startup sequence..");

        // Set up the interface window instances
        mainWindow = new ControlMainWindow();
        armWindow = new ControlArmWindow();
        videoWindow = new ControlVideoWindow();
        utilityWindow = new ControlUtilityWindow();
        
        // Set up the command send and receive process instances
        sendProcess = new ControlSendProcess();
        receiveProcess = new ControlReceiveProcess();
        
        // Start receiving video and audio streams
        ControlStreamInterface.startVideoReceive();
        ControlStreamInterface.startAudioReceive();
        
        // Build and display the main display GUI by adding it to the event 
        // dispatch thread
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                // Initialize the control GUI
                mainWindow.initializeGui();
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
                ControlStreamInterface.stopVideoReceive();
                ControlStreamInterface.stopAudioReceive();

                System.out.println("Control software shut down.");
                System.out.println("------------------------------------------------------------------------------");
            } // run

        }); // addShutdownHook

    } // main

} // ControlMain class
