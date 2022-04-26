import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines level two.
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocity = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(315 + i * 10, 6);
            ballVelocity.add(v1);
        }
        return ballVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 20;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public ArrayList<Sprite> getBackground() {
        java.util.ArrayList<Sprite> spriteList = new ArrayList<>();
        Block b1 =  new Block(new Rectangle(new Point(10, 20), 780, 600), Color.WHITE);
        Ball b2 = new Ball(100, 130, 75, Color.ORANGE);
        Ball b3 = new Ball(100, 130, 60, Color.yellow.darker());
        Ball b4 = new Ball(100, 130, 45, Color.yellow);
        spriteList.add(b1);
        spriteList.add(b2);
        spriteList.add(b3);
        spriteList.add(b4);
        return spriteList;
    }

    @Override
    public List<Block> blocks() {
        java.util.ArrayList<Block> blockList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i == 0 || i == 1) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.RED);
                blockList.add(b1);
            }
            if (i == 2 || i == 3) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.ORANGE);
                blockList.add(b1);
            }
            if (i == 4 || i == 5 || i == 6) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.YELLOW);
                blockList.add(b1);
            }
            if (i == 7 || i == 8) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.GREEN);
                blockList.add(b1);
            }
            if (i == 9 || i == 10) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.BLUE);
                blockList.add(b1);
            }
            if (i == 11 || i == 12) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.PINK);
                blockList.add(b1);
            }
            if (i == 13 || i == 14) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 230), 52, 30), Color.CYAN);
                blockList.add(b1);
            }
        }
        return blockList;
    }



    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
