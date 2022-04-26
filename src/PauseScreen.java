import biuoop.DrawSurface;


/**
 * a class that defines the pause screen.
 */
public class PauseScreen implements Animation {
    /**
     * the pause screen constructor.
     */
    public PauseScreen() {
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);

    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}