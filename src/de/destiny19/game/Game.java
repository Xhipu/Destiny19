package de.destiny19.game;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import de.destiny19.player.Player;

public class Game implements Runnable {
	public static PrintStream devstream;
	static Player player = new Player(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	
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
	
	public synchronized void start() {
		mainframe = new Frame(GAMESTATE.TITLE);
		mainframe.setVisible(true);
		devstream.println("Starting game loop");
		gThread = new Thread(this);
		gThread.start();
		setRunning(true);
		
		//test
		player.getTimer().setTaskDuration(50);
		player.getTimer().init();
	}
	
	public synchronized void stop() throws InterruptedException {
		if (isRunning()) {
			setRunning(false); //thread will stop auto, because it exits loop
			//test
			player.getTimer().destroy();
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

	public void processInput() {
		
	}

	public void updateGameState() {
		player.getTimer().perform();
	}

	public void render() {
		mainframe.render();
	}
	
	public static void main(String args[]) {
		try {
			if(args[0].equals("-d")) {
				System.out.println("Starting in debug");
				devstream = System.out;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Starting in release");
			devstream = new PrintStream(new OutputStream() {
				public void write(int arg0) throws IOException {return;}
			});
		}
		Game game = new Game();
		game.start();
	}

	public Frame getMainframe() {
		return mainframe;
	}

	public void setMainframe(Frame mainframe) {
		this.mainframe = mainframe;
	}
}
