package de.destiny19.scenes;

//import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Timer;
import de.destiny19.player.XMLParser;
import de.destiny19.game.Main;
import de.destiny19.ui.UIButton;
import de.destiny19.scenes.GameScene;
import de.destiny19.player.Player;
import de.destiny19.player.PlayerInventory;


public class TitleScene extends JPanel {
	private UIButton bnnew, bnload, bnquit;
	private static final long serialVersionUID = -538876308913834126L;
	private static Player player;
	private static PlayerInventory inv;
	private static XMLParser xml;

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
				Frame.game.player  	= new Player(1, 0, 0, 100, 0,500, 500, 100 , 100, 5, 5, 5, 1, 1, 1, 1);
				Frame.game.inv		= new PlayerInventory(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				parent.setScene(Main.GAMESTATE.GAME);
			}
		});

		bnload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				//test
				try {
					xml = new XMLParser();
					Frame.game.player = xml.loadPlayer();
					Frame.game.player.setTimer(new Timer() {
						@Override
						public void doAction() {
							System.out.println("test");
						}
					});
					Frame.game.player.getTimer().setTaskDuration(30);
					Frame.game.player.getTimer().init();
					Frame.game.inv = xml.loadInventory();
					parent.setScene(Game.GAMESTATE.GAME);
				}catch (Exception e) {
					e.printStackTrace();
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
	
	public void render() {
		repaint();
	}
}
