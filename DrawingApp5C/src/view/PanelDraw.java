package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.LineTool;
import model.ShapeColor;
import model.Tool;

/**
 * The Panel draw class to draw with different tools.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class PanelDraw extends JPanel {
    /**
     * Generated serial version ID.
     */

    private static final long serialVersionUID = 7828242850608765446L;
    /**
     * This is the initial color for Fill color.
     */

    private static final Color UW_GOLD = new Color(232, 211, 162);

    /**
     * the initialize color for drawing.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    /**
     * This is the back ground color.
     */
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    /**
     * This is the initial thickness value.
     */
    private static final int LINE_WIDTH = 3;
    /**
     * Check if the fill box is selected or not.
     */
    private boolean myCheckBox;
   /**
    * myCurrent color for Color class.
    */
    private Color myCurrent;
    /**
     * This is the initial color for Color when draw line.
     */
    
    private Color myColor = UW_PURPLE;
    /**
     * This for second color for shape.
     */
    private Color myColor2;
    /**
     * A line width.
     */
    private int myLineWidth;

    /**
     * if it is already clear or not.
     */
    private boolean myClearStatus;
    /**
     * A button for the option button.
     */
    private JMenuItem myButton;
    /**
     * This is for my Fillutton.
     */
    private JCheckBoxMenuItem myFillButton;
    /**
     * The selected tool object.
     */
    private Tool mySelectedTool = new LineTool();

    /**
     * A collection for the ShapeColor.
     */
    private final List<ShapeColor> myShapeCol;

    /**
     * Constructs and sets all the fields.
     */

    public PanelDraw() {
        super();

        myShapeCol = new ArrayList<ShapeColor>();
        myClearStatus = false;
        myLineWidth = LINE_WIDTH;
        setBackground(BACKGROUND_COLOR);
        myColor = UW_PURPLE;
        myColor2 = UW_GOLD;
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    /**
     * Enables the button.
     * 
     * @param theClear is a JMenuItem.
     */
    public void setButtonEnabled(final JMenuItem theClear) {
        myButton = theClear;
        // myButton.setEnabled(true);
    }

    public boolean setFillBoxEnabled(final JCheckBoxMenuItem theFillBox) {
        myFillButton = theFillBox;

        return true;
    }

    /**
     * Clears the array.
     */
    public void clear() {

        myShapeCol.clear();
        myClearStatus = true;

        repaint();

    }

    /**
     * Changes the line width.
     * 
     * @param theLineWidth of the size.
     */
    public void setLine(final int theLineWidth) {
        myLineWidth = theLineWidth;
    }

    /**
     * Sets the tool.
     * 
     * @param theTool is the tool.
     */
    public void setTool(final Tool theTool) {
        mySelectedTool = theTool;
        if (mySelectedTool.getNameTools().equals("Rectangle") 
                || mySelectedTool.getNameTools().equals("Ellipse")) {

            myFillButton.setEnabled(true);

        } else {
            myCheckBox = false;
            myFillButton.setSelected(false);

            myFillButton.setEnabled(false);
        }
    }

    /**
     * Sets the color.
     * 
     * @param theColor is the color.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
        myCurrent = myColor;
    }
    /**
     * Sets the color2.
     * 
     * @param myColor2 is the color.
     */
    public void setColor2(final Color theColor2) {

        myColor2 = theColor2;

    }
    /**
     * 
     * @return myCurrent
     */
    public Color getColor() {

        return myCurrent;
    }

    /**
     * Paints the the shapes.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphic) {
        super.paintComponent(theGraphic);

        final Graphics2D g2d = (Graphics2D) theGraphic;

        if (myShapeCol.isEmpty()) {
            myButton.setEnabled(false);
            // myFillButton.setEnabled(true);
        }

        for (final ShapeColor scl : myShapeCol) {

            if (scl.getShape() != null) {

                // Set the color

                // Set the thickness
                g2d.setStroke(new BasicStroke(scl.getLine()));

                if (scl.getLine() != 0) {
                    // Set the shape

                    g2d.setColor(scl.getColor());
                    g2d.draw(scl.getShape());

                }
                //check if tool is rectangle or ellipse, and check box is selected
                //also make sure that slider value is not 0
                if ((mySelectedTool.getNameTools().equals("Rectangle")
                        || mySelectedTool.getNameTools().equals("Ellipse")) 
                        && myCheckBox && scl.getLine() != 0) {

                    
                    g2d.setColor(scl.getColor());

                    g2d.fill(scl.getShape());
                    g2d.setColor(scl.getColor2());
                    
                }
                if (scl.getLine() != 0) {
                    g2d.draw(scl.getShape());
                } 

                myButton.setEnabled(true);
            }

        }

        if (!myClearStatus) {

            if ((mySelectedTool.getNameTools().equals("Rectangle") 
                    || mySelectedTool.getNameTools().equals("Ellipse"))
                    && myCheckBox) {
                myShapeCol.add(new ShapeColor(mySelectedTool.draw()
                        , myColor2, myLineWidth, myColor));
            } else {
                //add outline and shape./=
                myShapeCol.add(new ShapeColor(mySelectedTool.draw()
                        , myColor, myLineWidth, myColor2));
            }
        }

        myClearStatus = false;
    }

    /**
     * 
     * @param theSwitch
     */
    public void setBox(final boolean theSwitch) {
        myCheckBox = theSwitch;
    }

    /**
     * Listens for mouse clicks, to draw on our panel.
     */
    private class MyMouseListener extends MouseAdapter {
        /**
         * Handles a press event.
         * 
         * @param theEvent The event.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {

            mySelectedTool.press(theEvent);

        }

        /**
         * This is the Event action for mouse drag.
         * 
         * @param theEvent is the event.
         */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {

            mySelectedTool.drag(theEvent);

            repaint();

        }
    }

}