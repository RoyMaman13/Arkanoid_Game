/**
 * Roy 206312654.
 *  This is a class to define points.
 */
public class Point {
    /**
     * point fields.
     */
    private final double x;
    private final double y;
    /**
     *  constructors.
     * @param x x value
     * @param y y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * method that that gets two pints and returns the distance.
     * @param other point.
     * @return distance.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }

    /**
     * method that gets two points and checks if they are equal.
     * @param other point
     * @return false or true
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return ((other.getX() == this.x) && (other.getY() == this.y));
    }
    /**
     * getting the x value.
     * @return x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * getting the y value.
     * @return y value
     */
    public double getY() {
        /* getting y */
        return this.y;
    }

}

