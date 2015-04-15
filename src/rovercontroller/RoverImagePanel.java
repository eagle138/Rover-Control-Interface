//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    RoverImagePanel.java
//
// PURPOSE: A simple class that extends JPanel so that an overhead
//          representation can be drawn with camera and wheel direction.
//
// AUTHOR:  Author: S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for construction of the panel, label, and image
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class RoverImagePanel extends JPanel
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // JLabel that the map image is displayed on
    private final JLabel imageLabel = new JLabel();
    
    // Image icon displayed on the map panel label
    private volatile ImageIcon roverImage;
    
    //--------------------------------------------------------------------------
    // MapPanel Constructor
    //--------------------------------------------------------------------------
    public RoverImagePanel()
    {

        // Set the layout of the rover image panel to BorderLayout
        this.setLayout(new BorderLayout());

        // Load the rover image
        //roverImage = new ImageIcon(getClass().getResource("/roverImage.jpg"));   
        roverImage = new ImageIcon(((new ImageIcon(getClass().getResource("/roverImage.jpg"))).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));

        // Set the image to the label and align it to the center
        imageLabel.setIcon(roverImage);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add the label to the panel
        this.add(imageLabel, java.awt.BorderLayout.CENTER);

        // Set the panel background color
        // this.setBackground(Color.decode("#1a1a1a"));
        
        // Make the panel visible
        this.setVisible(true);

    } // RoverImagePanel constructor

} // RoverImagePanel class