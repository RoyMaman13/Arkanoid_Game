import java.util.ArrayList;

/**
 * a class that defines the game environment.
 */
public class GameEnvironment {
    private ArrayList<Collidable> collisions;

    /**
     * the game environment constructor.
     */
    public GameEnvironment() {
        this.collisions = new ArrayList<>();
    }

    /**
     * method that adds colloidal objects.
     * @param c colloidal object.
     */
    public void addCollidable(Collidable c) {
        collisions.add(c);
    }
    /**
     * method that removing colloidal objects.
     * @param c colloidal object.
     */
    public void removeCollidable(Collidable c) {
        collisions.remove(c);
    }

    /**
     * finding the closest collision if theres one.
     * @param trajectory the line given.
     * @return collision point and object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closest = null;
        double distance = trajectory.length() + 1;
        int index = -1;
        for (int i = 0; i < this.collisions.size(); i++) {
            Point collisionPoint
                    = trajectory.closestIntersectionToStartOfLine(collisions.get(i).getCollisionRectangle());
            if (collisionPoint != null) {
                double dist = trajectory.start().distance(collisionPoint);
                if (dist < distance) {
                    distance = dist;
                    index = i;
                    closest = collisionPoint;
                }
            }
        }
        if (index == -1) {
            return null;
        }
        return new CollisionInfo(closest, collisions.get(index));

    }
}

