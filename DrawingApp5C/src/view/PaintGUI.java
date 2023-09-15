/*
 * TCSS 305 - Assignment 5b
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import model.ButtonActions;
import model.EllipseTool;
import model.LineTool;
import model.PencilTool;
import model.RectangleTool;

/**
 * This is the Paint GUI to set up everything.
 * 
 * @author Thinh Le
 * @version Autumn 305
 */
public class PaintGUI {

    /**
     * This is to create window for Paint GUI.
     */
    private JFrame myFrame;

    /**
     * This is the drawing panel.
     */
    private PanelDraw myPanelDrawing;

    /**
     * This is the list of the button actions.
     */
    private List<ButtonActions> myButtonActions;

    /**
     * The Image Icon.
     */
    private final ImageIcon myIcon = new ImageIcon("ricegif.png");

    /**
     * This is my screen size.
     */
    private final Dimension myScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * This is to start the application.
     */
    public void start() {
        setUpFrame();
    }

    /**
     * Sets up everything.
     */
    private void setUpFrame() {
        final int height = myScreenSize.height / 3;
        final int width = myScreenSize.width / 3;
        // Creates a window with a title
        myFrame = new JFrame("TCSS 305 Paint - Autumn 2022");

        // set the layout for frame
        myFrame.setLayout(new BorderLayout());

        // This is the title bar icon to the image
        myFrame.setIconImage(myIcon.getImage());

        // Creates a drawing panel
        myPanelDrawing = new PanelDraw();

        // This is for action tools and images
        setUpAction();

        // Creates a menu bar.
        final JMenuBar menuBar = new CreateMenu(myPanelDrawing, myButtonActions);

        // Adds the menu bar to the window
        myFrame.setJMenuBar(menuBar);

        // Creates a tool bar
        createToolBar();

        // Adding the drawing panel to the center of the frame
        myFrame.add(myPanelDrawing, BorderLayout.CENTER);

        // Exits the application when close
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // able to resize
        myFrame.pack();
        myFrame.setSize(width, height);
        // Centers the application.
        myFrame.setLocationRelativeTo(null);

        // this is to be able to see the frame
        myFrame.setVisible(true);
    }

    /**
     * Sets up the action for each buttons.
     */
    private void setUpAction() {
        
        myButtonActions = new ArrayList<ButtonActions>();
       
        myButtonActions.add(new ButtonActions(new LineTool()
                , new ImageIcon("line_bw.gif"), myPanelDrawing));

        myButtonActions.add(new ButtonActions(new RectangleTool()
                , new ImageIcon("rectangle_bw.gif"), myPanelDrawing));
        myButtonActions.add(new ButtonActions(new EllipseTool()
                , new ImageIcon("ellipse_bw.gif"), myPanelDrawing));
        myButtonActions.add(new ButtonActions(new PencilTool()
                , new ImageIcon("pencil_bw.gif"), myPanelDrawing));

    }

    /**
     * This is for tool bar button.
     */
    private void createToolBar() {
        final ImageIcon ellipseColor = new ImageIcon("ellipse.gif");
        final ImageIcon recColor = new ImageIcon("rectangle.gif");
        final JToolBar bar = new JToolBar();
        final ButtonGroup group = new ButtonGroup();
        for (final ButtonActions buttons : myButtonActions) {
            final JToggleButton toolToggle = new JToggleButton(buttons);
            toolToggle.addActionListener(new ActionListener() {
                /**
                 * This is to change icon when clicking on button.
                 * @param theEvent for ActionEvent
                 */
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    if (theEvent.getActionCommand().equals("Rectangle")) {

                        toolToggle.setIcon(recColor);
                    }
                    if (theEvent.getActionCommand().equals("Ellipse")) {
                        toolToggle.setIcon(ellipseColor);
                    }

                }

            });

            group.add(toolToggle);
            bar.add(toolToggle);
        }
        myFrame.add(bar, BorderLayout.SOUTH);
    }

}