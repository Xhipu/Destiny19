package de.destiny19.game;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Game implements Runnable, IGame {
	public static PrintStream devstream;
	
	public static enum GAMECONFIG {
		FPS(60);
		private int fps;
		
		private GAMECONFIG(int fps) {
			setFps(fps);
		}

		public int getFps() {
			return fps;
		}

		public void setFps(int fps) {
			this.fps = fps;
		}
	}
	
	public static enum GAMESTATE {
		TITLE, GAME, PAUSE
	}
	
	private Thread gThread;
	private boolean running = false;
	private Frame mainframe;
	
	@Override
	public void run() {
		//initialize the frame
		mainframe.setVisible(true);
		while (isRunning()) {
			processInput();
			updateGameState();
			render();
			sync(1000/GAMECONFIG.FPS.getFps());
		}
		mainframe.dispose();
	}

	public Thread getThread() {
		return gThread;
	}

	public void setThread(Thread gThread) {
		this.gThread = gThread;
	}
	
	public synchronized void start(String param /*start in debug or release*/) {
		switch (param) {
		case "-d":
		case "-D":
			devstream = System.out;
			break;
		case "-r":
		case "-R":
		case "":
		default:
			devstream = new PrintStream(new OutputStream() {
				@Override
				public void write(int e) throws IOException {}
			});
			break;
		}
		
		mainframe = new Frame(GAMESTATE.TITLE);
		devstream.println("Starting game loop");
		gThread = new Thread(this);
		gThread.start();
		setRunning(true);
	}
	
	public synchronized void stop() throws InterruptedException {
		if (isRunning()) {
			setRunning(false); //thread will stop auto, because it exits loop
			devstream.println("Game loop stopped");
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void sync(long lnTime) {
		long lnStart = System.currentTimeMillis();
		long lnStop;
		do {
			lnStop = System.currentTimeMillis();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				devstream.println("Could not sync: "+e.getLocalizedMessage());
			}
		} while (lnStop - lnStart <= lnTime);
	}

	@Override
	public void processInput() {
		
	}

	@Override
	public void updateGameState() {
		
	}

	@Override
	public void render() {
		mainframe.render();
	}
	
	public Game() {
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start(args[0]);
	}

	public Frame getMainframe() {
		return mainframe;
	}

	public void setMainframe(Frame mainframe) {
		this.mainframe = mainframe;
	}
}
