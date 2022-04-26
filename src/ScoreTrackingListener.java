/**
 * a class that tracks the score listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * a method that tracks the score listener.
     * @param scoreCounter is the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
@Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}
