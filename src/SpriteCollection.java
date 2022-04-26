import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines all the sprites objects.
 */
public class SpriteCollection {
    private ArrayList<Sprite> spriteList;
    /**
     * sprite constructor.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }
    /**
     * method that adds sprites to a list.
     * @param s is the sprite object giving.
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * removing sprite object.
     * @param s sprite object.
     */
    public void removeSprite(Sprite s) {
        spriteList.remove(s);
    }

    /**
     * method that call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteListCopy = new ArrayList<>(spriteList);
        for (Sprite sprite : spriteListCopy) {
            sprite.timePassed();
        }
    }

    /**
     * method that call drawOn(d) on all sprites.
     * @param d the surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}
