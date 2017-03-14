package sources.geom2D;

/**
 * @author admin_master
 */
public class Point2D {
    private Double x = null;
    private Double y = null;
    /**
     */
    public Point2D() { }
    /**
     * @param x (Double). The x coordinate of a point.
     * @param y (Double). The y coordinate of a point.
     */
    public Point2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @return boolean
     */
    public boolean defined() {
        return (this.x != null) && (this.y != null);
    }
    /**
     * @param x (Double). The x coordinate of a point.
     * @return value (Double)
     */
    public Double setX(Double x) {
        return (this.x = x);
    }
    /**
     * @param y (Double). The y coordinate of a point.
     * @return value (Double)
     */
    public Double setY(Double y) {
        return (this.y = y);
    }
    /**
     * @return x (Double)
     */
    public Double getX() {
        return this.x;
    }
    /**
     * @return y (Double)
     */
    public Double getY() {
        return this.y;
    }
    /**
     * @param point Another Point2D. Calculating the distance with this point.
     * @return Double
     */
    public Double distance(Point2D point) {
        return Math.pow(Math.pow((point.getX() - this.x), 2) + Math.pow((point.getY() - this.y), 2), 1/2);
    }
    /**
     * @return String
     */
    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
    /**
     * @param o An object instance of Point2D. Testing if it's the same point.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Point2D && ((this.getX() == ((Point2D) o).getX()) && (this.getY() == ((Point2D) o).getY()));
    }
}
