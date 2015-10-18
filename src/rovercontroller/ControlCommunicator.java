//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlCommunicator.java
//
// PURPOSE: Uses Java's TCP classes to handle communications to and from the
//          rover. Provides methods to send and receive data as well as form
//          command strings.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for reading from and writing to TCP sockets
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

// Imported for TCP socket functionality
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;

// Imported for JSON parsing and writing
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlCommunicator
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // IP address of the rover as set up on the LogMeIn Hamachi network
    public static String roverIpAddress = "25.125.146.63";

    // Port that the rover is listening for commands on
    public static int roverListenPort = 5000;

    // Port that the rover is using to send commands
    public static int roverSendPort = 5001;

    // Port that this control software will use to listen for heartbeats
    public static int controlListenPort = 5001;

    // Port that this software will use to send commands
    public static int controlSendPort = 5000;

    //--------------------------------------------------------------------------
    // Name:        receiveCommand
    // Description: Listens on the port set by the controlListenPort variable
    //              for data sent from the rover. This is a blocking operation.
    // Arguments:   N/A
    // Returns:     - String, data received from the rover
    //--------------------------------------------------------------------------
    public static String receiveCommand()
    {

        // Command string received from rover
        String receivedString = "";

        try
        {

            // Set up a TCP socket and listen for connections
            ServerSocket serverSocket = new ServerSocket(controlListenPort);
            Socket clientSocket = serverSocket.accept();

            // Read the data from the socket
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read the socket until all data is read
            String receivedLine;
            while ((receivedLine = inputReader.readLine()) != null)
            {
                // Assemble the received lines of data into one string
                receivedString += receivedLine;
            }

            // Close the client and server sockets
            clientSocket.close();
            serverSocket.close();

        } // try
        catch (Exception e)
        {

            System.out.println("ERROR: TCP Exception, could not receive command!");

        } // catch

        // Return the received data
        return receivedString;

    } // receiveCommand

    //--------------------------------------------------------------------------
    // Name:        sendCommand
    // Description: Sends a string to the rover at the IP address and port set
    //              with the roverIpAddress and roverListenPort variables using
    //              a TCP socket.
    // Arguments:   - String command, command string to send to rover
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public static void sendCommand(String command)
    {
        try
        {

            // Initialize the socket connection to the rover IP address           
            Socket clientSocket = new Socket();
            clientSocket.connect(new InetSocketAddress(roverIpAddress, roverListenPort), 1000);

            // Create data output stream for the command to be sent
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            // Write the command to the data stream
            outToServer.writeBytes(command);

            // Close the socket
            clientSocket.close();

        } // try
        catch (Exception ex)
        {

            System.out.println("ERROR: Could not connect to rover!");

            // Set the connection display to disconnected
            ControlMain.mainWindow.setDisconnected();

        } // catch

    } // sendCommand

    //--------------------------------------------------------------------------
    // Name:        parseJsonString
    // Description: Returns a JSONObject parsed from a JSON string. The get()
    //              and put() methods can be used to get and set keys and values
    // Arguments:   - jsonString, angle of steering servo 0 in degrees
    // Returns:     - JSONObject parsed from string
    //--------------------------------------------------------------------------
    public static JSONObject parseJsonString(String jsonString)
    {

        // JSON command object to be returned
        JSONObject jsonObject = null;

        try
        {

            // Create a JSON parser instance
            JSONParser parser = new JSONParser();

            // Use the JSON parser to parse the JSON string into a JSONObkect
            jsonObject = (JSONObject) parser.parse(jsonString);

        } // try
        catch (ParseException ex)
        {

            System.out.print("ERROR: JSON parse Exception!");

        } // catch

        // Return the parsed JSONObject
        return jsonObject;

    } // parseJsonString

    //--------------------------------------------------------------------------
    // Name:        getCameraCommandString
    // Description: Returns a JSON format command string for the camera command
    // Arguments:   - int width, width of video stream in pixels
    //              - int height, height of video stream in pixels
    //              - int fps, framerate of video stream in frames per second
    //              - int maxBitrate, maximum bitrate of video stream in bits
    //                bits per second
    //              - int iframeInt, Iframe interval in seconds
    // Returns:     - String, JSON formatted camera command string
    //--------------------------------------------------------------------------
    public static String getCameraCommandString(int cameraNum, int protocol, int width, int height, int fps, int maxBitrate, int iframeInt)
    {

        // JSON command string to be returned
        String commandString = "";

        try
        {

            // Assemble the JSON object keys and values
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", "videostart");
            jsonObject.put("num", cameraNum);
            jsonObject.put("proto", protocol);
            jsonObject.put("w", width);
            jsonObject.put("h", height);
            jsonObject.put("fps", fps);
            jsonObject.put("bitrate", maxBitrate);
            jsonObject.put("iframe", iframeInt);

            // Write the JSON onject to a string
            StringWriter stringWriter = new StringWriter();
            jsonObject.writeJSONString(stringWriter);
            commandString = stringWriter.toString();

        } // try
        catch (Exception ex)
        {

            System.out.print("ERROR: JSON IO Exception");

        } // catch

        // Return the camera command string
        return commandString;

    } // getCameraCommandString

} // ControlCommunicator class
