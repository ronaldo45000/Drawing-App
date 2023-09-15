/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * The EllipseTool class to make ellipse shape that extends Rectangle Tool.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class EllipseTool extends RectangleTool {

    /**
     * This is the constructor for EllipseTool.
     */
    public EllipseTool() {
        //calling super to name Ellipse.
        super("Ellipse");
    }

    /**
     * This the shape class to get shape.
     * 
     * @return a Shape.
     */
    @Override
    public Shape draw() {
        return myShape;
    }

    /**
     * This is the Action event for starting point for the ellipse when the mouse is pressed.
     * 
     * @param theEvent is a mouse event
     */
    @Override
    public void press(final MouseEvent theEvent) {
        //start point for ellipse
        myStartPoint = theEvent.getPoint();

        myShape = new Ellipse2D.Double
        (myStartPoint.x, myStartPoint.y, myStartPoint.x, myStartPoint.y);
       
    }
}