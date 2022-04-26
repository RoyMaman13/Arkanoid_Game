/**
 * an interface that notifying a hit.
 */
public interface HitNotifier {
    /**
     * adding an hit listener.
     * @param hl is the hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * removing the hit listener.
     * @param hl is the hit listener.
     */
    void removeHitListener(HitListener hl);
}
