package de.destiny19;

import de.destiny19.game.Frame;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class GameObjectInjector {
    public Frame FRAME;
    public TitleScene TITLE;
    public GameScene GAME;
    public PauseScene PAUSE;

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
}
