package de.destiny19;

public class GameConfigInjector {
    public String TITLE;
    public int WIDTH, HEIGHT, FPS;

    public void initialize(){
        TITLE = "Destiny19";
        WIDTH = 1200;
        HEIGHT = 800;
        FPS = 60;
    }
    
    public int FrameCount(int nMultiply) {
    	return nMultiply * FPS;
    }
}
