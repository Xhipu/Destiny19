package de.destiny19.scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Main;
import de.destiny19.ui.UIButton;

public class PauseScene extends JPanel {
	private UIButton bnresume, bnsave, bnquit;
	private static final long serialVersionUID = -538876308913834126L;
	private Image imgBg;
	
	
	public PauseScene(Frame parent) throws IOException {
		imgBg = ImageIO.read(new File("./res/Background2.jpg"));
		
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

		bnsave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				Main.mainframe.game.save();
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
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBg, 0, 0, this.getWidth(), this.getHeight(), Main.mainframe);
	}
	
	public void render() {
		repaint();
	}
}
