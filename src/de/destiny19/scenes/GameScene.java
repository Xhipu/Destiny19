package de.destiny19.scenes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Main;
import de.destiny19.game.Timer;
import de.destiny19.player.Player;
import de.destiny19.ui.UIButton;
import de.destiny19.ui.UILog;
import de.destiny19.ui.UIStaticPanel;
import de.destiny19.player.PlayerInventory;
import de.destiny19.player.XMLParser;

public class GameScene extends JPanel {
	private static final long serialVersionUID = 7486454402469771687L;
	private UIButton bnPause;
	private UIStaticPanel pnEnemy, pnEnemyStats, pnPlayer, pnPlayerStats, pnSkills;
	public UILog console;

	public Player player = new Player(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	public PlayerInventory inv;
	
	public GameScene(Frame parent) {
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		

		@SuppressWarnings({ "serial", "unused" })
		Action actClose = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.setScene(Main.GAMESTATE.PAUSE);
			}
			
		};
    
		pnEnemy = new UIStaticPanel(50, 50, 350, 350); //+200
		pnEnemyStats = new UIStaticPanel(50, 450, 350, 250);
		pnPlayer = new UIStaticPanel(600, 50, 350, 350);
		pnPlayerStats = new UIStaticPanel(600, 450, 350, 250);
		pnSkills = new UIStaticPanel(450, 50, 100, 650);
		console = new UILog(950, 565, getWidth()-955, getHeight()-600);
		
		bnPause = new UIButton("II", getWidth()-65, 0, 60, 60);
		bnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				parent.setScene(Main.GAMESTATE.PAUSE);
			}
		});
		
		add(bnPause);
		add(pnEnemy);
		add(pnEnemyStats);
		add(pnPlayer);
		add(pnPlayerStats);
		add(pnSkills);
		add(console);
	}
	
	public void processInput() {
		
	}
	
	public void updateGameState() {
		//player.getTimer().destroy();
		player.getTimer().perform();
	}

	public void render() {
		repaint();
	}
	
	public Player getPlayer() {
		return player;
	}

	public void save() {
		XMLParser xml = new XMLParser();
		try{
			xml.savePlayer();
			xml.saveInventory();
		}catch (Exception e) {
			Main.devstream.println("Save failed");
			Main.devstream.println(e);

		}

	}
}
