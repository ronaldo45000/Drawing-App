/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 * The RectangleTool class creates a rectangle.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class RectangleTool extends AbstractTool {
    /**
     * A rectangular shape.
     */
    protected RectangularShape myShape;

    /**
     * A starting point of myStartPoint.
     */
    protected Point myStartPoint;

    /**
     * Constructor of Rectangle tool.
     */
    public RectangleTool() {
        //calling super method to name Rectangle
        super("Rectangle");
    }

    /**
     * Constructor of a Rectangle tool.
     * 
     * @param theName is the shape.
     */
    public RectangleTool(final String theName) {
        super(theName);
    }

    /**
     * This is to make rectangle shape.
     * 
     * @return myShape.
     */
    @Override
    public Shape draw() {
        return myShape;
    }

    /**
     * Create starting point for the rectangle when the mouse is pressed.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        myStartPoint = theEvent.getPoint();

        myShape = new Rectangle2D.Double();
    }

    /**
     * This is to make rectangle when the mouse is dragged.
     * 
     * @param theEvent  is a mouse event.
     *
     */
    @Override
    public void drag(final MouseEvent theEvent) {
        //position for x
        final int x = Math.min(myStartPoint.x, theEvent.getX());
        //position for y
        final int y = Math.min(myStartPoint.y, theEvent.getY());
        final int width = Math.abs(myStartPoint.x - theEvent.getX());
        final int height = Math.abs(myStartPoint.y - theEvent.getY());
    
        myShape.setFrame(x, y, width, height);
        

    }
}