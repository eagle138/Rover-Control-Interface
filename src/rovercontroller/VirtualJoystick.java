//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    VirtualJoystick.java
//
// PURPOSE:
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class VirtualJoystick extends JPanel implements ChangeListener 
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // Joystick axis positions scaled to a range of -1 to 1, with 0 being center
    public double joyXAxis = 0;
    public double joyYAxis = 0;

    // If true, the joystick will return to the center position when released
    private boolean returnToCenter = true;
    
    // Maximum x and y value of the joystick joyPosition in pixels
    private int joyMaxValue;

    // Joystick center joyPosition in pixels relative to its panel
    private int joyCenterX, joyCenterY;

    // Joystick x and y distance from center in pixels
    private int dx = 0;
    private int dy = 0;
 
    // Joystick Knob size in pixels
    private int joystickKnobSize = 60;
    
    // Load the joystick knob image and scale it
    private ImageIcon joystickKnobIcon = new ImageIcon(getClass().getResource("/joystickKnob.png"));//.getImage()).getScaledInstance(joystickKnobSize, joystickKnobSize, java.awt.Image.SCALE_SMOOTH);
    
    //--------------------------------------------------------------------------
    // VirtualJoystick Constructor
    //--------------------------------------------------------------------------
    public VirtualJoystick()
    {

        setLayout(new BorderLayout(0, 0));

        // Set up a mouse adapter to listen for mouse pressed, mouse dragged,
        // and mouse released events
        MouseAdapter mouseAdapter = new MouseAdapter()
        {

            @Override
            public void mousePressed(MouseEvent event)
            {

                if (SwingUtilities.isLeftMouseButton(event))
                {

                    // Update the joystick axis values based on the position of
                    // the mouse when the event was triggered
                    updateAxisValues(event.getX(), event.getY());

                    // Repaint the joystick panel
                    repaint();

                    // Fire a joystick state changed event
                    fireStateChanged();

                } // if

            } // mousePressed

            @Override
            public void mouseDragged(MouseEvent event)
            {

                if (SwingUtilities.isLeftMouseButton(event))
                {

                    // Update the joystick axis values based on the position of
                    // the mouse when the event was triggered
                    updateAxisValues(event.getX(), event.getY());

                    // Repaint the joystick panel
                    repaint();

                    // Fire a joystick state changed event
                    fireStateChanged();

                } // if

            } // mouseDragged

            @Override
            public void mouseReleased(MouseEvent event)
            {

                if(returnToCenter == true)
                {
                    if (SwingUtilities.isLeftMouseButton(event))
                    {

                        // Move the joystick back to its center upon mouse release
                        updateAxisValues(joyCenterX, joyCenterY);

                        // Repaint the joystick panel
                        repaint();

                        // Fire a joystick state changed event
                        fireStateChanged();

                    } // if
                    
                } // if

            } // mouseDragged

        };

        // Add the mouse and mouse motion listeners to the panel
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
       
    } // VirtualJoystick constructor

    
    //--------------------------------------------------------------------------
    // Name:        updateAxisValues
    // Description: Updates the joystick axis values based on the location
    //              of the mouse
    // Arguments:   - int mouseX, x position of the mouse in pixels
    //              - int mouseY, y position of the mouse in pixels
    // Returns:     N/A
    //--------------------------------------------------------------------------
    private void updateAxisValues(int mouseX, int mouseY)
    {

        // Calculate the cursor distances from the joystick center
        dx = mouseX - joyCenterX;
        dy = mouseY - joyCenterY;

        // Ensure the joystick position is within its limits
        if (dx > joyMaxValue)  dx = joyMaxValue; 
        if (dy > joyMaxValue)  dy = joyMaxValue;
        if (dx < -joyMaxValue) dx = -joyMaxValue;
        if (dy < -joyMaxValue) dy = -joyMaxValue;

        // Scale and update the joystick axis values
        joyXAxis = (double) dx / (double) joyMaxValue;
        joyYAxis = -(double) dy / (double) joyMaxValue;

    } // updateAxisValues

    @Override
    protected void paintComponent(final Graphics g)
    {

        super.paintComponent(g);

        // Get the width and height of the joystick panel
        int joyWidth = getSize().width;
        int joyHeight = getSize().height;

        // Calculate the maximum joystick position in pixels based on panel size
        // and subtract the radius of the indicator to ensure that it fits fully
        // within the panel
        joyMaxValue = Math.min(joyWidth, joyHeight) / 2;
        joyMaxValue = joyMaxValue - joystickKnobSize / 2;

        // If the panel size is 0, don't bother drawing it
        if (joyMaxValue == 0)
        {
            return;
        } // if

        // Calculate the location of the joystick center in pixels
        joyCenterX = joyWidth / 2;
        joyCenterY = joyHeight / 2;

        Graphics2D g2 = (Graphics2D) g;

        // Enable rendering hints to maintain image quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                                                RenderingHints.VALUE_RENDER_QUALITY));

        // Draw the large circular background
        g2.setColor(Color.LIGHT_GRAY);
        int circleDiameter = joyMaxValue * 2;
        g2.fillOval(joyCenterX - circleDiameter / 2, joyCenterY - circleDiameter / 2, circleDiameter, circleDiameter);

        // Draw the joystick position indicator knob
        g2.drawImage(joystickKnobIcon.getImage(), joyCenterX + dx - joystickKnobSize / 2, joyCenterY + dy - joystickKnobSize / 2, joystickKnobSize, joystickKnobSize, null);

    } // paintComponent

    public void setReturnToCenter(boolean returnToCenter)
    {
        
        this.returnToCenter = returnToCenter;
        
    } // setReturnToCenter
    
    public void setJoystickKnobSize(int size)
    {
        
        this.joystickKnobSize = size;
        
    } // setJoystickKnobSize
    
    void addChangeListener(ChangeListener listener)
    {
        
        listenerList.add(ChangeListener.class, listener);
        
    } // addChangeListener

    void removeChangeListener(ChangeListener listener)
    {
        
        listenerList.remove(ChangeListener.class, listener);
        
    } // removeChangeListener
    
    protected void fireStateChanged()
    {
        
        ChangeEvent e = new PointChangeEvent(this, joyXAxis, joyYAxis);
        
        Object[] listeners = listenerList.getListenerList();
        
        for (int i = listeners.length - 2; i >= 0; i -= 2)
        {
            if (listeners[i] == ChangeListener.class)
            {
                ((ChangeListener) listeners[i + 1]).stateChanged(e);
            } // if
        } // for
        
    } // fireStateChanged

    @Override
    public void stateChanged(ChangeEvent e)
    {
        System.out.println("State changed");
    }

} // VirtualJoystick class

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
class PointChangeEvent extends ChangeEvent
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    public double joyXAxis;
    public double joyYAxis;

    //--------------------------------------------------------------------------
    // PointChangeEvent Constructor
    //--------------------------------------------------------------------------
    public PointChangeEvent(Object source, double joyXAxis, double joyYAxis)
    {
        
        super(source);
        this.joyXAxis = joyXAxis;
        this.joyYAxis = joyYAxis;
        
    } // PointChangeEvent constructor

}  // PointChangeEvent class