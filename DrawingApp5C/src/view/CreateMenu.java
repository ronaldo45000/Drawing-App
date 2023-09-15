/*
 * TCSS 305 - Assignment 5b
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ButtonActions;
import model.ColorActions;
import model.FillShape;

/**
 * This is the Menu Bar class that creates menu bar.
 * 
 * @author Thinh Le
 * @version Autumn 2022
 */
public class CreateMenu extends JMenuBar {
    /**
     * Generated Serial ID.
     */
    private static final long serialVersionUID = 8816894027151051267L;

    /**
     * The major tick spacing for slider.
     */
    private static final int MAJOR_TICK_SPACING = 5;

    /**
     * The minor tick spacing for slider.
     */
    private static final int MINOR_TICK_SPACING = 1;
    /**
     * myClear is for JMenu Item.
     */
    protected JMenuItem myClear;
    /**
     * This is fillBox for JCheckBoxMenuItem.
     */
    private final JCheckBoxMenuItem myFillBox;
    /**
     * This is for the drawing panel.
     */
    /**
     * imageIcon for Rectangle color.
     */
    private ImageIcon myRecCol;
    /**
     * imageIcon for Ellipse color.
     */
    private ImageIcon myEllipseColor;
    /**
     * this for myPanelDrawing from PanelDraw class.
     */
    private final PanelDraw myPanelDrawing;
    /**
     * The Option menu for JMenu.
     */
    private JMenu myOptionMenu;

    /**
     * The Tool menu for JMenu.
     */
    private JMenu myToolMenu;

    /**
     * Create list for button actions.
     */
    private final List<ButtonActions> myButtonActions;

    /**
     * This is for The Image Icon.
     */
    private final ImageIcon myIcon = new ImageIcon("ricegif.png");

    /**
     * This is the constructor for CreateMenu.
     * 
     * @param theFrame to make frame for window.
     * @param thePanelDraw is the drawing panel.
     * @param theButtonAction is the button action.
     */
    public CreateMenu(final PanelDraw thePanelDraw, 
            final List<ButtonActions> theButtonAction) {
        super();

        myFillBox = new JCheckBoxMenuItem("Fill");
        myClear = new JMenuItem("Clear");
        myPanelDrawing = thePanelDraw;
        myButtonActions = theButtonAction;
        menuButton();
    }

    /**
     * Creates menu Button and other filter.
     */
    private void menuButton() {
        // Builds the menu option and their mnemonic keys
        // myFileMenu = new JMenu("File");
        fillBoxItem();
        clearMenuItem();

        myOptionMenu = new JMenu("Options");

        optionMenuItem();

        myToolMenu = new JMenu("Tools");

        toolMenuItem();
        final JMenu helpMenu = new JMenu("Help");

        helpMenu.add(aboutMenuItem());

        // Adds the menu to the menu bar.

        add(myOptionMenu);
        add(myToolMenu);
        add(helpMenu);

    }

    /**
     * This is for clear drawing.
     */
    private void clearMenuItem() {
        // The items in the menu.

        myPanelDrawing.setButtonEnabled(myClear);

        myClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {

                myPanelDrawing.clear();
                repaint();
            }
        });

    }
    /**
     * This is to do action for fill Box.
     */
    private void fillBoxItem() {

        myPanelDrawing.setFillBoxEnabled(myFillBox);
        myFillBox.addActionListener(new ActionListener() {
           /**
            * This is the action listener event for fill box
            * @param theEvent for ActionEvent
            */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {

                myPanelDrawing.setBox(myFillBox.isSelected());

                // myPanelDrawing.
            }

        });
    }

    /**
     * Creates the option menu item.
     */

    private void optionMenuItem() {

        final JMenu thickMenuItem = new JMenu("Thickness");

        thickMenuItem.add(createSlider());

        myOptionMenu.add(thickMenuItem);
        myOptionMenu.addSeparator();
        myOptionMenu.add(colorChooserItem());

        myOptionMenu.add(colorShape());

        myFillBox.setEnabled(false);

        myOptionMenu.addSeparator();
        myOptionMenu.add(myFillBox);

        myOptionMenu.addSeparator();
        myOptionMenu.add(myClear);
        // myClear.setEnabled(true);

    }

    /**
     * Creates a slider for the thickness.
     * 
     * @return a JSlider of a slider
     */
    private JSlider createSlider() {
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 15, 3);
        slider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();

                if (value >= 1) {
                    myPanelDrawing.setLine(value);
                }
                if (value == 0) {
                    myPanelDrawing.setLine(value);
                }
            }
        });
        return slider;
    }

    /**
     * Creates the Color button with the color chooser action.
     * 
     * @return a JMenuItem.
     */

    private JMenuItem colorChooserItem() {

        final ColorActions colorAction = new ColorActions(myPanelDrawing);
        final JMenuItem colorChooser = new JMenuItem(colorAction);

        return colorChooser;
    }
    /**
     * Creates the ColorShape button with the color chooser action.
     * 
     * @return a JMenuItem.
     */

    private JMenuItem colorShape() {

        final JMenuItem colorChooser = new JMenuItem("Fill Color...");
        colorChooser.addActionListener(new FillShape(myPanelDrawing));
        return colorChooser;
    }

    /**
     * Create item for Tool Menu.
     */
    private void toolMenuItem() {
        //icon for rec color
        myRecCol = new ImageIcon("rectangle.gif");
        //icon for Ellipse Color
        myEllipseColor = new ImageIcon("ellipse.gif");
        final ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < myButtonActions.size(); i++) {

            final JRadioButtonMenuItem toolRadioButton = 
                    new JRadioButtonMenuItem(myButtonActions.get(i));

            toolRadioButton.addActionListener(new ActionListener() {
               /** this is the action event to change icon
                * @param theEvent for ActionEvent
                */
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    if (theEvent.getActionCommand().equals("Rectangle")) {

                        toolRadioButton.setIcon(myRecCol);
                    

                    } else if (theEvent.getActionCommand().equals("Ellipse")) {

                        toolRadioButton.setIcon(myEllipseColor);

                    }

                }

            });

            group.add(toolRadioButton);
            myToolMenu.add(toolRadioButton);

        }

    }

    /**
     * Creates JMenuItem for about option in the menu.
     * 
     * @return a JMenuItem
     */
    private JMenuItem aboutMenuItem() {

        final JMenuItem forAbout = new JMenuItem("About...");

        forAbout.addActionListener(new ActionListener() {
            // this is for action event when clicking on about that will pop up
            // the JOptionPane to show message
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null,

                        "ThinhLe\n" + "Autumn 2022\n", "TCSS 305 Paint"
                        , JOptionPane.INFORMATION_MESSAGE, myIcon);
            }

        });

        return forAbout;
    }
}