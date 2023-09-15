/*
 * TCSS 305 - Assignment 5b
 */
package model;

/**
 * This is for the parent class for tool where some methods will be used to
 * other classes.
 * 
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public abstract class AbstractTool implements Tool {

    /**
     * This is for the tool's name buttons.
     */

    private final String myToolForName;

    /**
     * Constructor for name.
     * 
     * @param theName for name for each tool.
     */
    public AbstractTool(final String theName) {
        myToolForName = theName;
    }

    /**
     * Get the name of the tool.
     * 
     * @return String.
     */
    @Override
    public String getNameTools() {
        return myToolForName;
    }
}