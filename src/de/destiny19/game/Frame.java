package de.destiny19.game;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.destiny19.game.Game.GAMESTATE;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;
import java.awt.CardLayout;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 4774938382079844594L;
	public static TitleScene title;
	public static GameScene game;
	public static PauseScene pause;
	public int nMode = 0;

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
		getContentPane().setLayout(new CardLayout(0, 0));
		
		getContentPane().add(title, "title");
		getContentPane().add(game, "game");
		getContentPane().add(pause, "pause");
		
		setScene(GAMESTATE.TITLE);
		//TODO: add the canvas depending on the game scene
		//TitleScene extends Canvas
	}
	
	public void setScene(Game.GAMESTATE state) {
		CardLayout cl = (CardLayout)(getContentPane().getLayout());
		switch(state) {
		case TITLE:
			cl.show(getContentPane(), "title");
			nMode = 0;
			Game.devstream.println("Scene - Title");
			break;
		case GAME:
			cl.show(getContentPane(), "game");
			nMode = 1;
			Game.devstream.println("Scene - Game");
			break;
		case PAUSE:
			cl.show(getContentPane(), "pause");
			nMode = 2;
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

	public void update(){
	    if(nMode == 1)
	        game.updateGameState();
    }
}
