package de.destiny19.scenes;

//import java.awt.Canvas;
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
import de.destiny19.player.XMLParser;
import de.destiny19.game.Main;
import de.destiny19.ui.Button;
import de.destiny19.player.Player;
import de.destiny19.player.PlayerInventory;


public class TitleScene extends JPanel {
	private Button bnnew, bnload, bnquit;
	private static final long serialVersionUID = -538876308913834126L;
	private static XMLParser xml;
	private Image imgBg;

	//private Canvas canvas;
	
	public TitleScene(Frame parent) throws IOException {
		imgBg = ImageIO.read(new File("./res/Background2.jpg"));
		
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		
		bnnew=new Button("New", 
				(int)getBounds().getCenterX()-300, 70,
				600, 150 );
		bnload=new Button("Load", 
				(int)getBounds().getCenterX()-300, 270,
				600, 150 );
		bnquit=new Button("Quit", 
				(int)getBounds().getCenterX()-300, 480,
				600, 150 );
		
		bnnew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				Main.SetPlayer(new Player(1, 0, 0, 100, 0, 100, 100, 100, 100, 2, 1, 0, 1, 1, 1, 1));
				Main.mainframe.game.inv		= new PlayerInventory(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				Main.GetPlayer().initTimer();
				parent.setScene(Main.GAMESTATE.GAME);
			}
		});

		bnload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				//test
				try {
					xml = new XMLParser();
					Main.SetPlayer(xml.loadPlayer());
					Main.mainframe.game.inv = xml.loadInventory();
					Main.GetPlayer().initTimer();
					parent.setScene(Main.GAMESTATE.GAME);
				}catch (Exception e) {
					Main.devstream.println("No player save found!");
				}

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
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBg, 0, 0, this.getWidth(), this.getHeight(), Main.mainframe);
	}
	
	public void render() {
		repaint();
	}
}
