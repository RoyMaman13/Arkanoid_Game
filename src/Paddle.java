import biuoop.DrawSurface;
import java.awt.*;
import java.util.ArrayList;

/**
 * a class that defines the paddle.
 */
public class Paddle implements Collidable, Sprite {
    private Rectangle rect;
    private java.awt.Color color = Color.ORANGE;
    private biuoop.KeyboardSensor keyboard;
    private GameLevel game;
    private java.util.List<Ball> ballList;
    private static final double PADDLE_WIDTH = 250;
    private static final double PADDLE_HEIGHT = 20;
    private static final int OPTIONS_NUM = 5;
    private int speed;
    private int width;

    /**
     * the paddle constructor.
     * @param game is the game level.
     * @param speed is the paddle speed.
     * @param width is the width of the paddle.
     */
    public Paddle(GameLevel game, int speed, int width) {
        this.game = game;
        this.keyboard = game.getGUI().getKeyboardSensor();
        this.rect = new Rectangle(new Point(350, 550), width, PADDLE_HEIGHT);
        this.color = color;
        this.ballList = new ArrayList<Ball>();
        this.speed = speed;
        this.width = width;
    }

    /**
     * method that moves the paddle to the left.
     */
    public void moveLeft() {
        double newX = this.rect.getUpperLeft().getX() - this.speed;
        this.rect = new Rectangle(new Point(newX, rect.getUpperLeft().getY()), this.width, PADDLE_HEIGHT);
        }

    /**
     * method that moves the paddle to the right.
     */
    public void moveRight() {
            double newX = this.rect.getUpperLeft().getX() + this.speed;
            this.rect = new Rectangle(new Point(newX, rect.getUpperLeft().getY()), this.width, PADDLE_HEIGHT);
        }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        int angle = collisionOption(collisionPoint);
        if (collisionPoint.getY() == this.rect.getUpperLeft().getY()) {
            return Velocity.fromAngleAndSpeed(angle, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
        }        else {
            return Velocity.fromAngleAndSpeed((-1) * (angle), (-1) * (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2))));
        }
    }

    /**
     * method that finds the area on the paddle that the ball hits.
     * @param collisionPoint is the collision point.
     * @return the angle according to the hit spot.
     */
    public int collisionOption(Point collisionPoint) {
        double paddleSize = Math.abs(this.width);
        double optionSize = paddleSize / OPTIONS_NUM;
        if (collisionPoint.getX() >= this.rect.getUpperLeft().getX()
                && collisionPoint.getX() < (optionSize + this.rect.getUpperLeft().getX())) {
            return 300;
        }
        if (collisionPoint.getX() >= (optionSize + this.rect.getUpperLeft().getX())
                && collisionPoint.getX() < (optionSize * 2 + this.rect.getUpperLeft().getX())) {
            return 330;
        }
        if (collisionPoint.getX() >= (optionSize * 2 + this.rect.getUpperLeft().getX())
                && collisionPoint.getX() < (optionSize * 3 + this.rect.getUpperLeft().getX())) {
            return 1;
        }
        if (collisionPoint.getX() >= (optionSize * 3 + this.rect.getUpperLeft().getX())
                && collisionPoint.getX() < (optionSize * 4 + this.rect.getUpperLeft().getX())) {
            return 30;
        }
        if (collisionPoint.getX() >= (optionSize * 4 + this.rect.getUpperLeft().getX())
                && collisionPoint.getX() <= this.rect.getUpperLeft().getX() + this.width) {
            return 60;
        }
        return 0;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
    }
        @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY) && this.rect.getUpperLeft().getX() > 10) {
            moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY) && this.rect.getUpperLeft().getX() + this.width < 790) {
            moveRight();
        }
    }

    /**
     * method that adding the paddle and his behavior to the game.
     * @param c the game.
     */
    public void addToGame(GameLevel c) {
        c.addCollidable(this);
        c.addSprite(this);
    }
}

