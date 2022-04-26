import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class that defines ball.
 * fields.
 */
public class Ball implements Sprite, HitNotifier {
    private final Point center;
    private final double r;
    private final java.awt.Color color;
    private double x;
    private double y;
    private double dX;
    private double dY;
    private Point point;
    private Velocity velocity;
    private GameEnvironment game;
    private java.util.List<HitListener> hitListeners;

    /**
     * constructors.
     *
     * @param center point.
     * @param r      radius.
     * @param color  color.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * constructors.
     *
     * @param x     value.
     * @param y     value.
     * @param r     radius value.
     * @param color color.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.x = x;
        this.y = y;
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.point = new Point(x, y);
        this.velocity = new Velocity(dX, dY);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
    }

    /**
     * setting the giving ball to the game.
     * @param c the game giving.
     */
    public void setGame(GameEnvironment c) {
        this.game = c;
    }

    /**
     * getting the x value.
     *
     * @return x value
     */
    public int getX() {
        return (int) point.getX();
    }

    /**
     * getting the y value.
     *
     * @return y value
     */
    public int getY() {
        return (int) point.getY();
    }

    /**
     * getting the radius value.
     *
     * @return radius value
     */
    public int getSize() {
        return (int) this.r;
    }

    /**
     * getting the color.
     *
     * @return color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * method that drawing the ball.
     *
     * @param surface ball values.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        if (this.color == Color.white) {
            surface.setColor(Color.BLACK);
            surface.drawCircle(getX(), getY(), getSize());
            surface.setColor(this.color);
            surface.fillCircle(getX(), getY(), getSize());
        } else {
            surface.setColor(this.color);
            surface.drawCircle(getX(), getY(), getSize());
            surface.setColor(this.color);
            surface.fillCircle(getX(), getY(), getSize());
        }
    }
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * getting velocity.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * setting the velocity.
     *
     * @param dx value.
     * @param dy value.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * getting velocity.
     *
     * @return velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * method that is moving the ball according to his location and speed.
     */
    public void moveOneStep() {
        Line traj = new Line(this.point, new Point(this.point.getX() + this.getVelocity().getDx(),
                this.point.getY() + this.getVelocity().getDy()));
        CollisionInfo colid = game.getClosestCollision(traj);
        if (colid != null) {
            Point intersection = colid.collisionPoint();
            this.point = new Point(intersection.getX() - this.velocity.getDx(),
                    intersection.getY() - this.velocity.getDy());
            this.setVelocity(colid.collisionObject().hit(this, colid.collisionPoint(), this.getVelocity()));
            if (intersection.getY() >= 600) {
                this.notifyHit(new Block(new Rectangle(new Point(0, 0), 800, 10), Color.GRAY));
            }
        }
        this.point = getVelocity().applyToPoint(this.point);
    }

    /**
     * notifying about the ball hit with the "death bar".
     * @param beingHit the block that the ball hit.
     */
    public void notifyHit(Block beingHit) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        List<HitListener> listenersCopy = new ArrayList<>(listeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listenersCopy) {
            hl.hitEvent(beingHit, this);
        }
    }
    /**
     * method to add the the ball to the game.
     * @param c the game giving.
     */
    public void addToGame(GameLevel c) {
        if (c != null) {
            c.addSprite(this);
        }
    }
    /**
     * removing the ball from the game.
     * @param g our game.
     */
    public void removeFromGame(GameLevel g) {
        if (g != null) {
            g.removeSprite(this);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);

    }
}


