package de.destiny19.game;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.destiny19.game.Game.GAMESTATE;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 4774938382079844594L;
	private TitleScene title; 	
	private GameScene game;
	private PauseScene pause;

	/**
	 * Create the frame.
	 */
	public Frame(Game.GAMESTATE state) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Game.devstream.println("Could not set LnF - "+e.getLocalizedMessage());
		}
		
		//frame is now set, so load game scenes
		title = new TitleScene(this);
		game = new GameScene(this);
		pause = new PauseScene(this);
		
		setScene(GAMESTATE.TITLE);
		//TODO: add the canvas depending on the game scene
		//TitleScene extends Canvas
	}
	
	public void setScene(Game.GAMESTATE state) {
		getContentPane().removeAll();
		switch(state) {
		case TITLE:
			getContentPane().add(title);
			Game.devstream.println("Scene - Title");
			break;
		case GAME:
			getContentPane().add(game);
			Game.devstream.println("Scene - Game");
			break;
		case PAUSE:
			getContentPane().add(pause);
			Game.devstream.println("Scene - Pause");
			break;
		}
		
		render();
	}
	
	public void render() {
		title.render();
		game.render();
		pause.render();
	}
}
