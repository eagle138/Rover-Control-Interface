//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlStreamInterface.java
//
// PURPOSE: Handles setup and configuration of the gstreamer video and audio
//          stream reception over UDP.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlStreamInterface
{
    
    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------

    // Stream process declarations
    private static Process videoReceiveProcess;
    private static Process audioReceiveProcess;
    
    // Path to gstreamer's gst-launch-1.0.exe
    private static String gstreamerPath = "\"C:\\Users\\Stephen\\Google Drive\\Robo-Ops 2015 Programming\\Misc\\gstreamer\\1.0\\x86\\bin\\gst-launch-1.0.exe\"";
    
    // Gstreamer port settings
    private static int videoReceivePort = 1338;
    private static int audioReceivePort = 1339;
    
    //--------------------------------------------------------------------------
    // Name:        startVideoReceive
    // Description: Initializes gstreamer to receive a video stream over UDP
    // Arguments:   - int protocol, 0 for UDP and 1 for TCP video stream
    // Returns:     - Process, the gstreamer process
    //--------------------------------------------------------------------------
    public static void startVideoReceive()
    {

        // Stop the any currently running gstreamer process
        stopVideoReceive();
        
        // Form the command used to start gstreamer to receive the video stream
        String gstreamerCommand = gstreamerPath + " udpsrc port=" + videoReceivePort + " ! h264parse ! avdec_h264 ! autovideosink sync=false";

        // Get the current runtime to execute the gstreamer command
        Runtime runtime = Runtime.getRuntime();

        try
        {

            // Execute the gstreamer command to start gstreamer
            videoReceiveProcess = runtime.exec(gstreamerCommand);
            
            System.out.println("Started receiving gstreamer video stream.");

        } // try
        catch (Exception ex)
        {
            
            System.out.println("ERROR: Failed to start gstreamer video receive.");

        } // catch

    } // startVideoReceive
    
    //--------------------------------------------------------------------------
    // Name:        startAudioReceive
    // Description: Initializes gstreamer to receive an audio stream over UDP
    // Arguments:   N/A
    // Returns:     - Process, the gstreamer process
    //--------------------------------------------------------------------------
    public static void startAudioReceive()
    {

        // Stop the any currently running audio stream
        stopAudioReceive();
        
        // Form the command used to start gstreamer to receive the audio stream
        String gstreamerCommand = gstreamerPath + "udpsrc port=" + audioReceivePort + " caps=\"application/x-rtp\" ! rtppcmadepay ! alawdec ! autoaudiosink";

        // Get the current runtime to execute the gstreamer command
        Runtime runtime = Runtime.getRuntime();

        try
        {

            // Execute the gstreamer command to start gstreamer
            audioReceiveProcess = runtime.exec(gstreamerCommand);
            
            System.out.println("Started receiving gstreamer audio stream.");

        } // try
        catch (Exception ex)
        {
            
            System.out.println("ERROR: Failed to start gstreamer audio receive.");

        } // catch

    } // startAudioReceive

    //--------------------------------------------------------------------------
    // Name:        stopVideoReceive
    // Description: Stops the gstreamer video receive stream
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public static void stopVideoReceive()
    {
        
        if(videoReceiveProcess != null)
        {
            
            // Kill the gstreamer video receive process
            videoReceiveProcess.destroy();
            
        } // if

    } // stopVideoReceive
    
    //--------------------------------------------------------------------------
    // Name:        stopAudioReceive
    // Description: Stops the gstreamer audio receive stream
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public static void stopAudioReceive()
    {
        
        if(audioReceiveProcess != null)
        {
            
            // Kill the gstreamer video receive process
            audioReceiveProcess.destroy();
            
        } // if

    } // stopAudioReceive
    
}
