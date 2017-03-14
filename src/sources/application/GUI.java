/**
 *@Project  :   sources.application
 *@File     :   GUI.java
 *@Revision :   1.0.1
 *@Created  :   20/06/2015 12:32
 *@Author   :   Frederick NEY's WEBMASTER
 */
package sources.application;

import sources.geom2D.Point2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import sources.geom2D.Line2D;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import sources.reader.File;

/**
 * @class GUI
 * @author admin_master
 */
public final class GUI extends JFrame {
    ImageIcon Icon = new ImageIcon("netbeans.png");
    Image FrameIcon = Icon.getImage();
    Panel Panel;
    private final ArrayList<Point2D> pointsList;
    private final ArrayList<Line2D> linesList;
    /**
     * @description GUI constructor
     * @constructor GUI
     * @param fileName The file name/path with some numerics for building lines and points.
     * @throws IOException 
     */
    public GUI (String fileName) throws IOException {
        super("Line Creator");
        this.pointsList = new ArrayList<>();
        this.linesList = new ArrayList<>();
        new File().readFile(fileName, pointsList, linesList);
        initGUI();
        Panel = new Panel(pointsList, linesList);
        Panel.setBackground(Color.lightGray);
        Panel.setSize(this.getWidth(), this.getHeight());
        this.addComponent(Panel);
        this.setVisible(true);
        enableEvents(WindowEvent.WINDOW_CLOSING);
    }
    /**
     * @description initializing the GUI
     * @function initGUI
     */
    private void initGUI() {
        this.setIconImage(FrameIcon);
        this.setResizable(true);
        this.setSize(600 , 400);
        winExit exhop = new winExit(winExit.CLOSE);
        this.addWindowListener(exhop);
    }
    /**
     * @description adding component to GUI
     * @function addComponent
     * @param o It's the object instance of Panel which is added to the GUI.
     * @see Panel
     */
    public void addComponent(Object o) {
        if (o instanceof Panel){
            this.setContentPane((Panel)o);
        }
    }
}
/**
 * @class winEx
 * @author admin_master
 */
class winExit extends WindowAdapter {
    public static final int CLOSE = 0;
    int id;
    /**
     * @description winExit constructor
     * @constructor winExit
     * @param id 
     */
    winExit(int id) {
        this.id = id;
    }
    /**
     * @description windows closing event function (override)
     * @function windowClosing
     * @param we The window closing event.
     * @see java.awt.event.WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(CLOSE);
    }
}