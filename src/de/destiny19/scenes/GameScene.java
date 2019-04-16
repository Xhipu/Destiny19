package de.destiny19.scenes;

import java.awt.*;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.destiny19.GameObjectInjector;
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
	public Log console;
	private Image imgBg;
	private Picture imgPlayer, imgEnemy;
	private ValueBar playerHp, playerMp, enemyHp;
	private JLabel lbPlayerStats, lbEnemyStats;
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
		bnSkillA.setImage(new File("./res/icons/bomb.png"));
		
		bnSkillB = new SkillButton(10, 110, 80, 80);
		bnSkillB.setImage(new File("./res/icons/feather.png"));
		
		bnSkillC = new SkillButton(10, 210, 80, 80);
		bnSkillC.setImage(new File("./res/icons/belt.png"));
		
		bnSkillD = new SkillButton(10, 310, 80, 80);
		bnSkillD.setImage(new File("./res/icons/bronze_coin.png"));
		
		imgPlayer = new Picture();
		imgPlayer.setBounds(20, 20, 310, 310);
		imgPlayer.setImage(new File("./res/pipo-player.png"));
		
		imgEnemy = new Picture();
		imgEnemy.setBounds(20, 20, 310, 310);
		
		playerHp = new ValueBar(1, 1, 10, 10, 330, 50);
		playerHp.setBarColor(Color.green);
		playerHp.setBgColor(Color.DARK_GRAY);
		
		playerMp = new ValueBar(1, 1, 10, 80, 330, 50);
		playerMp.setBarColor(Color.blue);
		playerMp.setBgColor(Color.DARK_GRAY);
		
		enemyHp = new ValueBar(1, 1, 10, 10, 330, 50);
		enemyHp.setBarColor(Color.RED);
		enemyHp.setBgColor(Color.DARK_GRAY);
		
		lbPlayerStats = new JLabel();
		lbPlayerStats.setBounds(10, 150, 330, 50);
		lbPlayerStats.setForeground(Color.WHITE);
		
		lbEnemyStats = new JLabel();
		lbEnemyStats.setBounds(10, 150, 330, 50);
		lbEnemyStats.setForeground(Color.WHITE);
		
		pnSkills.add(bnSkillA);
		pnSkills.add(bnSkillB);
		pnSkills.add(bnSkillC);
		pnSkills.add(bnSkillD);
		pnPlayer.add(imgPlayer);
		pnEnemy.add(imgEnemy);
		pnPlayerStats.add(playerHp);
		pnPlayerStats.add(playerMp);
		pnEnemyStats.add(enemyHp);
		pnPlayerStats.add(lbPlayerStats);
		pnEnemyStats.add(lbEnemyStats);
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
					getInstances().add(new Enemy(player.getLevel()));
					try {
						imgEnemy.setImage(GameObjectInjector.GetRandomEnemyPicture());
					} catch(IOException e) {
						Logger.trace(String.format("Error while loading image file: %s", e.getMessage()));
						imgEnemy.removeImage();
					}
					Logger.trace("New enemy spawned");
				}
			}
		};
		
		
		parent.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent ke) {
				int nSrc = ke.getKeyCode();

				if(nSrc == KeyEvent.VK_1 || nSrc == KeyEvent.VK_NUMPAD1){
					if(bnSkillA.isActive())	player.useSkill(1);
				}
				else if(nSrc == KeyEvent.VK_2 || nSrc == KeyEvent.VK_NUMPAD2){
					if(bnSkillB.isActive())	player.useSkill(2);
				}
				else if(nSrc == KeyEvent.VK_3 || nSrc == KeyEvent.VK_NUMPAD3){
					if(bnSkillC.isActive()) player.useSkill(3);
				}
				else if(nSrc == KeyEvent.VK_4 || nSrc == KeyEvent.VK_NUMPAD4){
					if(bnSkillD.isActive()) player.useSkill(4);
				}

				else if(parent.mode == 1) {
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
	
	@Override public void paintComponent(Graphics _g) {
		super.paintComponent(_g);
		Graphics2D g = (Graphics2D)_g;

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
		
		lbPlayerStats.setText(String.format("<html><p>Level: %d<br>Strength: %d</p></html>", player.getLevel(), player.getStrength()));
		
		try {
			Enemy en = enemySpawn.getInstances().get(0);
			enemyHp.setValue(en.getMaxHp(), en.getHP());
			lbEnemyStats.setText(String.format("<html><p>Level: %d<br>Strength: %d</p></html>", en.getLevel(), en.getDmg()));
		} catch(Exception e) {return;}
		
		if(player.isBerserk()) {
			playerHp.setBarColor(Color.orange);
		}
		else {
			playerHp.setBarColor(Color.green);
		}
	}

	public void updateGameState() {
		enemySpawn.spawn();
		
		if(enemySpawn.getInstances().isEmpty())
			return;
		
		Iterator<Enemy> iterator = enemySpawn.getInstances().iterator();
		while(iterator.hasNext()) {
			Enemy en = iterator.next();
			int nXP = 10+en.getLevel() - 1;
			if(en.getHP() <= 0) {
				player.addEP(nXP);
				Main.GetGameConsole().log(String.format("Earned %d XP", nXP), 1);
				enemySpawn.getTimer().step = enemySpawn.getTimer().getTaskDuration();
				enemySpawn.spawn();
				iterator.remove();
			}
			else 
				en.getTimer().perform();
		}

		bnSkillA.setActive(true);
		bnSkillB.setActive(true);
		bnSkillC.setActive(true);
		bnSkillD.setActive(true);

		if(player.isSkillA()){bnSkillA.setActive(false);}
		if(player.isSkillB()){bnSkillB.setActive(false);}
		if(player.isSkillC()){bnSkillC.setActive(false);}
		if(player.isSkillD()){bnSkillD.setActive(false);}

		player.getTimer().perform();
		player.m_heal.perform();
	}

	public void render() {
		repaint();
	}
	
	public Player getPlayer() {
		return player;
	}

	void save() {
		XMLParser xml = new XMLParser();
		try{
			xml.savePlayer();
			xml.saveInventory();
		}catch (Exception e) {
			Logger.trace("Save failed");
			Logger.trace(e.getMessage());
		}

	}
}
