//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    JoystickInterface.java
//
// PURPOSE: Utilizes the jInput library to collect input data from a joystick
//          and provides methods to access that data
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for jInput joystick input gathering
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class JoystickInterface
{

    // Boolean to hold the joystick connection status
    public boolean connected = false;

    // Controller class to hold the joystick instance
    private Controller joystick = null;

    // Array of joystick components
    private Component[] components;

    //--------------------------------------------------------------------------
    // JoystickInterface Constructor
    //--------------------------------------------------------------------------
    public JoystickInterface()
    {

        // Get a list of connected USB controllers
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        // Loop through the connected controllers and look for joysticks
        for (int i = 0; i < controllers.length && joystick == null; i++)
        {
            
            // If the controller is a joystick
            if (controllers[i].getType() == Controller.Type.STICK)
            {

                // Assign the joystick to the global variable
                joystick = controllers[i];
                //System.out.println("Found joystick: " + joystick.getName());

                // Populate the joystick's component global variable
                components = joystick.getComponents();

                // Set the joystick connection status to true
                connected = true;

            } // if

        } // for

        // If a joystick could not be found
        if (joystick == null)
        {

            //System.out.println("No joysticks found.");

            // Set the joystick connection status to false
            connected = false;

        } // if

    } // JoystickInterface constructor

    //--------------------------------------------------------------------------
    // Name:        getComponents
    // Description: Prints the name of every control components of the joystick
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void getComponents()
    {

        // Poll the joystick to update data
        joystick.poll();

        // Loop through the components and print their names
        for (int i = 0; i < components.length; i++)
        {
            
            // Print the component name
            System.out.println("Component " + i + ": " + components[i].getPollData());
            
        } // for

    } // getComponents

    //--------------------------------------------------------------------------
    // Name:        getComponentValue
    // Description: Returns the current value of a joystick control component
    // Arguments:   - int componentNum, component number to get value from
    // Returns:     - float, current value of the specified component
    //--------------------------------------------------------------------------
    public double getComponentValue(int componentNum)
    {

        // Poll the joystick to update data
        joystick.poll();

        // Retun the component value
        return (double) components[componentNum].getPollData();

    } // getComponentValue

} // JoystickInterface class
