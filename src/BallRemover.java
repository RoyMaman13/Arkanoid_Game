/**
 * a class that removing the ball.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * the ball remover constructor.
     * @param game our game.
     * @param removedBlocks the counter of the blocks that were removed.
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = this.game.getBallsAmount();
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.increase(1);
    }
}
