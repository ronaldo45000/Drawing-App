/*
 * TCSS 305 - Assignment 5b
 */
package model;

import java.awt.Color;
import java.awt.Shape;

/**
 * ShapeColor class is to make shape to change color.
 * @author Thinh Le
 * @version Autumn 2022
 */
public class ShapeColor {
    
    /**
     * This is myShape for Shape class.
     */
    private final Shape myShape;

    /**
     * This is myColor for Color class.
     */
    private final Color myColor;
    /**
     * This is myColor2 for Color class.
     */
    private final Color myColor2;
    /**
     * this is for myThickness value in integer.
     */
    private final int myThicknessValue;

    /**
     * This is the constructor for Shape color.
     * 
     * @param theShape to color the shape.
     * @param theColor to change color.
     * @param theThickNess for value of thickness.
     */
    public ShapeColor(final Shape theShape, final Color theColor, final int theThickNess
            , final Color theColor2) {
        myShape = theShape;
        myColor = theColor;
        myThicknessValue = theThickNess;
        myColor2 = theColor2;
    }
   
  
    /**
     *
     * 
     * @return myShape
     */
    public Shape getShape() {
        return myShape;
    }

    /**
     * Gets the color.
     * 
     * @return a color
     */
    public Color getColor() {
        return myColor;
    }
    /**
     * Gets the color.
     * 
     * @return a color
     */
    public Color getColor2() {
        return myColor2;
    }
    /**
     *
     * 
     * @return myThicknessValue.
     */
    public int getLine() {
        return myThicknessValue;
    }
}