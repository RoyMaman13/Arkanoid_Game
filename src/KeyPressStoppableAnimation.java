import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * a class that defines the key that stops the animation.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean done;
    private boolean isAlreadyPressed;

    /**
     * the Key Press Stoppable Animation constructor.
     * @param sensor the keyboard sensor.
     * @param key to be pressed.
     * @param animation to be displayed.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.key = key;
    }
    /**
     * Do the actions for each frame.
     * @param d The surface to be drawn.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.done = true;
        }

        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * Will check when it should be stopped.
     * @return true or false.
     */
    @Override
    public boolean shouldStop() {
        return this.done;
    }
}
