package de.destiny19.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class UIElement extends JPanel {
	private static final long serialVersionUID = -4493789981435408095L;

	
	public UIElement(int x, int y, int w, int h) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(Color.RED);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				setBackground(Color.GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				setBackground(Color.MAGENTA);
			}
		});
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 0), new Color(255, 250, 205), new Color(255, 215, 0), new Color(255, 165, 0)));
		setForeground(Color.WHITE);
		setBackground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		setBounds(x,y,w,h);
	}
}
