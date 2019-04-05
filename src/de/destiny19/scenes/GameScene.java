package de.destiny19.scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Main;
import de.destiny19.logic.Enemy;
import de.destiny19.logic.Spawner;
import de.destiny19.player.Player;
import de.destiny19.ui.Button;
import de.destiny19.ui.Log;
import de.destiny19.ui.StaticPanel;
import de.destiny19.player.PlayerInventory;
import de.destiny19.player.XMLParser;

public class GameScene extends JPanel {
	private static final long serialVersionUID = 7486454402469771687L;
	private Button bnPause;
	private StaticPanel pnEnemy, pnEnemyStats, pnPlayer, pnPlayerStats, pnSkills;
	public Log console;
	private Image imgBg;

	public Player player;
	public PlayerInventory inv;
	public Spawner<Enemy> enemySpawn;
	
	public GameScene(Frame parent) throws IOException {
		imgBg = ImageIO.read(new File("./res/Background.jpg"));
		
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
    
		pnEnemy = new StaticPanel(50, 50, 350, 350); //+200
		pnEnemyStats = new StaticPanel(50, 450, 350, 250);
		pnPlayer = new StaticPanel(600, 50, 350, 350);
		pnPlayerStats = new StaticPanel(600, 450, 350, 250);
		pnSkills = new StaticPanel(450, 50, 100, 650);
		console = new Log(950, 565, getWidth()-955, getHeight()-600);
		
		bnPause = new Button("II", getWidth()-65, 0, 60, 60);
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
		
		enemySpawn = new Spawner<Enemy>(300) {
			@Override public void addInstance() {
				
				if(getInstances().isEmpty()) {
					getInstances().add(new Enemy(1));
					Main.devstream.println("New enemy spawned");
				}
			}
		};
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBg, 0, 0, this.getWidth(), this.getHeight(), Main.mainframe);
		g.setColor(Color.CYAN);
		int hpBarWidth = (player.GetAktEP() * getWidth()) / player.GetEP();
		
		try {
			g.fillRect(0, getHeight()-10, hpBarWidth, 10);
		} catch(Exception e) {
			g.fillRect(0, getHeight()-10, 0, 10);
		}
	}
	
	public void processInput() {
		
	}
	
	public void updateGameState() {
		enemySpawn.spawn();
		
		if(enemySpawn.getInstances().isEmpty())
			return;
		
		Iterator<Enemy> iter = enemySpawn.getInstances().iterator();
		while(iter.hasNext()) {
			Enemy en = iter.next();
			if(en.getHP()-2 < -20) {
				player.AddEP(10);
				Main.getGameConsole().log(String.format("Earned %d XP", 10), 1);
				iter.remove();
				enemySpawn.spawn();
			}
			else 
				en.getTimer().perform();
		}
		
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
