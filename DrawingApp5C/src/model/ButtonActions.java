/*
 * TCSS 305 - Assignment 5b
 */

package model;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import view.PanelDraw;

/**
 * 
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class ButtonActions extends AbstractAction {

    /**
     * generated serial ID.
     */
    private static final long serialVersionUID = 1875764194902659461L;

    /**
     * This is for drawing panel.
     */
    private final PanelDraw myPanelDraw;

    /**
     * This is for tools.
     */
    private final Tool myTool;

    /**
     * Constructs and initializes the field.
     * 
     * @param theTools are the name of buttons.
     * @param theIcon is the Icon to use for buttons.
     * @param thePanel is the panel from drawing panel.
     */
    public ButtonActions(final AbstractTool theTools, final Icon theIcon
            , final PanelDraw thePanel) {
        
        super(theTools.getNameTools());
       
        myPanelDraw = thePanel;
        myTool = theTools;
        putValue(Action.SMALL_ICON, theIcon);
        // to synchronize buttons for JMenu and JToolbar
        putValue(Action.SELECTED_KEY, true);
    }

    /**
     * This is the event when selecting a different button to draw different shapes.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        //set to a specific tool to draw
        myPanelDraw.setTool(myTool);
    }

}