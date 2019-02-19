package de.destiny19.scenes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Game;
import de.destiny19.game.IGame;
import de.destiny19.ui.UIButton;

public class GameScene extends JPanel implements IGame {
	private static final long serialVersionUID = 7486454402469771687L;
	private Canvas canvas;
	private UIButton bnPause;
	
	public GameScene(Frame parent) {
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		
		canvas = new Canvas();
		canvas.setSize(getSize());
		
		bnPause = new UIButton("II", getWidth()-65, 0, 60, 60);
		bnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				parent.setScene(Game.GAMESTATE.PAUSE);
			}
		});
		
		//add(canvas);
		add(bnPause);
	}
	
	public void processInput() {
		
	}
	
	public void updateGameState() {
		
	}

	public void render() {
		repaint();
	}

	
}
