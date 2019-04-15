package de.destiny19.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ValueBar extends Element{
	
	private Color clBarColor, clBgColor;
	private int m_nValue, m_nMaxValue;
	private JLabel lbText;
	
	public ValueBar(int nStartValue, int nMaxValue, int x, int y, int w, int h) {
		super(x, y, w, h);
		m_nValue = nStartValue;
		m_nMaxValue = nMaxValue;
		
		lbText = new JLabel();
		lbText.setForeground(Color.WHITE);
		lbText.setBounds(x, y, w, h);
		lbText.setHorizontalTextPosition(SwingConstants.CENTER);
		lbText.setVerticalTextPosition(SwingConstants.CENTER);
		add(lbText);
		
	}

	public Color getBarColor() {
		return clBarColor;
	}

	public void setBarColor(Color clBarColor) {
		this.clBarColor = clBarColor;
	}

	public Color getBgColor() {
		return clBgColor;
	}

	public void setBgColor(Color clBgColor) {
		this.clBgColor = clBgColor;
	}
	
	@Override public void paintComponent(Graphics _g) {
		Graphics2D g = (Graphics2D)_g;
		g.setColor(getBgColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getBarColor());
		
		int nBarWidth = (m_nValue * getWidth()) / m_nMaxValue;
		
		try {
			g.fillRect(0, 0, nBarWidth, getHeight());
		} catch(Exception e) {
			g.fillRect(0, 0, 0, getHeight());
		}
	}
	
	public void setValue(int nMaxValue, int nValue) {
		m_nMaxValue = nMaxValue;
		m_nValue = nValue;
		lbText.setText(String.format("%d / %d", nValue, nMaxValue));
		repaint();
	}
}
