import biuoop.DrawSurface;

/**
 * a class that defines the score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter gameCounter;
    private LevelInformation levelInformation;

    /**
     * the score indicator constructor.
     * @param counter the score counter.
     * @param levelInformation is the information of the level.
     */
    public ScoreIndicator(Counter counter, LevelInformation levelInformation) {
        this.gameCounter = counter;
        this.levelInformation = levelInformation;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(180, 17, "Lives: 1", 15);
        d.drawText(360, 17, "Score: " + this.gameCounter.getValue(), 15);
        d.drawText(500, 17, "Level Name: " + levelInformation.levelName(), 15);
    }

    @Override
    public void timePassed() {
    }

    /**
     * a method that adds the game level to the game.
     * @param gameLevel is the game level.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
