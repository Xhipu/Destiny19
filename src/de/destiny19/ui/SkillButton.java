package de.destiny19.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class SkillButton extends Button {

	private Image myImage;
	private File imgFile;
	
	public SkillButton(int x, int y, int w, int h) {
		super("", x, y, w, h);
		
	}
	
	@Override public void paintComponent(Graphics g) {
		if(myImage != null) {
			g.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	public void setImage(File file) throws IOException {
		imgFile = file;
		myImage = ImageIO.read(imgFile);
		repaint();
	}
	
	public void removeImage() {
		myImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		repaint();
	}
	
	public File getImage() {
		return imgFile;
	}
}
