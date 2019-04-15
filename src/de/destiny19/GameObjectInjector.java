package de.destiny19;

import de.destiny19.game.Frame;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class GameObjectInjector {
    public Frame FRAME;
    public TitleScene TITLE;
    public GameScene GAME;
    public PauseScene PAUSE;

    public static final String[] ENEMIES = {
            "./res/enemies/pipo-boss001.png",
            "./res/enemies/pipo-boss002.png",
            "./res/enemies/pipo-boss003.png",
            "./res/enemies/pipo-boss004.png",
            "./res/enemies/pipo-enemy001.png",
            "./res/enemies/pipo-enemy002.png",
            "./res/enemies/pipo-enemy003.png",
            "./res/enemies/pipo-enemy004.png",
            "./res/enemies/pipo-enemy005.png",
            "./res/enemies/pipo-enemy006.png",
            "./res/enemies/pipo-enemy007.png",
            "./res/enemies/pipo-enemy008.png",
            "./res/enemies/pipo-enemy009.png",
            "./res/enemies/pipo-enemy010.png",
            "./res/enemies/pipo-enemy011.png",
            "./res/enemies/pipo-enemy012.png",
            "./res/enemies/pipo-enemy013.png",
            "./res/enemies/pipo-enemy014.png",
            "./res/enemies/pipo-enemy015.png",
            "./res/enemies/pipo-enemy016.png",
            "./res/enemies/pipo-enemy017.png",
            "./res/enemies/pipo-enemy019.png",
            "./res/enemies/pipo-enemy020.png",
            "./res/enemies/pipo-enemy021.png",
            "./res/enemies/pipo-enemy022.png",
            "./res/enemies/pipo-enemy023.png",
            "./res/enemies/pipo-enemy024.png",
            "./res/enemies/pipo-enemy025.png",
            "./res/enemies/pipo-enemy026.png",
            "./res/enemies/pipo-enemy027.png",
            "./res/enemies/pipo-enemy028.png",
            "./res/enemies/pipo-enemy029.png",
            "./res/enemies/pipo-enemy030.png",
            "./res/enemies/pipo-enemy031.png",
            "./res/enemies/pipo-enemy032.png",
            "./res/enemies/pipo-enemy033.png",
            "./res/enemies/pipo-enemy034.png",
            "./res/enemies/pipo-enemy035.png",
            "./res/enemies/pipo-enemy036.png",
            "./res/enemies/pipo-enemy037.png",
            "./res/enemies/pipo-enemy038.png",
            "./res/enemies/pipo-enemy039.png",
            "./res/enemies/pipo-enemy040.png"
    };

    public void initialize(String args[], GameConfigInjector injector){
        //Logger
        try {
            if(args[0].equals("-d")) {
                Logger.setStream(System.out);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            Logger.setStream(new PrintStream(new OutputStream() {
                public void write(int n) throws IOException {return;}
            }));
        }

        FRAME = new Frame(injector.TITLE, injector.WIDTH, injector.HEIGHT);

        try {
            TITLE = new TitleScene(FRAME);
            GAME = new GameScene(FRAME);
            PAUSE = new PauseScene(FRAME);

            FRAME.initTitle(TITLE);
            FRAME.initGame(GAME);
            FRAME.initPause(PAUSE);
        } catch(IOException e){
            Logger.trace(String.format("Unable to load scenes - %s", e.getMessage()));
        }
    }

    public static File GetRandomEnemyPicture() throws IOException {
        int nMaxIndex = ENEMIES.length;
        Random rnd = new Random();
        String nextPath = ENEMIES[rnd.nextInt(nMaxIndex)];

        return new File(nextPath);
    }
}
