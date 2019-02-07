package de.destiny19.ui;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UIButton extends UIElement {
	private static final long serialVersionUID = 1603212344675060032L;

	public UIButton(String label, int x, int y, int w, int h) {
		super(x,y,w,h);
		
		JLabel lblText = new JLabel(label);
		lblText.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 35));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setForeground(new Color(255, 255, 255));
		add(lblText, BorderLayout.CENTER);
	}
}
