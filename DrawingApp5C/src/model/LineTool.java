/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * This is the LineTool class to draw for line that extends Abstract tool.
 * @author Thinh Le
 * @version Autumn 2022
 */
public class LineTool extends AbstractTool {
    /**
     * A starting point of the line.
     */
    private Point myStartPoint;

    /**
     * The Line.
     */
    private Line2D myLine;

    /**
     * Constructor for line tool .
     */
    public LineTool() {
        //calling super method to name Line
        super("Line");
    }

    /**
     * Draws the shape of line.
     * 
     * @return myLine
     */
    @Override
    public Shape draw() {
        return myLine;
    }

    /**
     * the MouseEvent for starting point of line when it is pressed.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        //this is the start point for line
        myStartPoint = theEvent.getPoint();
        myLine = new Line2D.Double
        (myStartPoint.x, myStartPoint.y, myStartPoint.x, myStartPoint.y);

    }

    /**
     * This is the Mouse Event for endPoint when it is pressed.
     * 
     * @param theEvent  is a mouse event.
     
     */
    @Override
    public void drag(final MouseEvent theEvent) {
        //end point for Line
        final Point endPoint = theEvent.getPoint();
        myLine.setLine(myStartPoint.x, myStartPoint.y, endPoint.x, endPoint.y);

    }

}