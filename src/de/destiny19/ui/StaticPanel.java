package de.destiny19.ui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class StaticPanel extends Element{
	private static final long serialVersionUID = 1L;

	public StaticPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		setBackground(Color.GRAY);
		setLayout(null);
	}
	
	public void setPicture(File file) {
		Picture picture = new Picture();
		picture.setBounds(5, 5, getWidth()-10, getHeight()-10);
		try {
			picture.setImage(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
