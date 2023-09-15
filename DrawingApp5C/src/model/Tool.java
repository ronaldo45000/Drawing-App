/*
 * TCSS 305 - Assignment 5b
 */
package model;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * This is an interface to help for tools to draw different ways.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public interface Tool {
    /**
     * Method to draw.
     *
     * @return shape for Shape Class.
     */
    Shape draw();

    /**
     * Returns name for Tools.
     * 
     * @return String name.
     */
    String getNameTools();

    /**
     * MouseEvent for press.
     * 
     * @param theEvent The event.
     */
    void press(MouseEvent theEvent);

    /**
     * MouseEvent for drag.
     * 
     * @param theEvent is the mouse event.
     * 
     */
    void drag(MouseEvent theEvent);

}