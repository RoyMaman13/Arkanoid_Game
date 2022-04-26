/**
 * a class that gathers all the objects that may be deleted or changed.
 */
public interface HitListener {
    /**
     * a method that called whenever a a listener object is being hit.
     * @param beingHit the block that was hit.
     * @param hitter the ball that being hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
