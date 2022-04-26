import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines level one.
 */
public class LevelOne implements LevelInformation {
    private int numOfBalls = 1;
    @Override
    public int numberOfBalls() {
        return numOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        java.util.ArrayList<Velocity> ballVelocity = new ArrayList<>();
        Velocity v1 = new Velocity(0, -3);
        ballVelocity.add(v1);
        return ballVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public ArrayList<Sprite> getBackground() {
        java.util.ArrayList<Sprite> spriteList = new ArrayList<>();
        Block b1 =  new Block(new Rectangle(new Point(10, 20), 780, 600), Color.BLACK);
        Ball b2 = new Ball(405, 185, 147, Color.BLUE);
        Ball b3 = new Ball(405, 185, 145, Color.BLACK);
        Ball b4 = new Ball(405, 185, 107, Color.BLUE);
        Ball b5 = new Ball(405, 185, 105, Color.BLACK);
        Ball b6 = new Ball(405, 185, 67, Color.BLUE);
        Ball b7 = new Ball(405, 185, 65, Color.BLACK);
        Block b8 =  new Block(new Rectangle(new Point(170, 185), 190, 2), Color.BLUE);
        Block b9 =  new Block(new Rectangle(new Point(445, 185), 190, 2), Color.BLUE);
        Block b10 =  new Block(new Rectangle(new Point(403, 25), 3, 120), Color.BLUE);
        Block b11 =  new Block(new Rectangle(new Point(403, 230), 3, 120), Color.BLUE);
        spriteList.add(b1);
        spriteList.add(b2);
        spriteList.add(b3);
        spriteList.add(b4);
        spriteList.add(b5);
        spriteList.add(b6);
        spriteList.add(b7);
        spriteList.add(b8);
        spriteList.add(b9);
        spriteList.add(b10);
        spriteList.add(b11);
        return spriteList;
    }

    @Override
    public List<Block> blocks() {
        java.util.ArrayList<Block> blockList = new ArrayList<>();
        Block b1 = new Block(new Rectangle(new Point(370, 150), 70, 70), Color.RED);
        blockList.add(b1);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
