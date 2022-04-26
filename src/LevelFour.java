import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that defines level four.
 */
public class LevelFour implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocity = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(345 + i * 15, 6);
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
        return 200;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public ArrayList<Sprite> getBackground() {
        java.util.ArrayList<Sprite> spriteList = new ArrayList<>();
        Block b1 =  new Block(new Rectangle(new Point(10, 20), 780, 600), Color.BLUE.brighter());
        Ball b2 = new Ball(165, 380, 40, Color.white.darker().darker());
        Ball b3 = new Ball(210, 360, 40, Color.white.darker());
        Ball b4 = new Ball(250, 395, 40, Color.GRAY);
        Ball b5 = new Ball(200, 420, 40, Color.white.darker());
        Ball b6 = new Ball(150, 415, 40, Color.white.darker());
        Ball b7 = new Ball(565, 380, 40, Color.white.darker().darker());
        Ball b8 = new Ball(610, 360, 40, Color.white.darker());
        Ball b9 = new Ball(650, 395, 40, Color.GRAY);
        Ball b10 = new Ball(600, 420, 40, Color.white.darker());
        Ball b11 = new Ball(550, 415, 40, Color.white.darker());
        Line b12 = new Line(200, 400, 170, 600, Color.white);
        Line b16 = new Line(190, 400, 160, 600, Color.white);
        Line b13 = new Line(180, 400, 150, 600, Color.white);
        Line b17 = new Line(170, 400, 140, 600, Color.white);
        Line b14 = new Line(160, 400, 130, 600, Color.white);
        Line b18 = new Line(150, 400, 120, 600, Color.white);
        Line b15 = new Line(140, 400, 110, 600, Color.white);
        Line b19 = new Line(210, 400, 180, 600, Color.white);
        Line b20 = new Line(220, 400, 190, 600, Color.white);
        Line b21 = new Line(230, 400, 200, 600, Color.white);
        Line b22 = new Line(240, 400, 210, 600, Color.white);
        Line b23 = new Line(250, 400, 220, 600, Color.white);
        Line b24 = new Line(260, 400, 230, 600, Color.white);
        Line b25 = new Line(270, 400, 240, 600, Color.white);
        Line b26 = new Line(540, 400, 510, 600, Color.white);
        Line b27 = new Line(550, 400, 520, 600, Color.white);
        Line b28 = new Line(560, 400, 530, 600, Color.white);
        Line b29 = new Line(570, 400, 540, 600, Color.white);
        Line b30 = new Line(580, 400, 550, 600, Color.white);
        Line b31 = new Line(590, 400, 560, 600, Color.white);
        Line b32 = new Line(600, 400, 570, 600, Color.white);
        Line b33 = new Line(610, 400, 580, 600, Color.white);
        Line b34 = new Line(620, 400, 590, 600, Color.white);
        Line b35 = new Line(630, 400, 600, 600, Color.white);
        Line b36 = new Line(640, 400, 610, 600, Color.white);
        Line b37 = new Line(650, 400, 620, 600, Color.white);
        Line b38 = new Line(660, 400, 630, 600, Color.white);
        Line b39 = new Line(670, 400, 640, 600, Color.white);
        spriteList.add(b1);
        spriteList.add(b12);
        spriteList.add(b13);
        spriteList.add(b14);
        spriteList.add(b15);
        spriteList.add(b16);
        spriteList.add(b17);
        spriteList.add(b18);
        spriteList.add(b19);
        spriteList.add(b20);
        spriteList.add(b21);
        spriteList.add(b22);
        spriteList.add(b23);
        spriteList.add(b24);
        spriteList.add(b25);
        spriteList.add(b26);
        spriteList.add(b27);
        spriteList.add(b28);
        spriteList.add(b29);
        spriteList.add(b30);
        spriteList.add(b31);
        spriteList.add(b32);
        spriteList.add(b33);
        spriteList.add(b34);
        spriteList.add(b35);
        spriteList.add(b36);
        spriteList.add(b37);
        spriteList.add(b38);
        spriteList.add(b39);
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

    /**
     * method that tells the color of the block.
     * @param j the number of the block from left to right..
     * @return the color of the block.
     */
    public java.awt.Color colorGet(int j) {
        if (j == 0) {
            return Color.CYAN;
        }
        if (j == 1) {
            return Color.PINK;
        }
        if (j == 2) {
            return Color.WHITE;
        }
        if (j == 3) {
            return Color.GREEN.brighter();
        }
        if (j == 4) {
            return Color.YELLOW;
        }
        if (j == 5) {
            return Color.RED;
        }
        if (j == 6) {
            return Color.GRAY;
        }
        return null;
    }

    @Override
    public List<Block> blocks() {
        java.util.ArrayList<Block> blockList = new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 15; i++) {
                Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 250 - 20 * j), 52, 20), colorGet(j));
                blockList.add(b1);
            }
        }
        for (int i = 0; i < 15; i++) {
            Block b1 = new Block(new Rectangle(new Point(10 + 52 * i, 250 - 20 * 6), 52, 20), Color.GRAY);
            blockList.add(b1);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
