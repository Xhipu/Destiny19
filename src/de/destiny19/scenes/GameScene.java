package de.destiny19.scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import de.destiny19.Logger;
import de.destiny19.game.Frame;
import de.destiny19.Main;
import de.destiny19.logic.Enemy;
import de.destiny19.logic.Spawner;
import de.destiny19.player.Player;
import de.destiny19.ui.Button;
import de.destiny19.ui.Log;
import de.destiny19.ui.Picture;
import de.destiny19.ui.SkillButton;
import de.destiny19.ui.StaticPanel;
import de.destiny19.ui.ValueBar;
import de.destiny19.player.PlayerInventory;
import de.destiny19.player.XMLParser;

@SuppressWarnings("serial")
public class GameScene extends JPanel {
	private Button bnPause;
	private StaticPanel pnEnemy, pnEnemyStats, pnPlayer, pnPlayerStats, pnSkills;
	private SkillButton bnSkillA, bnSkillB, bnSkillC, bnSkillD;
	private boolean bSkillUpPossible;
	public Log console;
	private Image imgBg;
	private Picture imgPlayer, imgEnemy;
	private ValueBar playerHp, playerMp, enemyHp;
	public Player player;
	public PlayerInventory inv;
	public Spawner<Enemy> enemySpawn;
	
	public GameScene(Frame parent) throws IOException {
		imgBg = ImageIO.read(new File("./res/Background.jpg"));
		
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		

		@SuppressWarnings("unused")
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
		
		bnSkillA = new SkillButton(10, 10, 80, 80);
		bnSkillA.removeImage();
		bnSkillA.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent me) {
				Main.GetPlayer().useSkill(1);
			}
		});
		
		bnSkillB = new SkillButton(10, 110, 80, 80);
		bnSkillB.removeImage();
		bnSkillB.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent me) {
				Main.GetPlayer().useSkill(2);
			}
		});
		
		bnSkillC = new SkillButton(10, 210, 80, 80);
		bnSkillC.removeImage();
		bnSkillC.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent me) {
				Main.GetPlayer().useSkill(3);
			}
		});
		
		bnSkillD = new SkillButton(10, 310, 80, 80);
		bnSkillD.removeImage();
		bnSkillD.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent me) {
				Main.GetPlayer().useSkill(4);
			}
		});
		
		imgPlayer = new Picture();
		imgPlayer.setBounds(20, 20, 310, 310);
		imgPlayer.removeImage();
		
		imgEnemy = new Picture();
		imgEnemy.setBounds(20, 20, 310, 310);
		imgEnemy.removeImage();
		
		playerHp = new ValueBar(1, 1, 10, 10, 330, 50);
		playerHp.setBarColor(Color.green);
		playerHp.setBgColor(Color.DARK_GRAY);
		
		playerMp = new ValueBar(1, 1, 10, 80, 330, 50);
		playerMp.setBarColor(Color.blue);
		playerMp.setBgColor(Color.DARK_GRAY);
		
		enemyHp = new ValueBar(1, 1, 10, 10, 330, 50);
		enemyHp.setBarColor(Color.RED);
		enemyHp.setBgColor(Color.DARK_GRAY);
		
		pnSkills.add(bnSkillA);
		pnSkills.add(bnSkillB);
		pnSkills.add(bnSkillC);
		pnSkills.add(bnSkillD);
		pnPlayer.add(imgPlayer);
		pnEnemy.add(imgEnemy);
		pnPlayerStats.add(playerHp);
		pnPlayerStats.add(playerMp);
		pnEnemyStats.add(enemyHp);
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
					Logger.trace("New enemy spawned");
				}
			}
		};
		
		
		parent.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent ke) {
				int nSrc = ke.getKeyCode();
				/* DEPRECATED
				 *  if(nSrc == KeyEvent.VK_1 || nSrc == KeyEvent.VK_NUMPAD1) System.out.println("1");
					else if(nSrc == KeyEvent.VK_2 || nSrc == KeyEvent.VK_NUMPAD2) System.out.println("2");
					else if(nSrc == KeyEvent.VK_3 || nSrc == KeyEvent.VK_NUMPAD3) System.out.println("3");
					else if(nSrc == KeyEvent.VK_4 || nSrc == KeyEvent.VK_NUMPAD4) System.out.println("4");
					else System.out.println(nSrc); 
				*/
				if(parent.mode == 1) {
					if(nSrc == KeyEvent.VK_ESCAPE)
						parent.setScene(Main.GAMESTATE.PAUSE);
				//Debug macros
					else if(Main._DEBUG && nSrc == KeyEvent.VK_X)
						player.addEP(100);
				} else if(parent.mode == 2)
					parent.setScene(Main.GAMESTATE.GAME);
			}
		});
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBg, 0, 0, this.getWidth(), this.getHeight(), Main.mainframe);
		g.setColor(Color.CYAN);
		int hpBarWidth = (player.getAktEP() * getWidth()) / player.getEP();
		
		try {
			g.fillRect(0, getHeight()-10, hpBarWidth, 10);
		} catch(Exception e) {
			g.fillRect(0, getHeight()-10, 0, 10);
		}
		
		playerHp.setValue(player.getHP(), player.getAktHP());
		playerMp.setValue(player.getMP(), player.getAktMP());
		
		try {
			Enemy en = enemySpawn.getInstances().get(0);
			enemyHp.setValue(en.getMaxHp(), en.getHP());
		} catch(Exception e) {}
		
		if(player.isBerserk()) {
			playerHp.setBarColor(Color.orange);
		}
		else {
			playerHp.setBarColor(Color.green);
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
			if(en.getHP() <= 0) {
				player.addEP(10);
				Main.GetGameConsole().log(String.format("Earned %d XP", 10), 1);
				enemySpawn.getTimer().step = enemySpawn.getTimer().getTaskDuration();
				enemySpawn.spawn();
				iter.remove();
			}
			else 
				en.getTimer().perform();
		}
		
		if(Main.GetPlayer().getSkillPoints() > 0)
			setSkillUpPossible(true);
		
		player.getTimer().perform();
		player.m_heal.perform();
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
			Logger.trace("Save failed");
			Logger.trace(e.getMessage());

		}

	}

	public boolean isSkillUpPossible()
	{
		return bSkillUpPossible;
	}

	public void setSkillUpPossible(boolean bSkillUpPossible)
	{
		this.bSkillUpPossible = bSkillUpPossible;
	}

	public ValueBar getPlayerMp()
	{
		return playerMp;
	}

	public void setPlayerMp(ValueBar playerMp)
	{
		this.playerMp = playerMp;
	}
}
