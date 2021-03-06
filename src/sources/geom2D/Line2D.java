package sources.geom2D;

/**
 * @author admin_master
 */
public class Line2D {
    private Point2D p = null;
    private Point2D p2 = null;
    private Double  m = null;
    /**
     * @param x1 (Double). The x coordinate of one point of a line.
     * @param y1 (Double). The y coordinate of one point of a line.
     * @param x2 (Double). The x coordinate of a second point of a line.
     * @param y2 (Double). The y coordinate of a second point of a line.
     */
    public Line2D(double x1, double y1, double x2, double y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }
    /**
     * @return point The second point of the line.
     * @see Point2D
     */
    public Point2D getPointB() {
        return this.p2;
    }
    /**
     * @param p (Point2D). One point of the line.
     * @see Point2D
     * @param m (Double). The slope of the line.
     */
    public Line2D(Point2D p, Double m) {
        this.p = p;
        this.m = m;
    }
    /**
     * @param m (Double). The slope of the line.
     * @param ord (Double). The origin intercept of the line.
     */
    public Line2D(Double m, Double ord) {
        this.m = m;
        this.p.setX(ord);
        this.p.setY(ord);
    }
    /**
     * @param p1 (Point2D). The first point of the line.
     * @param p2 (Point2D). The second point of the line.
     * @see Point2D
     */
    public Line2D(Point2D p1, Point2D p2){
        Double deltaY = p2.getY() - p1.getY();
        Double deltaX = p2.getX() - p1.getX();
        this.p = new Point2D(p1.getX(), p1.getY());
        this.p2 = new Point2D(p2.getX(), p2.getY());
        this.m = (double)deltaY / (double)deltaX;
    }
    /**
     * @param p (Point2D). A point of the line.
     * @see Point2D
     */
    public void setPoint(Point2D p){
        this.p = p;
    }
    /**
     * @param m (Double). The slope of the line.
     */
    public void setSlope(Double m){
        this.m = m;
    }
    /**
     * @param p (Point2D). One point of the line.
     * @see Point2D
     * @param m (Double). The slope of the line.
     */
    public void setPointSlope(Point2D p, double m){
        this.p = p;
        this.m = m;
    }
    /**
     * @return point (Point2D).
     * @see Point2D
     */
    public Point2D getPoint(){
        return this.p;
    }
    /**
     * @return slope (Double)
     */
    public Double getSlope(){
        return this.m;
    }
    /**
     * @return Double
     */
    public Double getIntersectionX(){
        return ((this.m * this.p.getY() - this.p.getX()) * -1.0) ;
    }
    /**
     * @return Double
     */
    public Double getIntersectionY(){
        return ((this.m * this.p.getX() - this.p.getY()) * -1.0);
    }
    /**
     * @param p (Point2D). A point. Testing if it's the same point.
     * @see Point2D
     * @return  boolean
     */
    public boolean contains(Point2D p){
        return this.p == p;
    }
    /**
     * @param Line (Line2D). An other line.
     * @return  boolean
     */
    public boolean isParallel(Line2D Line){
        return (double) this.m == Line.getSlope();
    }
    /**
     * @param o An object instance of Line2D. Testing if it's the same line.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Line2D && ((((Line2D) o).getSlope() == this.m) && (((Line2D) o).getPoint() == this.p));
    }
    /**
     * @return string
     */
    @Override
    public String toString(){
        return "le point a pour coordonné" + this.p.toString() + " et une pente de " + this.m +".";
    }
    /**
     * @return null
     */
    public StringBuilder toString2(){
        return null;
    }
}
