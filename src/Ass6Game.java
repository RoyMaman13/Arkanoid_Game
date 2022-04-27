import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * a main class that starts the game.
 */
public class Ass6Game {
    /**
     * the main method.
     * @param args are the levels giving.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        LevelInformation level1 = new LevelOne();
        LevelInformation level2 = new LevelTwo();
        LevelInformation level3 = new LevelThree();
        LevelInformation level4 = new LevelFour();
        for (String arg : args) {
            switch (arg) {
                case "1":
                    levels.add(level1);
                    break;
                case "2":
                    levels.add(level2);
                    break;
                case "3":
                    levels.add(level3);
                    break;
                case "4":
                    levels.add(level4);
                    break;
                default:
            }
        }
        if (levels.isEmpty()) {
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);
        }

        final GUI gui = new GUI("Roy's Arknoid Game", 800, 600);
        final AnimationRunner animationR = new AnimationRunner(gui);
        final GameFlow gameFlow = new GameFlow(animationR, gui.getKeyboardSensor(), gui);
        gameFlow.runLevels(levels);
    }
}

