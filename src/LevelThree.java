import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines level three.
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocity = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(330 + i * 60, 6);
            ballVelocity.add(v1);
        }
        return ballVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public ArrayList<Sprite> getBackground() {
        java.util.ArrayList<Sprite> spriteList = new ArrayList<>();
        Block b1 =  new Block(new Rectangle(new Point(10, 20), 780, 600), Color.GREEN.darker());
        Block b2 =  new Block(new Rectangle(new Point(70, 350), 180, 250), Color.BLACK);
        Block b3 =  new Block(new Rectangle(new Point(80, 360), 160, 250), Color.WHITE);
        Block b4 =  new Block(new Rectangle(new Point(70, 390), 180, 10), Color.BLACK);
        Block b5 =  new Block(new Rectangle(new Point(70, 440), 180, 10), Color.BLACK);
        Block b6 =  new Block(new Rectangle(new Point(70, 490), 180, 10), Color.BLACK);
        Block b7 =  new Block(new Rectangle(new Point(70, 540), 180, 10), Color.BLACK);
        Block b8 =  new Block(new Rectangle(new Point(100, 350), 10, 250), Color.BLACK);
        Block b9 =  new Block(new Rectangle(new Point(135, 350), 10, 250), Color.BLACK);
        Block b10 =  new Block(new Rectangle(new Point(170, 350), 10, 250), Color.BLACK);
        Block b11 =  new Block(new Rectangle(new Point(205, 350), 10, 250), Color.BLACK);
        Block b12 =  new Block(new Rectangle(new Point(130, 250), 70, 100), Color.GRAY.darker());
        Block b13 =  new Block(new Rectangle(new Point(157, 110), 15, 140), Color.GRAY.darker());
        Ball b14 = new Ball(165, 90, 20, Color.yellow);
        Ball b15 = new Ball(165, 90, 10, Color.RED);
        Ball b16 = new Ball(165, 90, 5, Color.WHITE);
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
        spriteList.add(b12);
        spriteList.add(b13);
        spriteList.add(b14);
        spriteList.add(b15);
        spriteList.add(b16);
        return spriteList;
    }

    /**
     * a method that tells the color of the raw.
     * @param round the number of the raw.
     * @return the color needed for the raw.
     */
    public java.awt.Color colorCreator(int round) {
        if (round == 0) {
            return Color.GRAY;
        }
        if (round == 1) {
            return Color.RED;
        }
        if (round == 2) {
            return Color.YELLOW;
        }
        if (round == 3) {
            return Color.BLUE;
        }
        if (round == 4) {
            return Color.WHITE;
        }
        return null;
    }
    @Override
    public List<Block> blocks() {
        java.util.ArrayList<Block> blocksList = new ArrayList<>();
        int rowObjects;
        int y;
        int x;
        java.awt.Color color;
        for (int i = 0; i < 5; i++) {
            rowObjects = 10 - i;
            y = (i * 25) + 90;
            x = 240 + (i * 55);
            for (int j = 0; j <= rowObjects; j++) {
                color = colorCreator(i);
                if (j != 0) {
                    blocksList.add(new Block(new Rectangle(new Point(x - 55, y),
                            55, 25), color));
                }
                x = x + 55;
            }
        }
        for (int k = 0; k < 10; k++) {
            blocksList.add(new Block(new Rectangle(new Point(240 + 55 * k, 90),
                    55, 25), Color.GRAY));
        }

        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
