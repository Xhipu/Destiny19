package de.destiny19.ui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIButton extends UIElement {
	private static final long serialVersionUID = 1603212344675060032L;

	public UIButton(String label, int x, int y, int w, int h) {
		super(x,y,w,h);
		setBorder(null);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(Color.decode("#bb0000"));
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
			public void mouseReleased(MouseEvent e) {
				if ( (e.getX() >= x && e.getX() <= x+w) && (e.getY() >= y && e.getY() <= y+h) ) {
					setBackground(Color.MAGENTA);
				} else {
					setBackground(Color.red);
				}
			}
		});
		
		JLabel lblText = new JLabel(label);
		lblText.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 35));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setForeground(new Color(255, 255, 255));
		add(lblText);
	}
}
