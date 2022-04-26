import biuoop.DrawSurface;
/**
 * a class that defines the countdown before the level starts.
 */
public class CountdownAnimation implements Animation {
    private boolean stop = false;
    private double numOfSeconds;
    private int countFrom;
    private int countDown;
    private SpriteCollection screen;
    private double initialTime = System.currentTimeMillis();

    /**
     * the countdown constructor.
     * @param numOfSeconds number of seconds needed.
     * @param countFrom the number that the countdown starts from.
     * @param gameScreen is the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.screen = gameScreen;
        this.countDown = countFrom;
    }

    /**
     * a drawing countdown method.
     * @param d is the draw surface giving.
     */
    public void doOneFrame(DrawSurface d) {
        this.screen.drawAllOn(d);
        d.setColor(java.awt.Color.RED);
        d.drawText(390, 400, getNumber(), 45);
        if (countDown < 1) {
            stop = true;
        }
    }

    /**
     * a method that gets the number that should be seen on the moment.
     * @return the number.
     */
    private String getNumber() {
        double currentTime = System.currentTimeMillis();
        if ((currentTime - initialTime) > (double) (numOfSeconds / (countFrom + 1)) * 1000) {
            countDown--;
            initialTime = System.currentTimeMillis();
        }
        return ("" + countDown + "");
    }

    /**
     * a method that tells if the countdown should stop.
     * @return boolean value.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}