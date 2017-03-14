/**
 *@Project  :   TP5
 *@File     :   Panel.java
 *@Revision :   1.0.1
 *@Created  :   10/09/2015 19:32
 *@Author   :   Frederick NEY's WEBMASTER
 */
package sources.application;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import sources.geom2D.Point2D;
import sources.geom2D.Line2D;
import java.awt.Color;

/**
 * @class Panel
 * @author admin_master
 */
public class Panel extends JPanel {
    
    private final int SQUARE_SIZE = 10; 
    private final int SQUARE_OFFSET = SQUARE_SIZE / 2;
    
    private ArrayList<Point2D> points;
    private ArrayList<Line2D> lines;
    private double maxX = Double.MIN_VALUE;
    private double maxY = Double.MIN_VALUE;
    private double minX = Double.MAX_VALUE;
    private double minY = Double.MAX_VALUE;
    private double scopeX = 0;
    private double scopeY = 0;
    /**
     * @description Panel constructor 
     * @constructor Panel
     * @param pointsList Point2D array list.
     * @see Point2D
     * @param linesList Line2D array list.
     * @see Line2D
     */
    public Panel(ArrayList<Point2D> pointsList, ArrayList<Line2D> linesList) {
        this.points = pointsList;
        this.lines = linesList;
        
        pointsList.stream().map((point) -> {
            if(this.maxX < point.getX())
                this.maxX = point.getX();
            return point;            
        }).map((point) -> {
            if(this.maxY < point.getY())
                this.maxY = point.getY();
            return point;            
        }).map((point) -> {
            if(this.minX > point.getX())
                this.minX = point.getX();
            return point;
        }).filter((point) -> (this.minY > point.getY())).forEach((point) -> {
            this.minY = point.getY();
        });
        
        linesList.stream().map((Line2D line) -> {
            if(this.maxX < line.getPoint().getX())
                this.maxX = line.getPoint().getX();
            return line;            
        }).map((line) -> {
            if(this.maxY < line.getPoint().getY())
                this.maxY = line.getPoint().getY();
            return line;
        }).map((line) -> {
            if(this.maxX < line.getPointB().getX())
                this.maxX = line.getPointB().getX();
            return line;            
        }).map((line) -> {
            if(this.maxY < line.getPointB().getY())
                this.maxY = line.getPointB().getY();
            return line;            
        }).map((line) -> {
            if(this.minX > line.getPoint().getX())
                this.minX = line.getPoint().getX();
            return line;            
        }).map((line) -> {
            if(this.minY > line.getPoint().getY())
                this.minY = line.getPoint().getY();
            return line;            
        }).map((line) -> {
            if(this.minX > line.getPointB().getX())
                this.minX = line.getPointB().getX();
            return line;
        }).filter((line) -> (this.minY > line.getPointB().getY())).forEach((line) -> {
            this.minY = line.getPointB().getY();
        });
        
        this.scopeX = this.maxX - this.minX;
        this.scopeY = this.maxY - this.minY;
    }
    /**
     * @description painting points
     * @function drawPoints
     * @param g Graphics element 
     * @see java.awt.Graphics
     * @param scaleX (Double). The scale between max and min value of x.
     * @param scaleY (Double). The scale between max and min value of y.
     */
    private void drawPoints(Graphics g, double scaleX, double scaleY) {
        this.points.stream().forEach((point) -> {
            Double npx = (point.getX()- this.minX) * scaleX;
            Double npy = (point.getY() - this.minY) * scaleY;
            
            g.drawRect(
                    npx.intValue() - SQUARE_OFFSET,
                    npy.intValue() - SQUARE_OFFSET, 
                    SQUARE_SIZE, 
                    SQUARE_SIZE);
        });
            this.lines.stream().forEach((line) -> {
            Double newX = (line.getPoint().getX() - this.minX) * scaleX;
            Double newY = (line.getPoint().getY() - this.minY) * scaleY;
            Double newX2 = (line.getPointB().getX() - this.minX) * scaleX;
            Double newY2 = (line.getPointB().getY() - this.minY) * scaleY;
 
            g.setColor(Color.black);
            g.drawRect(
                    newX.intValue() - SQUARE_OFFSET,
                    newY.intValue() - SQUARE_OFFSET, 
                    SQUARE_SIZE, 
                    SQUARE_SIZE);
            
            g.drawRect(
                    newX2.intValue() - SQUARE_OFFSET,
                    newY2.intValue() - SQUARE_OFFSET, 
                    SQUARE_SIZE, 
                    SQUARE_SIZE); 
        });
    }
    /**
     * @description painting lines
     * @function drawLines
     * @param g Graphics element 
     * @see java.awt.Graphics
     * @param scaleX (Double). The scale between max and min value of x.
     * @param scaleY (Double). The scale between max and min value of y.
     */
    private void drawLines(Graphics g, double scaleX, double scaleY) {
        this.lines.stream().forEach((line) -> {
            double deltaX = line.getPointB().getX() - line.getPoint().getX();
            double deltaY = line.getPointB().getY() - line.getPoint().getY(); 
            
            Double newX = (line.getPoint().getX() - deltaX * 10 - this.minX) * scaleX;
            Double newY = (line.getPoint().getY() - deltaY * 10 - this.minY) * scaleY;
            Double newX2 = (line.getPointB().getX() + deltaX * 10 - this.minX) * scaleX;
            Double newY2 = (line.getPointB().getY() + deltaY * 10 - this.minY) * scaleY;

            g.setColor(Color.red);
     
            g.drawLine(newX.intValue(),
                    newY.intValue(),
                    newX2.intValue(),
                    newY2.intValue() 
            );         
        });
    }
    /**
     * @description painting Panel component 
     * @function paintComponent (override)
     * @param g Graphics element. 
     * @see java.awt.Graphics
     */
    @Override
    public void paintComponent(Graphics g) {       
        double scaleX = (double)this.getSize().width / this.scopeX;
        double scaleY = (double)this.getSize().height / this.scopeY;
        
        this.drawPoints(g, scaleX, scaleY);
        this.drawLines(g, scaleX, scaleY);
    }
}

