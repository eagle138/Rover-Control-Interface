//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    GamepadInterface.java
//
// PURPOSE: Utilizes the jInput library to collect input data from a gamepad
//          and provides methods to access that data
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for jInput gamepad input gathering
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class GamepadInterface
{

    // Boolean to hold the gamepad connection status
    public boolean connected = false;

    // Controller class to hold the gamepad instance
    private Controller gamepad = null;

    // Array of gamepad components
    private Component[] components;

    //--------------------------------------------------------------------------
    // GamepadInterface Constructor
    //--------------------------------------------------------------------------
    public GamepadInterface()
    {

        // Get a list of connected USB controllers
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        // Loop through the connected controllers and look for gamepads
        for (int i = 0; i < controllers.length && gamepad == null; i++)
        {
            
            // If the controller is a gamepad
            if (controllers[i].getType() == Controller.Type.GAMEPAD)
            {

                // Assign the gamepad to the global variable
                gamepad = controllers[i];
                //System.out.println("Found gamepad: " + gamepad.getName());

                // Populate the gamepad's component global variable
                components = gamepad.getComponents();

                // Set the gamepad connection status to true
                connected = true;

            } // if

        } // for

        // If a gamepad could not be found
        if (gamepad == null)
        {

            //System.out.println("No gamepads found.");

            // Set the gamepad connection status to false
            connected = false;

        } // if

    } // GamepadInterface constructor

    //--------------------------------------------------------------------------
    // Name:        getComponents
    // Description: Prints the name of every control components of the gamepad
    // Arguments:   N/A
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void getComponents()
    {

        // Poll the gamepad to update data
        gamepad.poll();

        // Loop through the components and print their names
        for (int i = 0; i < components.length; i++)
        {
            
            // Print the component name
            System.out.println("Component " + i + ": " + components[i].getPollData());
            
        } // for

    } // getComponents

    //--------------------------------------------------------------------------
    // Name:        getComponentValue
    // Description: Returns the current value of a gamepad control component
    // Arguments:   - int componentNum, component number to get value from
    // Returns:     - float, current value of the specified component
    //--------------------------------------------------------------------------
    public double getComponentValue(int componentNum)
    {

        // Poll the gamepad to update data
        gamepad.poll();

        // Retun the component value
        return (double) components[componentNum].getPollData();

    } // getComponentValue

} // GamepadInterface class
