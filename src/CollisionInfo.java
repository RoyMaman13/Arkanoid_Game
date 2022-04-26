/**
 * a class that defines the collision info.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable colloidalObject;

    /**
     * the collision info instructors.
     * @param cP the collision point.
     * @param cO the collision object.
     */
    public CollisionInfo(Point cP, Collidable cO) {
        this.collisionPoint = cP;
        this.colloidalObject = cO;
    }

    /**
     * method that.
     * @return the collision point.
     */
    public Point collisionPoint() {
        if (this.collisionPoint != null) {
            return this.collisionPoint;
        } else {
            return null;
        }
    }
    /**
     * method that.
     * @return the colloidal object.
     */
    public Collidable collisionObject() {
        return this.colloidalObject;
    }
}

