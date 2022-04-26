import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines the blocks.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private java.util.List<HitListener> hitListeners;
    private Rectangle rect;
    private java.awt.Color color;

    /**
     * Block constructors.
     *
     * @param rect  Rectangle shape.
     * @param color color.
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = collisionPoint.getX();
        double y = collisionPoint.getY();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        Velocity newVelocity;
        //up
        if ((x > rect.getUpperLeft().getX()) && (x < rect.getUpperLeft().getX() + rect.getWidth())) {
            newVelocity =  new Velocity(dx, (-1) * dy);
        } else if ((y > rect.getUpperLeft().getY()) && (y < rect.getUpperLeft().getY() + rect.getHeight())) {
            newVelocity = new Velocity((-1) * dx, dy);
        } else {
            newVelocity = new Velocity((-1) * dx, (-1) * dy);
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * removing the block from the game.
     * @param game our game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * adding the blocks to the game.
     *
     * @param c the game.
     */
    public void addToGame(GameLevel c) {
        c.addCollidable(this);
        c.addSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * notifying about the ball - block hit.
     * @param hitter the ball that hit the block.
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        List<HitListener> listenersCopy = new ArrayList<>(listeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listenersCopy) {
                hl.hitEvent(this, hitter);
        }
    }
}