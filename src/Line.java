import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
/**
 * Roy 206312654.
 *  This is a class to define a line.
 */
public class Line implements Sprite {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private final Point start;
    private final Point end;
    private final double length;
    private final Point middlePoint;
    private final java.awt.Color color;

    /**
     * constructors.
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
        this.start = start;
        this.end = end;
        this.length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        this.middlePoint = new Point((x1 + x2) / 2, (y1 + y2) / 2);
        this.color = Color.BLACK;
    }

    /**
     * constructors.
     *
     * @param x1 x value start point.
     * @param y1 y value start point.
     * @param x2 x value end point.
     * @param y2 y value end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.length = Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
        this.middlePoint = new Point((x1 + x2) / 2, (y1 + y2) / 2);
        this.color = Color.BLACK;
    }
    public Line(int x1, int y1, int x2, int y2, java.awt.Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.length = Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
        this.middlePoint = new Point((x1 + x2) / 2, (y1 + y2) / 2);
    }
    /**
     * method that.
     *
     * @return length.
     */
    public double length() {
        return this.length;
    }

    /**
     * method that.
     *
     * @return the middle point.
     */
    public Point middle() {
        return this.middlePoint;
    }

    /**
     * method that.
     *
     * @return the start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * method that.
     *
     * @return the end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if the c point is between a and b but without including them.
     * @param a point.
     * @param b point.
     * @param c point.
     * @return true or false.
     */
    static boolean pointIsOnLine(Point a, Point b, Point c) {
        return (c.getX() < Math.max(a.getX(), b.getX())) && (c.getX() > Math.min(a.getX(), b.getX()))
                && (c.getY() < Math.max(a.getY(), b.getY())) && (c.getY() > Math.min(a.getY(), b.getY()));
    }

    /**
     * check if x or y value of point c is between the given points a and b.
     * @param a point.
     * @param b point.
     * @param c point.
     * @return true or false.
     */
    static boolean onLine(Point a, Point b, Point c) {
        return c.getX() < Math.max(a.getX(), b.getX()) && c.getX() > Math.min(a.getX(), b.getX())
                || c.getY() < Math.max(a.getY(), b.getY()) && c.getY() > Math.min(a.getY(), b.getY());
    }

    /**
     * creating the slope by compering the slope of three points.
     * @param a point.
     * @param b point.
     * @param c point.
     * @return the orientation.
     */
    static int slope(Point a, Point b, Point c) {
        double slope = ((b.getY() - a.getY()) * (c.getX() - b.getX())) - ((b.getX() - a.getX())
                * (c.getY() - b.getY()));
        if (slope == 0) {
            return 0;
        } else if (slope > 0) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * method that checks if theres intersection between two lines.
     * @param other the line giving.
     * @return true or false.
     */
    public boolean isIntersecting(Line other) {
        Point line1Start = this.start;
        Point line1End = this.end;
        Point line2Start = other.start();
        Point line2End = other.end();
        int a = slope(line1Start, line1End, line2Start);
        int b = slope(line1Start, line1End, line2End);
        int c = slope(line2Start, line2End, line1Start);
        int d = slope(line2Start, line2End, line1End);
        if (a != b && c != d) {
            return true;
        }
        int equalPoints = 1;
        int linePoints = 1;
        int xAndYLine = 1;

        if (line1End.equals(line1Start) && line2Start.equals(line2Start) && line1Start.equals(line2Start)) {
            return true;
        }
        if (this.equals(other)) {
            return false;
        }
        if (line1End.equals(line2Start) || line1Start.equals(line2End) || line1End.equals(line2End)
                || line1Start.equals(line2Start)) {
            equalPoints = 0;
        }

        if ((a == 0 && onLine(line1Start, line1End, line2Start))
                || (b == 0 && onLine(line1Start, line1End, line2End))
                || (c == 0 && onLine(line2Start, line2End, line1Start))
                || (d == 0 && onLine(line2Start, line2End, line1End))) {
            xAndYLine = 0;
        }
        if ((a == 0 && pointIsOnLine(line1Start, line1End, line2Start))
                || (b == 0 && pointIsOnLine(line1Start, line1End, line2End))
                || (c == 0 && pointIsOnLine(line2Start, line2End, line1Start))
                || (d == 0 && pointIsOnLine(line2Start, line2End, line1End))) {
            linePoints = 0;
        }
        if (equalPoints == 0 && linePoints == 0) {
            return false;
        }
        if ((line1Start.equals(line1End) || line2End.equals(line2Start)) && (linePoints == 0 || xAndYLine == 0)) {
            return true;
        }
        if (equalPoints == 1 && linePoints == 0) {
            return false;
        }
        if (equalPoints == 0 && xAndYLine == 0) {
            return false;
        }
        if (equalPoints == 0 && linePoints == 1) {
            return true;
        }
        if (line1Start.equals(line1End) || line2Start.equals(line2End)) {
            if (line1Start.equals(line1End)) {
                Point p = new Point(line1Start.getX(), line1Start.getY());
                if (p.equals(line2Start) || p.equals(line2End)) {
                    return true;
                }
                return pointIsOnLine(line2Start, line2End, p);
            } else if (line2Start.equals(line2End)) {
                Point p = new Point(line2Start.getX(), line2Start.getY());
                if (p.equals(line1Start) || p.equals(line1End)) {
                    return true;
                }
                return pointIsOnLine(line1Start, line1End, p);
            }
        }
        return false;
    }



    /**
     * method that checks if lines are intersecting.
     *
     * @param other line.
     * @return the point of intersection if there is, otherwise null.
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            Point l1Start = this.start;
            Point l1End = this.end;
            Point l2Start = other.start();
            Point l2End = other.end();
            double a1 = l1End.getY() - l1Start.getY();
            double b1 = l1Start.getX() - l1End.getX();
            double c1 = (a1 * (l1Start.getX())) + (b1 * (l1Start.getY()));
            double a2 = l2End.getY() - l2Start.getY();
            double b2 = l2Start.getX() - l2End.getX();
            double c2 = (a2 * (l2Start.getX())) + (b2 * (l2Start.getY()));
            double detir = (a1 * b2) - (a2 * b1);
            if (detir == 0) {
                if (l1Start.equals(l2End)) {
                    return new Point(l1Start.getX(), l1Start.getY());
                }
                if (l1End.equals(l2Start)) {
                    return new Point(l1End.getX(), l1End.getY());
                }
                if (l1End.equals(l2End)) {
                    return new Point(l1End.getX(), l1End.getY());
                }
                if (l1Start.equals(l2Start)) {
                    return new Point(l1Start.getX(), l1Start.getY());
                }
                if (l1Start.equals(l1End)) {
                    return new Point(l1End.getX(), l1End.getY());
                }
                if (l2Start.equals(l2End)) {
                    return new Point(l2End.getX(), l2End.getY());
                }
            }
            double x = ((b2 * c1) - (b1 * c2)) / detir;
            double y = ((a1 * c2) - (a2 * c1)) / detir;
            return new Point(x, y);
        } else {
            return null;
        }
    }
    /**
     * method that checks if two lines are equal.
     *
     * @param other line
     * @return true or false.
     */
    public boolean equals(Line other) {
        double epsilon = Math.pow(10, -8);
        return ((Math.abs(this.x1 - other.x1) < epsilon && Math.abs(this.y1 - other.y1) < epsilon)
                && (Math.abs(this.x2 - other.x2) < epsilon && Math.abs(this.y2 - other.y2) < epsilon))
                || (Math.abs(this.x1 - other.x2) < epsilon && Math.abs(this.y1 - other.y2) < epsilon)
                && (Math.abs(this.x2 - other.x1) < epsilon && Math.abs(this.y2 - other.y1) < epsilon);
    }

    /**
     * calculating the distance of intersection from the beginning of the line.
     *
     * @param rect is the rectangle.
     * @return the point of the smallest distance.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double a = this.start.getX();
        double b = this.start.getY();
        double c = this.end.getX();
        double d = this.end.getY();
        Line line = new Line(a, b, c, d);
        if (!rect.intersectionPoints(line).isEmpty()) {
            java.util.List<Point> listPoint = new ArrayList<Point>();
            listPoint = rect.intersectionPoints(line);
            if (listPoint.size() == 1) {
                return listPoint.get(0);
            }
            if (line.start.distance(listPoint.get(0)) <= line.start.distance(listPoint.get(1))) {
                return listPoint.get(0);
            } else {
                return listPoint.get(1);
            }
        } else {
            return null;
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.x1, (int) this.y1, (int) this.x2, (int) this.y2);
    }

    @Override
    public void timePassed() {
    }
}
