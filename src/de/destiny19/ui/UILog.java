package de.destiny19.ui;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.util.ArrayList;

public class UILog extends UIElement{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel m_label;

	public UILog(int x, int y, int w, int h) {
		super(x, y, w, h);
		super.setBackground(Color.BLACK);

		m_label = new JLabel();
		m_label.setBounds(getBounds());
		m_label.setHorizontalTextPosition(SwingConstants.CENTER);

		add(m_label);
	}

	public void log(String strMessage, int nType){
		String strType = "[GAME] ";
		switch(nType){
			case 0: //NORMAL
				m_label.setForeground(Color.WHITE);
				break;
			case 1: //GOOD
				m_label.setForeground(Color.GREEN);
				break;
			case 2: //BAD
				m_label.setForeground(Color.RED);
				break;
			case 3: //DROP
				m_label.setForeground(Color.GRAY);
				break;
			default: //DEBUG
				m_label.setForeground(Color.ORANGE);
				strType = "[DEBUG] ";
				break;
		}
		m_label.setText(strType+strMessage);
	}
}
