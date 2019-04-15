package de.destiny19.game;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.destiny19.Injectable;
import de.destiny19.Logger;
import de.destiny19.Main;
import de.destiny19.scenes.GameScene;
import de.destiny19.scenes.PauseScene;
import de.destiny19.scenes.TitleScene;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	@Injectable public TitleScene title;
	@Injectable public GameScene game;
	@Injectable public PauseScene pause;

	public int mode;
	
	public Frame(String strTitle, int nWidth, int nHeight) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(nWidth, nHeight);
		setLocationRelativeTo(null);
		setTitle(strTitle);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Logger.trace("Could not set LnF - "+e.getLocalizedMessage());
		}

		getContentPane().setLayout(new CardLayout(0, 0));
	}
	
	public void setScene(Main.GAMESTATE state) {
		CardLayout cl = (CardLayout)(getContentPane().getLayout());
		switch(state) {
		case TITLE:
			mode = 0;
			cl.show(getContentPane(), "title");
			break;
		case GAME:
			mode = 1;
			cl.show(getContentPane(), "game");
			break;
		case PAUSE:
			mode = 2;
			cl.show(getContentPane(), "pause");
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

	public void initTitle(TitleScene title) {
		this.title = title;
		getContentPane().add(title, "title");
	}

	public void initGame(GameScene game) {
		this.game = game;
		getContentPane().add(game, "game");
	}

	public void initPause(PauseScene pause) {
		this.pause = pause;
		getContentPane().add(pause, "pause");
	}
}
