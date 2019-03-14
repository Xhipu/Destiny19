package de.destiny19.ui;

import java.io.File;
import java.io.IOException;

public class UIStaticPanel extends UIElement{
	private static final long serialVersionUID = 1L;

	public UIStaticPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void setPicture(File file) {
		CPicture picture = new CPicture();
		picture.setBounds(5, 5, getWidth()-10, getHeight()-10);
		try {
			picture.setImage(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
