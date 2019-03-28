package de.destiny19.game;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.destiny19.game.Main.GAMESTATE;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;
import java.awt.CardLayout;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 4774938382079844594L;
	public TitleScene title; 	
	public GameScene game;
	public PauseScene pause;
	public int mode;

	/**
	 * Create the frame.
	 */
	public Frame(Main.GAMESTATE state) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Main.devstream.println("Could not set LnF - "+e.getLocalizedMessage());
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
	
	public void setScene(Main.GAMESTATE state) {
		CardLayout cl = (CardLayout)(getContentPane().getLayout());
		switch(state) {
		case TITLE:
			mode = 0;
			cl.show(getContentPane(), "title");
			Main.devstream.println("Scene - Title");
			break;
		case GAME:
			mode = 1;
			cl.show(getContentPane(), "game");
			Main.devstream.println("Scene - Game");
			break;
		case PAUSE:
			mode = 2;
			cl.show(getContentPane(), "pause");
			Main.devstream.println("Scene - Pause");
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
    }
}
