/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

/**
 * A pencil tool objects that creates a freehand tool.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class PencilTool extends AbstractTool {
    /**
     * myPath will be used to draw for Pencil.
     */
    private Path2D myPath;

    /**
     * Constructs a pencil tool object.
     */
    public PencilTool() {
        super("Pencil");
    }

    /**
     * Draws the shape.
     */
    @Override
    public Shape draw() {
        return myPath;
    }

    /**
     * This is the Mouse Event for drag.
     * 
     * @param theEvent is a mouse event.
     * 
     */
    @Override
    public void drag(final MouseEvent theEvent) {
        myPath.lineTo(theEvent.getX(), theEvent.getY());
    }

    /**
     * This is the Mouse Event for press.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        //initialize the Path2D
        myPath = new GeneralPath();
        //position for x and y for pencil's drawing.
        myPath.moveTo(theEvent.getX(), theEvent.getY());

    }
}