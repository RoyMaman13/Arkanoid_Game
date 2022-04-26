import biuoop.DrawSurface;
/**
 * a class that shows a loosing screen when the player loses.
 */
public class EndLosingScreen implements Animation {
    private final int score;

    /**
     * the losing screen constructor.
     * @param score is the score at that moment.
     */
    public EndLosingScreen(int score) {
        this.score = score;
    }
    /**
     * a method that draws the losing screen.
     * @param d is the draw surface giving.
     */
    public void doOneFrame(DrawSurface d) {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score + " press space to exit", 32);
        }
    /**
     * a method that tells when to quit the losing screen.
     * @return boolean value.
     */
    public boolean shouldStop() {
        return false;
    }
}