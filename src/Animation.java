import biuoop.DrawSurface;

/**
 * an interface for animation.
 */

public interface Animation {
    /**
     * the drawing method.
     * @param d is the draw surface giving.
     */
    void doOneFrame(DrawSurface d);

    /**
     * a method that checks if the animation should stop.
     * @return boolean value.
     */
    boolean shouldStop();
}
