//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlReceiveProcess.java
//
// PURPOSE: Handles the receiving of heartbeats and other commands from the
//          rover and updates the GUI with the data received from these commands
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for parsing of JSON formatting heartbeat
import org.json.simple.JSONObject;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlReceiveProcess extends Thread
{

    //--------------------------------------------------------------------------
    // Name:        run
    // Description: Called when the start() method is called on the thread.
    //              Continually loops to receive commands from the rover and
    //              update the GUI with any data received
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    @Override
    public void run()
    {

        System.out.println("Control receive process started.");

        // Loop to receive commands continually
        while (true)
        {

            // Receive the command string from the rover over TCP
            String receivedCommandString = ControlCommunicator.receiveCommand();
            System.out.println(receivedCommandString);

            if (receivedCommandString != null)
            {

                // Parse the JSON formatted string into a JSONObject
                JSONObject receivedCommandJson = ControlCommunicator.parseJsonString(receivedCommandString);

                // Get the name of the command received
                String commandType = (String) receivedCommandJson.get("command");

                // If the received command is a rover heartbeat
                if (commandType.equalsIgnoreCase("heartbeat"))
                {

                    // Parse the heartbeat contents into their respective variables
                    Double lat = (Double) receivedCommandJson.get("lat");
                    Double lon = (Double) receivedCommandJson.get("long");
                    Double alt = (Double) receivedCommandJson.get("alt");
                    Double spd = (Double) receivedCommandJson.get("speed");
                    Double cpu = (Double) receivedCommandJson.get("cpu");

                    // Update the GUI with the received information
                    ControlMain.controlGui.setConnected(ControlCommunicator.roverIpAddress);
                    ControlMain.controlGui.setGpsData(lat, lon, alt, spd);
                    ControlMain.controlGui.setCpuData(cpu);
                    
                    // If the Latitude and Longitude are 0.0, there is no lock
                    if (lat == 0.0 && lon == 0.0)
                    {
                        
                        // Set the map panel to display no lock
                        ControlMain.controlGui.setMapUrl("None");
                        
                    } // if
                    else
                    {
                        
                        // Form the Google Maps API image request URL. This API key was
                        // created by Stephen Krauss Dec. 2015
                        String API_KEY = "AIzaSyCS2GRFCIvolvoawtUIyUbjBde6INSrRbw";
                        String mapRequestUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + lat + "," + lon + "&zoom=20&size=1000x1000&maptype=satellite&format=jpg&markers=color:red|" + lat + "," + lon + "&key=" + API_KEY;

                        // Set the map panel to display the GPS map
                        ControlMain.controlGui.setMapUrl(mapRequestUrl);
                        
                    } // else

                } // if

            } // if

        } // while

    } // run

} // ControlReceiveThread class

