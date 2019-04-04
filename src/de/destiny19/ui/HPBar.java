package de.destiny19.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HPBar extends JPanel {
	private int m_nHp;
	
	@Override public void paintComponent(Graphics _g) {
		Graphics2D g = (Graphics2D)_g;
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 100, 50);
		
		Color clHp = Color.green;		
		g.setColor(clHp);
		g.fillRect(1, 1, 100 * (1 / m_nHp), 50-2);
		g.dispose();
	}
	
	public void setHP(int hp) {
		m_nHp = hp;
		repaint();
	}
}
