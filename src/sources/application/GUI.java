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
import java.awt.Toolkit;

/**
 * @author admin_master
 */
public final class GUI extends JFrame {
    String Icon = "/logo/icons.png";
    Panel Panel;
    private final ArrayList<Point2D> pointsList;
    private final ArrayList<Line2D> linesList;
    /**
     * @param fileName The file name/path with some numerics for building lines and points.
     * @throws IOException : file not found
     */
    public GUI (String fileName) throws IOException {
        super("Line Creator");
        this.pointsList = new ArrayList<Point2D>();
        this.linesList = new ArrayList<Line2D>();
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
     */
    private void initGUI() {
        this.setIconImage( new ImageIcon((getClass().getResource(Icon))).getImage());
        this.setResizable(true);
        this.setSize(600 , 400);
        winExit exhop = new winExit(winExit.CLOSE);
        this.addWindowListener(exhop);
    }
    /**
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
 * @author admin_master
 */
class winExit extends WindowAdapter {
    public static final int CLOSE = 0;
    int id;
    /**
     * @param id
     */
    winExit(int id) {
        this.id = id;
    }
    /**
     * @param we The window closing event.
     * @see java.awt.event.WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(CLOSE);
    }
}
