import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * a class that runs the animation.
 */
public class AnimationRunner {
    private final GUI gui;
    private static final int FRAME_PER_SECOND = 60;
    private final Sleeper sleeper;

    /**
     * the animation runner constructor.
     * @param gui is the screen giving.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.sleeper = new Sleeper();
    }

    /**
     * the method that runs the animation.
     * @param animation is the animation giving.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / FRAME_PER_SECOND;

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
