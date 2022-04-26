/**
 * a class that removing the blocks.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * block remover constructor.
     * @param game our game.
     * @param removedBlocks the counter of the removed blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = this.game.getBlocksAmount();

    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.increase(1);
    }
}
