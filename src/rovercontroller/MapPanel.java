//******************************************************************************
// VT RoboOps 2015 - Team Vertex
// 
// NAME:    MapPanel.java
//
// PURPOSE: A simple class that extends JPanel so that a Google Maps image or a 
//          placeholder loading animation can be drawn on the GUI.
//
// AUTHOR:  S. Krauss
//******************************************************************************
package rovercontroller;

// Imported for construction of the panel, label, and image
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

// Imported for Google Maps image URL
import java.net.URL;

//******************************************************************************
//                              CLASS DEFINITION
//******************************************************************************
public class MapPanel extends JPanel
{

    //--------------------------------------------------------------------------
    // Class Variables
    //--------------------------------------------------------------------------
    
    // JLabel that the map image is displayed on
    private JLabel imageLabel = new JLabel();
    
    // Image icon displayed on the map panel label
    private volatile ImageIcon mapImage;
    
    //--------------------------------------------------------------------------
    // MapPanel Constructor
    //--------------------------------------------------------------------------
    public MapPanel()
    {

        // Set the layout of the map panel to BorderLayout
        this.setLayout(new BorderLayout());

        // Load the "GPS Loading" image
        mapImage = new ImageIcon(getClass().getResource("/GpsLoading.gif"));   

        // Set the image to the label and align it to the center
        imageLabel.setIcon(mapImage);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add the label to the panel
        this.add(imageLabel, java.awt.BorderLayout.CENTER);

        // Set the panel background color
        this.setBackground(Color.decode("#1a1a1a"));
        
        // Make the panel visible
        this.setVisible(true);

    } // MapPanel constructor

    //--------------------------------------------------------------------------
    // Name:        setUrl
    // Description: Sets the google maps image URL for the image display. Set
    //              this to "None" to display the loading image.
    // Arguments:   - String mapImageUrlString, string containing the Google
    //                maps image URL or "None"
    // Returns:     N/A
    //--------------------------------------------------------------------------
    public void setUrl(String mapImageUrlString)
    {
        
        // If the given URL string is "None"
        if (mapImageUrlString.equalsIgnoreCase("None"))
        {

            // Load the "loading" image
            mapImage = new ImageIcon(getClass().getResource("/GpsLoading.gif")); 

        } // if
        else
        {
            
            try
            {

                // Set the image to the new image URL
                URL mapImageUrl = new URL(mapImageUrlString);
                mapImage = new ImageIcon(mapImageUrl);
                imageLabel.setIcon(mapImage);

            } // try
            catch (Exception ex)
            {

                System.out.println("ERROR: Could not load map image!");

            } // catch  
            
        } // else

        // Repaint and revalidate the map panel
        this.repaint();
        this.revalidate();

    } // setUrl

} // MapPanel class
