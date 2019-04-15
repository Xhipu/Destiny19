package de.destiny19;

import de.destiny19.game.Frame;
import de.destiny19.logic.Enemy;
import de.destiny19.player.Player;
import de.destiny19.ui.Log;

public class Main implements Runnable {
	public static GameConfigInjector confInjector;
	public static GameObjectInjector objInjector;
	public static boolean _DEBUG;
	
	public enum GAMESTATE {TITLE, GAME, PAUSE}
	
	private Thread gThread;
	private boolean running = false;

	@Injectable public static Frame mainframe;
	
	@Override
	public void run() {
		while (isRunning()) {
			processInput();
			updateGameState();
			render();
			sync(1000/confInjector.FPS);
		}
		mainframe.dispose();
	}
	
	public synchronized void start() {
		mainframe = objInjector.FRAME;
		mainframe.setScene(GAMESTATE.TITLE);
		mainframe.setVisible(true);
		Logger.trace("Starting game loop\n-------------------------");
		gThread = new Thread(this);
		gThread.start();
		setRunning(true);
	}
	
	public synchronized void stop() throws InterruptedException {
		if (isRunning()) {
			setRunning(false); //thread will stop auto, because it exits loop
			
			Logger.trace("Game loop stopped\n-------------------------");
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
				Logger.trace("Could not sync: "+e.getLocalizedMessage());
			}
		} while (lnStop - lnStart <= lnTime);
	}

	public void processInput() {
		
	}

	public void updateGameState() {
		int nMode = mainframe.mode;
		switch(nMode) {
		case 0:
			break;
		case 1:
			mainframe.game.updateGameState();
			break;
		case 2:
			break;
			default:
				break;
		}
	}

	public void render() {
		mainframe.render();
	}
	
	public static void main(String args[]) throws Exception {
		confInjector = new GameConfigInjector();
		objInjector = new GameObjectInjector();

		if(args.length > 0) {
			if(args[0].equals("-d")) {
				System.out.println("Starting in debug");
				_DEBUG = true;	
			} else throw new Exception("Unknown initializing argument, try '-d' or none");
		} else {
			System.out.println("Starting in release");
			_DEBUG = false;
		}

		confInjector.initialize();
		objInjector.initialize(args, confInjector);

		Main game = new Main();
		game.start();
	}
	
	public static Player GetPlayer() {
		Player plRet;
		plRet = mainframe.game.getPlayer();
		return plRet;
	}
	
	public static void SetPlayer(Player _player) {
		mainframe.game.player =  _player;
	}

	public static Log GetGameConsole(){
		return mainframe.game.console;
	}
	
	public static Enemy GetCurrentEnemy() throws Exception {
		return mainframe.game.enemySpawn.getInstances().get(0);
	}
}
