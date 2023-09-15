package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import view.PanelDraw;

/**
 * @author Thinh Le
 * @version Autumn 2022
 */
public class FillShape extends AbstractAction {
    /**
     * Generated ID.
     */
    private static final long serialVersionUID = -5451616671953720959L;
    /**
     * Initialize UW GOLD color.
     */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    /**
     * myDrawing for PanelDraw.
     */

    private final PanelDraw myDrawing;

    /**
     * This is the constructor for Fill shape.
     * @param thePanel for Panel Drawing
     */

    public FillShape(final PanelDraw thePanel) {
        super("Fill Color...");
        myDrawing = thePanel;

    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        Color colCurrent = UW_GOLD;
        //pop the color chooser option
        final Color colorChange = JColorChooser.showDialog(null, "Select a color", colCurrent);
        myDrawing.setColor2(colorChange);
        colCurrent = myDrawing.getColor();
        if (colorChange == null) {
           //if null, set to initial variable
            myDrawing.setColor(UW_GOLD);
        }

    }

}
