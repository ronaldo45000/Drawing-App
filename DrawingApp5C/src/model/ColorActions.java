/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import view.PanelDraw;

/**
 * The color actions controls the color button.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class ColorActions extends AbstractAction {
    /**
     * Generated Serial ID.
     */
    private static final long serialVersionUID = 3933554015765179879L;
    /**
     * This is the UW purple color.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    /**
     * This is the PanelDraw for drawing.
     */
    private final PanelDraw myDrawingPanel;
   
    /**
     * Constructs a color action object.
     * 
     * 
     * @param thePanel is the drawing panel.
     */

    public ColorActions(final PanelDraw thePanel) {
        super("Color...");
        myDrawingPanel = thePanel;

    }

    /**
     * The action event to change color.
     * 
     * @param theEvent is an event that occurred.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // show color menu to choose color
        Color colCurrent = UW_PURPLE;
      

        colCurrent = UW_PURPLE;
        final Color colorChange = JColorChooser.showDialog
                (myDrawingPanel, "Select a color", colCurrent);

  

        myDrawingPanel.setColor(colorChange);
        colCurrent = myDrawingPanel.getColor();
        if (colorChange == null) {
            //if it is null, set it to initial value
            colCurrent = myDrawingPanel.getColor();
            myDrawingPanel.setColor(UW_PURPLE);
        }

    }
}
