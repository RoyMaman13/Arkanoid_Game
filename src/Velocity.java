/**
 * Roy 206312654.
 *  This is a class to define velocity.
 */
public class Velocity {
    private final double  dx;
    private final double dy;

    /**
     * constructors.
     * @param dx x value.
     * @param dy y value.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
//        this.v = new Velocity(dx, dy);
    }

    /**
     * method that defining velocity from angle and speed.
     * @param angle value.
     * @param speed value.
     * @return velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double velocityY = (speed * (-1) * Math.cos(Math.toRadians(angle)));
        double velocityX = (speed * Math.sin(Math.toRadians(angle)));
        return new Velocity(velocityX, velocityY);
    }

    /**
     * method that changes the point according to the dx dy values.
     * @param p point.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }
    /**
     * method that get x value.
     * @return x value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * method that get y value.
     * @return y value.
     */
    public double getDy() {
        return this.dy;
    }
}

