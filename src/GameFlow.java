import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * a class that in charges of running the game.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private GUI gui;
    private Counter scoreCounter = new Counter();
    /**
     * the game flow constructor.
     * @param ar the animation.
     * @param ks the keyboard sensor.
     * @param gui is the game screen.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboard = ks;
        this.gui = gui;
    }

    /**
     * the method that runs the levels.
     * @param levels is a list that holds the levels information needed.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboard, this.gui, scoreCounter);
            level.initialize();

            while (levelInfo.blocks().size() - level.getBlocksAmount().getValue() != 0) {
                level.run();
                if (levelInfo.numberOfBalls() - level.getBallsAmount().getValue() == 0) {
                    this.animationRunner.run(new KeyPressStoppableAnimation(keyboard,
                            KeyboardSensor.SPACE_KEY, new EndLosingScreen(scoreCounter.getValue())));
                    gui.close();
                    return;
                }
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(keyboard,
                KeyboardSensor.SPACE_KEY, new EndWinningScreen(scoreCounter.getValue())));
        gui.close();
    }
}