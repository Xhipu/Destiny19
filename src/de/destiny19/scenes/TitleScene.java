package de.destiny19.scenes;

//import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Main;
import de.destiny19.ui.UIButton;

public class TitleScene extends JPanel {
	private UIButton bnnew, bnload, bnquit;
	private static final long serialVersionUID = -538876308913834126L;
	//private Canvas canvas;
	
	public TitleScene(Frame parent) {
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		
		bnnew=new UIButton("New", 
				(int)getBounds().getCenterX()-300, 70,
				600, 150 );
		bnload=new UIButton("Load", 
				(int)getBounds().getCenterX()-300, 270,
				600, 150 );
		bnquit=new UIButton("Quit", 
				(int)getBounds().getCenterX()-300, 480,
				600, 150 );
		
		bnnew.addMouseListener(new MouseAdapter() {
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
		
		add(bnnew);
		add(bnload);
		add(bnquit);
		
	}
	
	public void render() {
		repaint();
	}
}
