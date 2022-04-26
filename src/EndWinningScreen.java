import biuoop.DrawSurface;
/**
 * a class that shows a loosing screen when the player wins.
 */
public class EndWinningScreen implements Animation {
    private final int score;
    /**
     * the winning screen constructor.
     * @param score is the score at that moment.
     */
    public EndWinningScreen(int score) {
        this.score = score;
    }
    /**
     * a method that draws the winning screen.
     * @param d is the draw surface giving.
     */
    public void doOneFrame(DrawSurface d) {
            d.drawText(10, d.getHeight() / 2, "You Win ! Your score is " + this.score + " press space to exit", 32);
        }
    /**
     * a method that tells when to quit the winning screen.
     * @return boolean value.
     */
    public boolean shouldStop() {
        return false;
    }
}
