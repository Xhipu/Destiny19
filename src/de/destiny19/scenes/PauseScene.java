package de.destiny19.scenes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Main;
import de.destiny19.ui.UIButton;

public class PauseScene extends JPanel {
	private UIButton bnresume, bnsave, bnquit;
	private static final long serialVersionUID = -538876308913834126L;
	//private Canvas canvas;
	
	public PauseScene(Frame parent) {
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		
		bnresume=new UIButton("Resume", 
				(int)getBounds().getCenterX()-300, 70,
				600, 150 );
		bnsave=new UIButton("Save", 
				(int)getBounds().getCenterX()-300, 270,
				600, 150 );
		bnquit=new UIButton("Quit", 
				(int)getBounds().getCenterX()-300, 480,
				600, 150 );
		
		bnresume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				parent.setScene(Main.GAMESTATE.GAME);
			}
		});
		
		bnquit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				System.exit(0);
			}
		});
		
		add(bnresume);
		add(bnsave);
		add(bnquit);
		
	}
	
	public void render() {
		repaint();
	}
}
