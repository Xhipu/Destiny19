package de.destiny19.scenes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.destiny19.game.Frame;
import de.destiny19.game.Game;
import de.destiny19.ui.UIButton;
import de.destiny19.ui.UILog;
import de.destiny19.ui.UIStaticPanel;

public class GameScene extends JPanel {
	private static final long serialVersionUID = 7486454402469771687L;
	private UIButton bnPause;
	private UIStaticPanel pnEnemy, pnEnemyStats, pnPlayer, pnPlayerStats, pnSkills;
	private UILog pnLog;
	
	public GameScene(Frame parent) {
		setSize(parent.getSize());
		setBackground(Color.BLACK);
		setLayout(null);
		
		pnEnemy = new UIStaticPanel(50, 50, 350, 350); //+200
		pnEnemyStats = new UIStaticPanel(50, 450, 350, 250);
		pnPlayer = new UIStaticPanel(600, 50, 350, 350);
		pnPlayerStats = new UIStaticPanel(600, 450, 350, 250);
		pnSkills = new UIStaticPanel(450, 50, 100, 650);
		pnLog = new UILog(950, 565, getWidth()-955, getHeight()-600);
		
		bnPause = new UIButton("II", getWidth()-65, 0, 60, 60);
		bnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				parent.setScene(Game.GAMESTATE.PAUSE);
			}
		});
		
		add(bnPause);
		add(pnEnemy);
		add(pnEnemyStats);
		add(pnPlayer);
		add(pnPlayerStats);
		add(pnSkills);
		add(pnLog);
	}
	
	public void processInput() {
		
	}
	
	public void updateGameState() {
		
	}

	public void render() {
		repaint();
	}

	
}
