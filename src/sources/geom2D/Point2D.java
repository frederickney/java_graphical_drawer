package sources.geom2D;

/**
 * @class Point2D
 * @author admin_master
 */
public class Point2D {
    private Double x = null;
    private Double y = null;
    /**
     * @constructor Point2D
     */
    public Point2D() { }
    /**
     * @constructor Point2D
     * @param x (Double). The x coordinate of a point.
     * @param y (Double). The y coordinate of a point.
     */
    public Point2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @function defined
     * @return boolean
     */
    public boolean defined() {
        return (this.x != null) && (this.y != null);
    }
    /**
     * @function setX
     * @param x (Double). The x coordinate of a point.
     * @return value (Double)
     */
    public Double setX(Double x) {
        return (this.x = x);
    }
    /**
     * @function setY
     * @param y (Double). The y coordinate of a point.
     * @return value (Double)
     */
    public Double setY(Double y) {
        return (this.y = y);
    }
    /**
     * @function getX
     * @return x (Double)
     */
    public Double getX() {
        return this.x;
    }
    /**
     * @function getY
     * @return y (Double)
     */
    public Double getY() {
        return this.y;
    }
    /**
     * @function distance
     * @param point Another Point2D. Calculating the distance with this point.
     * @return Double
     */
    public Double distance(Point2D point) {
        return Math.pow(Math.pow((point.getX() - this.x), 2) + Math.pow((point.getY() - this.y), 2), 1/2);
    }
    /**
     * @function toString
     * @return String
     */
    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
    /**
     * @function equals
     * @param o An object instance of Point2D. Testing if it's the same point.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point2D)
            return ( (this.getX() == ((Point2D) o).getX()) && (this.getY() == ((Point2D) o).getY()));
        else
            return false;
    }
}
