import biuoop.DrawSurface;

/**
 * an interface class that is defines the sprites.
 */
public interface Sprite {
    /**
     * method that draws the sprite object.
     * @param d object.
     */
    void drawOn(DrawSurface d);
    /**
     * method that calculating the time that passed.
     */
    void timePassed();
}