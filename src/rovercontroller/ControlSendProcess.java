//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    ControlSendProcess.java
//
// PURPOSE: Handles the gathering of user input from joysticks and gamepads and
//          sends it as control commands to the rover at the set interval.
//
// AUTHOR:  S. Krauss
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
    int sendIntervalMs = 200;
        
    // Joystick and gamepad minimum values. Input valued below this will be
    // ignored to help prevent cases where the joysticks don't return exactly
    // to zero when let go.
    double joystickMinValue = 0.15;
    double gamepadMinValue = 0.3;
    
    // Maximum steering angle for the steering controls
    double maxSteeringAngle = 30;
    
    // Maximum motor speed percentage (1.0 = 100%)
    double maxMotorSpeed = 1.0;
    
    // Maximum radial turn speed percentage (1.0 = 100%)
    double maxRadialTurnSpeed = 1.0;
    
    // Arm movement speed multiplier. Makes the gamepad increment the arm
    // position more quickly
    double armSpeed = 1.0;

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

        // Steering angles and motor speeds for the previous loop iteration
        double prevSteeringAngle = 0;
        double prevMotorSpeed = 0;
        double prevRadialTurnSpeed = 0;
        
        // Loop to continually check for user input from gamepads and joysticks
        // and send it to the rover at the defined interval.
        while (true)
        {

            // Create a new joystick and gamepad instance every loop in case
            // the joystick or gamepad get unplugged or plugged back in.
            JoystickInterface joystick = new JoystickInterface();
            GamepadInterface gamepad = new GamepadInterface();
            
            // Only gather input and send it if rover connection is established
            if (!RoverInterface.roverIpAddress.equalsIgnoreCase("None"))
            {

                // If a joystick is connected
                if (joystick.connected == true)
                {
                    /*
                    // Get the joystick axis values
                    double joystickXValue = joystick.getComponentValue(2);
                    double joystickYValue = joystick.getComponentValue(1);
                         
                    // Ignore joystick values under a certain value
                    if ((joystickXValue < joystickMinValue) && (joystickXValue > -joystickMinValue)) joystickXValue = 0;
                    if ((joystickYValue < joystickMinValue) && (joystickYValue > -joystickMinValue)) joystickYValue = 0;  
    
                    // Calculate the motor speed and steering angle from
                    // the joystick axis values
                    double steeringAngle = (round(joystickXValue, 2) * maxSteeringAngle);
                    double motorSpeed = (round(joystickYValue, 2) * maxMotorSpeed);

                    // If the steering angle has changed
                    if (steeringAngle != prevSteeringAngle)
                    {

                        prevSteeringAngle = steeringAngle;

                        // Get the JSON formatted steer command and send it
                        RoverInterface.sendCommand("{\"command\":\"steer\", \"angle\":" + steeringAngle + "}");

                    } // if

                    // If the motor speed has changed
                    if (motorSpeed != prevMotorSpeed)
                    {

                        prevMotorSpeed = motorSpeed;

                        // Send the JSON formatted motor speed command
                        RoverInterface.sendCommand("{\"command\":\"motorspeed\", \"speed\":" + motorSpeed + "}");

                    } // if
                    */
                    
                    // Get the joystick axis values
                    double joystickXValue = joystick.getComponentValue(2) + 0.0;
                    double joystickYValue = joystick.getComponentValue(1) + 0.2;
                    
                    if(joystickXValue > 1.0)
                    {
                        joystickXValue = 1.0;
                    }
                    else if(joystickXValue < -1.0)
                    {
                        joystickXValue = -1.0;
                    }
                         
                    if(joystickYValue > 1.0)
                    {
                        joystickYValue = 1.0;
                    }
                    else if(joystickYValue < -1.0)
                    {
                        joystickYValue = -1.0;
                    }
                    
                    // Ignore joystick values under a certain value
                    if ((joystickXValue < joystickMinValue) && (joystickXValue > -joystickMinValue)) joystickXValue = 0;
                    if ((joystickYValue < joystickMinValue) && (joystickYValue > -joystickMinValue)) joystickYValue = 0;  
    
                    // Calculate the throttle and steering angle percentage from
                    // the joystick axis values
                    double anglePercent    = round(joystickXValue, 2) * 100.0;
                    double throttlePercent = round(joystickYValue, 2) * -100.0;

                    // If either value has changed
                    if ((anglePercent != prevSteeringAngle) || (throttlePercent != prevMotorSpeed))
                    {

                        prevSteeringAngle = anglePercent;
                        prevMotorSpeed = throttlePercent;

                        // Get the JSON formatted steer command and send it
                        RoverInterface.sendCommand("{\"command\":\"drive\", \"ang\":" + anglePercent + ", \"th\":" + throttlePercent + "}");

                    } // if
                    
                } // if joystick connected
                
                // If a gamepad is connected
                if (gamepad.connected == true)
                {
                    
                    // Get the gamepad axis values
                    double gamepadXValue = gamepad.getComponentValue(0);
                    double gamepadYValue = gamepad.getComponentValue(1);
                    double gamepadZValue = gamepad.getComponentValue(2);
                         
                    // Ignore joystick values under a certain 
                    if ((gamepadXValue < 0.3) && (gamepadXValue > -0.3)) gamepadXValue = 0;
                    if ((gamepadYValue < 0.3) && (gamepadYValue > -0.3)) gamepadYValue = 0;  
                    if ((gamepadZValue < 0.3) && (gamepadZValue > -0.3)) gamepadZValue = 0;
                    
                    // Round the gamepad axis values and multiply by the arm
                    // movement speed setting
                    double dx = round(gamepadXValue, 2) * armSpeed;
                    double dy = round(gamepadYValue, 2) * armSpeed;
                    double dz = round(gamepadZValue, 2) * armSpeed;

                    // Only send the command if one of the increments is nonzero
                    if ((dx != 0) || (dy != 0) || (dz != 0))
                    {

                        // Send the arm position increment command
                        RoverInterface.sendCommand("{\"command\":\"clawinc\", \"dx\":" + (dx) + ", \"dy\":" + (dy) + ", \"dz\":" + (dz) + "}");

                    } // if
                    
                } // if gamepad connected

            } // if rover connection

            // Sleep the thread so that data is not sent to the rover too
            // quickly. Lower sleep is smoother movement but a higher
            // datarate usage
            try
            {
                sleep(sendIntervalMs);
            } // try
            catch (Exception ex)
            {
                System.out.println("ERROR: Exception during thread sleep!");
            } // catch

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
