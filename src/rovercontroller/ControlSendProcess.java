//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlSendProcess.java
//
// PURPOSE: Handles the gathering of user input from joysticks and gamepads and
//          sends it as control commands to the rover at the set interval.
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for thread sleeping between input gathering intervals
import static java.lang.Thread.sleep;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class ControlSendProcess extends Thread
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Interval at which to gather input data and send it to the rover. Lower
    // interval gives smoother control but has a higher datarate.
    int SEND_INTERVAL_MS = 200;
    
    // Angle of steering servos
    double steeringAngle = 0;

    // Speed of the rover motors
    double motorSpeed = 0;

    //--------------------------------------------------------------------------
    // Name:        run
    // Description: Called when the start() method is called on the thread.
    //              Checks for user input and sends it to the rover over TCP
    //              using JSON formatted commands
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    @Override
    public void run()
    {

        System.out.println("Control send thread started.");

        // Loop to continually check for user input from gamepads and joysticks
        // and send it to the rover at the defined interval.
        while (true)
        {

            // Create a new joystick and gamepad instance every loop in case
            // the joystick or gamepad get unplugged or plugged back in.
            JoystickInterface joystick = new JoystickInterface();
            GamepadInterface gamepad = new GamepadInterface();
            
            // Only gather input and send it if rover connection is established
            if (!ControlCommunicator.roverIpAddress.equalsIgnoreCase("None"))
            {

                // If a joystick is connected
                if (joystick.connected == true)
                {

                    // Determine the steering angle. Joystick axis values go
                    // from -1 to 1, so multiply by 90 degrees for a full range
                    // of steering from -90 to 90 degrees
                    double joystickXValue = ((round((joystick.getComponentValue(2)), 2)) * 90.0);

                    // If the steering angle has changed
                    if (joystickXValue != steeringAngle)
                    {
                        
                        steeringAngle = joystickXValue;
                        
                        // Get the JSON formatted steer command and send it
                        ControlCommunicator.sendCommand("{\"command\":\"steer\", \"angle\":" + steeringAngle + "}");
                        
                    } // if
                    
                    // Determine the motor speed value. Since joystick axis
                    // values go from -1 to 1, and so does the motor speed
                    // command, the axis value doesn't have to be adjusted.
                    double joystickYValue = round(joystick.getComponentValue(1), 2);

                    // If the motor speed has changed
                    if (joystickYValue != motorSpeed)
                    {

                        motorSpeed = joystickYValue;

                        // Send the JSON formatted motor speed command
                        ControlCommunicator.sendCommand("{\"command\":\"motorspeed\", \"speed\":" + motorSpeed + "}");

                    } // if
                    
                } // if joystick connected
                
                // If a gamepad is connected
                if (gamepad.connected == true)
                {
                    
                    // Determine position increments from joystick position
                    double dx = ((round((joystick.getComponentValue(0)), 2)) * 1.0);
                    double dy = ((round((joystick.getComponentValue(1)), 2)) * 1.0);
                    double dz = ((round((joystick.getComponentValue(2)), 2)) * 1.0);

                    if ((dx < 0.3) && (dx > -0.3))
                    {
                        dx = 0;
                    }

                    if ((dy < 0.3) && (dy > -0.3))
                    {
                        dy = 0;
                    }
                    
                    if ((dz < 0.3) && (dz > -0.3))
                    {
                        dz = 0;
                    }

                    if ((dx != 0) || (dy != 0) || (dz != 0))
                    {

                        ControlCommunicator.sendCommand("{\"command\":\"clawinc\", \"dx\":" + (dx) + ", \"dy\":" + (dy) + ", \"dz\":" + (dz) + "}");

                    } // if
                    
                } // if gamepad connected

            } // if rover connection

            // Sleep the thread so that data is not sent to the rover too
            // quickly. Lower sleep is smoother movement but a higher
            // datarate usage
            try
            {
                sleep(SEND_INTERVAL_MS);
            } catch (Exception ex)
            {
            }

        } // while

    } // run

    //--------------------------------------------------------------------------
    // Name:        round
    // Description: Rounds a double to the specified number of decimal places
    // Arguments:   - double value, value to round
    //              - int places, number of decimal places to round to
    // Returns:     - double, rounded value
    //--------------------------------------------------------------------------
    public static double round(double value, int places)
    {

        // Ensure a positive number of places
        if (places < 0)
        {
            places = 0;
        } // if

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;

    } // round

} // ControlReceiveThread class
