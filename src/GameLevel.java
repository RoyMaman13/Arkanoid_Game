import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.awt.*;
import java.util.ArrayList;
/**
 * a class that sets the game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GUI gui;
    private java.util.ArrayList<Ball> ballsList;
    private java.util.ArrayList<Block> blocksList;
    private GameEnvironment environment;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * the game level constructor.
     * @param levelInformation is the information of the level.
     * @param ar is the animation.
     * @param key is the keyboard sensor.
     * @param gui is the game screen.
     * @param scoreCounter is the score counter.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner ar,
                     KeyboardSensor key, GUI gui, Counter scoreCounter) {
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.sprites = new SpriteCollection();
        this.ballsList = new ArrayList<Ball>();
        this.blocksList = new ArrayList<Block>();
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter();
        this.scoreCounter = scoreCounter;
        this.runner = ar;
        this.keyboard = key;
        this.levelInformation = levelInformation;
    }

    /**
     * method to add colloidal objects to the game.
     *
     * @param c the object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * method to add sprites objects to the game.
     *
     * @param s the object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * method to.
     *
     * @return the gui.
     */
    public GUI getGUI() {
        return gui;
    }

    /**
     * method the creating the borders and setting them into the game.
     */
    public void borderCreator() {
        java.util.ArrayList<Block> borderBlocks = new ArrayList<>();
        borderBlocks.add(new Block(new Rectangle(new Point(0, 20), 800, 10), Color.GRAY));
        borderBlocks.add(new Block(new Rectangle(new Point(0, 20), 10, 590), Color.GRAY));
        borderBlocks.add(new Block(new Rectangle(new Point(0, 610), 900, 10), Color.GRAY));
        borderBlocks.add(new Block(new Rectangle(new Point(790, 20), 10, 590), Color.GRAY));
        for (Block b : borderBlocks) {
            b.addToGame(this);
        }
    }

    /**
     * getting the blocks counter.
     * @return the blocks counter.
     */
    public Counter getBlocksAmount() {
        return blocksCounter;
    }

    /**
     * getting the balls counter.
     * @return the balls counter.
     */
    public Counter getBallsAmount() {
        return ballsCounter;
    }

    /**
     * initializing the game.
     */
    public void initialize() {
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreCounter, this.levelInformation);
        scoreIndicator.addToGame(this);

        ArrayList<Sprite> spriteList  = levelInformation.getBackground();
        for (Sprite s : spriteList) {
            this.sprites.addSprite(s);
        }
        HitListener phl = new BlockRemover(this, getBlocksAmount());
        HitListener phl2 = new ScoreTrackingListener(this.scoreCounter);
        for (Block b : levelInformation.blocks()) {
            b.addToGame(this);
            b.addHitListener(phl);
            b.addHitListener(phl2);
        }
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball b1 = new Ball(400, 500, 5, Color.WHITE);
            b1.setVelocity(levelInformation.initialBallVelocities().get(i).getDx(),
                    levelInformation.initialBallVelocities().get(i).getDy());
            ballsList.add(b1);
        }
        for (Ball ball1 : ballsList) {
            ball1.addToGame(this);
            ball1.setGame(environment);
            HitListener phl1 = new BallRemover(this, getBallsAmount());
            ball1.addHitListener(phl1);
        }

        borderCreator();

        Paddle p = new Paddle(this, levelInformation.paddleSpeed(), levelInformation.paddleWidth());
        p.addToGame(this);

        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
    }

    /**
     * removing colloidal object.
     * @param c colloidal object.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * removing sprite object.
     * @param s sprite object.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }



    /**
     * method that running the game.
     */
    public void run() {
//          this.runner.run(new CountdownAnimation(3, 3, this.sprites));
//        this.createBallsOnTopOfPaddle(); // or a similar method
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (!this.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            d = this.gui.getDrawSurface();
            this.sprites.drawAllOn(d);
            gui.show(d);
            if ((levelInformation.blocks().size() - blocksCounter.getValue()) == 0) {
                this.scoreCounter.increase(100);
                this.running = false;
            }
            if ((levelInformation.numberOfBalls() - this.ballsCounter.getValue()) == 0) {
                this.running = false;
            }
            if (this.keyboard.isPressed("p")) {
                this.runner.run(new KeyPressStoppableAnimation(keyboard,
                        KeyboardSensor.SPACE_KEY, new PauseScreen()));
            }
            this.sprites.notifyAllTimePassed();
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
