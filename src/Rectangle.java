import java.util.ArrayList;

/**
 * class that defines rectangles.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line leftStanding;
    private Line rightStanding;
    private Line upperLine;
    private Line downLine;
    private double x;
    private double y;

    /**
     * rectangle constructor.
     * @param upperLeft the upper left point.
     * @param width the width.
     * @param height the height.
     */
    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
        this.x = upperLeft.getX();
        this.y = upperLeft.getY();
        this.upperLine = new Line(this.x, this.y, this.x + width, this.y);
        this.leftStanding = new Line(this.x, this.y, this.x, this.y + height);
        this.downLine = new Line(this.x, this.y + height, this.x + width, this.y + height);
        this.rightStanding = new Line(this.x + width, this.y, this.x + width, this.y + height);
    }
    /**
     * finding the intersection point of a brick and a giving line.
     * @param line giving line.
     * @return a list of the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersectionP = new ArrayList<Point>();
        if (this.upperLine.intersectionWith(line) != null) {
            intersectionP.add(this.upperLine.intersectionWith(line));
        }
        if (this.leftStanding.intersectionWith(line) != null) {
            intersectionP.add(this.leftStanding.intersectionWith(line));
        }
        if (this.rightStanding.intersectionWith(line) != null) {
            intersectionP.add(this.rightStanding.intersectionWith(line));
        }
        if (this.downLine.intersectionWith(line) != null) {
            intersectionP.add(this.downLine.intersectionWith(line));
        }
        return intersectionP;
    }

    /**
     * getting the width.
     * @return the width.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * getting the height.
     * @return the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getting the upper left point.
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * method that.
     * @return the upper line of the rectangle.
     */
    public Line getUpperLine() {
        return this.upperLine;
    }

    /**
     * method that.
     * @return the downer line of the rectangle.
     */
    public Line getDownLine() {
        return this.downLine;
    }

    /**
     * method that.
     * @return the right line of the rectangle.
     */
    public Line getRightStanding() {
        return this.rightStanding;
    }

    /**
     * method that.
     * @return the left line of the rectangle.
     */
    public Line getLeftStanding() {
        return this.leftStanding;
    }
}