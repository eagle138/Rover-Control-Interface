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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class VirtualJoystick extends JPanel implements ChangeListener
{

    private JLabel lblPosition;

    public VirtualJoystick()
    {
        setLayout(new BorderLayout(0, 0));
        SimpleJoystick myJoystick = new SimpleJoystick(1);
        myJoystick.setPreferredSize(new Dimension(100, 100));
        myJoystick.addChangeListener(this);
        add(myJoystick, BorderLayout.CENTER);

        lblPosition = new JLabel("position");
        add(lblPosition, BorderLayout.SOUTH);
    }

    @Override
    public void stateChanged(ChangeEvent ev)
    {
        Point p = null;
        try
        {
            p = ((PointChangeEvent) ev).p;
        }
        catch (Exception e)
        {
            return;
        }
        lblPosition.setText("x=" + p.x + " y=" + p.y);
    }

}

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
class SimpleJoystick extends JPanel
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------

    // Joystick axis positions scaled to a range of -1 to 1, with 0 being center
    private double joyXAxis = 0;
    private double joyYAxis = 0;
    
    // Maximum x and y value of the joystick joyPosition in pixels
    private int joyMaxValue;

    // Joystick center joyPosition in pixels relative to its panel
    private int joyCenterX, joyCenterY;

    // Joystick x and y distance from center in pixels
    private int dx = 0;
    private int dy = 0;

    //--------------------------------------------------------------------------
    // SimpleJoystick Constructor
    //--------------------------------------------------------------------------
    public SimpleJoystick(final int joyOutputRange)
    {

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
                    SwingUtilities.getRoot(SimpleJoystick.this).repaint();
                    
                    // Fire a joystick state changed event
                    //fireStateChanged();
                    
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
                    SwingUtilities.getRoot(SimpleJoystick.this).repaint();
                    
                    // Fire a joystick state changed event
                    //fireStateChanged();
                    
                } // if
                
            } // mouseDragged
            
            @Override
            public void mouseReleased(MouseEvent event)
            {
                
                if (SwingUtilities.isLeftMouseButton(event))
                {
                    
                    // Move the joystick back to its center upon mouse release
                    updateAxisValues(joyCenterX, joyCenterY);
                    
                    // Repaint the joystick panel
                    SwingUtilities.getRoot(SimpleJoystick.this).repaint();
                    
                    // Fire a joystick state changed event
                    //fireStateChanged();
                    
                } // if
                
            } // mouseDragged

        };
        
        // Add the mouse and mouse motion listeners to the panel
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
        
    } // SimpleJoystick constructor

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
        joyXAxis =  (double)dx / (double)joyMaxValue;
        joyYAxis = -(double)dy / (double)joyMaxValue;

    } // updateAxisValues

    @Override
    protected void paintComponent(final Graphics g)
    {
        
        super.paintComponent(g);
        
        // Get the width and height of the joystick panel
        int joyWidth = getSize().width;
        int joyHeight = getSize().height;
        
        // Calculate the maximum joystick position in pixels based on panel size
        joyMaxValue = Math.min(joyWidth, joyHeight) / 2;
        
        // If the panel size is 0, don't bother drawing it
        if (joyMaxValue == 0)
        {
            return;
        } // if

        // Calculate the location of the joystick center in pixels
        joyCenterX = joyWidth / 2;
        joyCenterY = joyHeight / 2;
        
        Graphics2D g2 = (Graphics2D) g;
        
        // Enable antialiasing 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter;

        // Draw the large circular background
        g2.setColor(Color.LIGHT_GRAY);
        diameter = joyMaxValue * 2;
        g2.fillOval(joyCenterX - diameter / 2, joyCenterY - diameter / 2, diameter, diameter);

        // Draw the joystick position indicator
        g2.setColor(Color.RED);
        diameter = 40;
        g2.fillOval(joyCenterX + dx - diameter / 2, joyCenterY + dy - diameter / 2, diameter, diameter);

    } // paintComponent

    void addChangeListener(ChangeListener listener)
    {
        listenerList.add(ChangeListener.class, listener);
    }

    void removeChangeListener(ChangeListener listener)
    {
        listenerList.remove(ChangeListener.class, listener);
    }

//    protected void fireStateChanged()
//    {
//        ChangeEvent e = new PointChangeEvent(this, joyPosition);
//        Object[] listeners = listenerList.getListenerList();
//        for (int i = listeners.length - 2; i >= 0; i -= 2)
//        {
//            if (listeners[i] == ChangeListener.class)
//            {
//                ((ChangeListener) listeners[i + 1]).stateChanged(e);
//            }
//        }
//    }

} // SimpleJoystick class

class PointChangeEvent extends ChangeEvent
{

    private static final long serialVersionUID = 1L;

    public Point p;

    public PointChangeEvent(Object source, Point p)
    {
        super(source);
        this.p = p;
    }

}